import java.util.*;

public class Problem4 {

    static class PlagiarismDetector {
        private final int n;
        private final Map<String, Set<String>> ngramIndex;

        public PlagiarismDetector(int n) {
            this.n = n;
            this.ngramIndex = new HashMap<>();
        }

        public List<String> tokenize(String text) {
            String cleaned = text.toLowerCase().replaceAll("[^a-z0-9\\s]", " ");
            String[] parts = cleaned.trim().split("\\s+");
            return Arrays.asList(parts);
        }

        public List<String> extractNGrams(List<String> words) {
            List<String> ngrams = new ArrayList<>();
            if (words.size() < n) return ngrams;
            for (int i = 0; i <= words.size() - n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j > 0) sb.append(' ');
                    sb.append(words.get(i + j));
                }
                ngrams.add(sb.toString());
            }
            return ngrams;
        }

        public void indexDocument(String docId, String text) {
            List<String> words = tokenize(text);
            List<String> ngrams = extractNGrams(words);
            for (String ngram : ngrams) {
                ngramIndex.computeIfAbsent(ngram, k -> new HashSet<>()).add(docId);
            }
        }

        public Map<String, Integer> analyzeDocument(String docId, String text) {
            List<String> words = tokenize(text);
            List<String> ngrams = extractNGrams(words);
            Map<String, Integer> matchCounts = new HashMap<>();

            for (String ngram : ngrams) {
                Set<String> docs = ngramIndex.get(ngram);
                if (docs == null) continue;
                for (String otherDoc : docs) {
                    if (otherDoc.equals(docId)) continue;
                    matchCounts.merge(otherDoc, 1, Integer::sum);
                }
            }

            return matchCounts;
        }

        public double similarityPercent(int matchingNgrams, int totalNgrams) {
            if (totalNgrams == 0) return 0.0;
            return (matchingNgrams * 100.0) / totalNgrams;
        }

        public String mostSimilarDocument(String docId, String text) {
            List<String> words = tokenize(text);
            List<String> ngrams = extractNGrams(words);
            int totalNgrams = ngrams.size();
            Map<String, Integer> matches = analyzeDocument(docId, text);

            String bestDoc = null;
            double bestScore = 0.0;

            for (Map.Entry<String, Integer> e : matches.entrySet()) {
                double score = similarityPercent(e.getValue(), totalNgrams);
                if (score > bestScore) {
                    bestScore = score;
                    bestDoc = e.getKey();
                }
            }

            if (bestDoc == null) return "No similar documents found";
            return String.format("Most similar: %s (%.2f%%)", bestDoc, bestScore);
        }
    }

    public static void main(String[] args) {
        PlagiarismDetector detector = new PlagiarismDetector(5);

        String essay089 = "This is a sample essay about data structures and algorithms used in computer science courses.";
        String essay092 = "This essay explains data structures and algorithms in detail and is very similar to other student essays.";
        String essay123 = "This essay explains data structures and algorithms in detail and is very similar to other student essays.";

        detector.indexDocument("essay_089.txt", essay089);
        detector.indexDocument("essay_092.txt", essay092);

        List<String> tokens123 = detector.tokenize(essay123);
        List<String> ngrams123 = detector.extractNGrams(tokens123);
        System.out.println("analyzeDocument(\"essay_123.txt\")");
        System.out.println("→ Extracted " + ngrams123.size() + " n-grams");

        Map<String, Integer> matches = detector.analyzeDocument("essay_123.txt", essay123);
        int totalNgrams = ngrams123.size();

        for (Map.Entry<String, Integer> e : matches.entrySet()) {
            double sim = detector.similarityPercent(e.getValue(), totalNgrams);
            String label = sim >= 60.0 ? " (PLAGIARISM DETECTED)" : sim >= 15.0 ? " (suspicious)" : "";
            System.out.printf("→ Found %d matching n-grams with \"%s\"\n", e.getValue(), e.getKey());
            System.out.printf("→ Similarity: %.1f%%%s\n", sim, label);
        }

        System.out.println(detector.mostSimilarDocument("essay_123.txt", essay123));
    }
}