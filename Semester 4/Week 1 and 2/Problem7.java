import java.util.*;

public class Problem7 {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd;
        String query;
        int freq;
    }

    static class AutocompleteSystem {
        private final TrieNode root;
        private final Map<String, Integer> globalFreq;
        private final Map<String, List<String>> prefixCache;
        private final int cacheSize;

        public AutocompleteSystem() {
            root = new TrieNode();
            globalFreq = new HashMap<>();
            prefixCache = new HashMap<>();
            cacheSize = 10000;
        }

        public void addQuery(String query, int freq) {
            globalFreq.put(query, globalFreq.getOrDefault(query, 0) + freq);
            insertIntoTrie(query, globalFreq.get(query));
            prefixCache.clear();
        }

        private void insertIntoTrie(String query, int freq) {
            TrieNode node = root;
            for (char c : query.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.isEnd = true;
            node.query = query;
            node.freq = freq;
        }

        public List<String> search(String prefix) {
            if (prefixCache.containsKey(prefix)) {
                return prefixCache.get(prefix);
            }

            List<TrieNode> nodes = new ArrayList<>();
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                node = node.children.get(c);
                if (node == null) {
                    List<String> empty = Collections.emptyList();
                    if (prefixCache.size() < cacheSize) prefixCache.put(prefix, empty);
                    return empty;
                }
            }
            collect(node, nodes);

            PriorityQueue<TrieNode> pq = new PriorityQueue<>(
                    (a, b) -> a.freq == b.freq
                            ? a.query.compareTo(b.query)
                            : Integer.compare(b.freq, a.freq)
            );
            pq.addAll(nodes);

            List<String> res = new ArrayList<>();
            int k = 10;
            while (!pq.isEmpty() && k-- > 0) {
                res.add(pq.poll().query);
            }

            if (prefixCache.size() < cacheSize) prefixCache.put(prefix, res);
            return res;
        }

        private void collect(TrieNode node, List<TrieNode> out) {
            if (node.isEnd) out.add(node);
            for (TrieNode child : node.children.values()) {
                collect(child, out);
            }
        }

        public void updateFrequency(String query) {
            int newFreq = globalFreq.getOrDefault(query, 0) + 1;
            globalFreq.put(query, newFreq);
            insertIntoTrie(query, newFreq);
            prefixCache.clear();
        }

        public String suggestCorrection(String term) {
            String best = null;
            int bestDist = Integer.MAX_VALUE;

            for (String q : globalFreq.keySet()) {
                int d = editDistance(term, q);
                if (d < bestDist || (d == bestDist && (best == null || globalFreq.get(q) > globalFreq.get(best)))) {
                    bestDist = d;
                    best = q;
                }
                if (bestDist == 1) break;
            }

            if (bestDist <= 2) return best;
            return null;
        }

        private int editDistance(String a, String b) {
            int n = a.length(), m = b.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i <= n; i++) dp[i][0] = i;
            for (int j = 0; j <= m; j++) dp[0][j] = j;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                                          Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
            return dp[n][m];
        }
    }

    public static void main(String[] args) {
        AutocompleteSystem ac = new AutocompleteSystem();

        ac.addQuery("java tutorial", 1_234_567);
        ac.addQuery("javascript", 987_654);
        ac.addQuery("java download", 456_789);
        ac.addQuery("java 21 features", 1_000);
        ac.addQuery("java 8 features", 50_000);
        ac.addQuery("java interview questions", 120_000);

        System.out.println("search(\"jav\") →");
        List<String> sugg = ac.search("jav");
        int rank = 1;
        for (String s : sugg) {
            System.out.println(rank + ". \"" + s + "\" (" + ac.globalFreq.get(s) + " searches)");
            rank++;
        }

        System.out.println();
        System.out.println("updateFrequency(\"java 21 features\") →");
        ac.updateFrequency("java 21 features");
        ac.updateFrequency("java 21 features");
        ac.updateFrequency("java 21 features");
        System.out.println("\"java 21 features\" frequency: " + ac.globalFreq.get("java 21 features"));

        System.out.println();
        String typo = "jvaa tutrial";
        String correction = ac.suggestCorrection(typo);
        System.out.println("suggestCorrection(\"" + typo + "\") → " + correction);
    }
}