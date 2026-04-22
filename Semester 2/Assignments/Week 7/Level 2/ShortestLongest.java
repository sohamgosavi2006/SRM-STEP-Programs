import java.util.Scanner;

class ShortestLongest {
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] splitIntoWords(String text) {
        int length = findLength(text);
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        int[] spaceIndexes = new int[wordCount + 1];
        spaceIndexes[0] = -1;
        int index = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[index] = length;
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            int start = spaceIndexes[i] + 1;
            int end = spaceIndexes[i + 1];
            String word = "";
            for (int j = start; j < end; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }

    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestLongest(String[][] wordLengths) {
        int shortest = Integer.MAX_VALUE;
        int longest = Integer.MIN_VALUE;
        int shortestIndex = 0;
        int longestIndex = 0;
        for (int i = 0; i < wordLengths.length; i++) {
            int length = Integer.parseInt(wordLengths[i][1]);
            if (length < shortest) {
                shortest = length;
                shortestIndex = i;
            }
            if (length > longest) {
                longest = length;
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        String[] words = splitIntoWords(text);
        String[][] wordLengths = getWordLengths(words);
        int[] indices = findShortestLongest(wordLengths);
        System.out.println("Shortest word: " + wordLengths[indices[0]][0] + " (length: " + wordLengths[indices[0]][1] + ")");
        System.out.println("Longest word: " + wordLengths[indices[1]][0] + " (length: " + wordLengths[indices[1]][1] + ")");
        sc.close();
    }
}