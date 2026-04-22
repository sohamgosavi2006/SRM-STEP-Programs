import java.util.Scanner;

class UniqueCharFrequency {
    public static char[] findUniqueChars(String text) {
        char[] chars = text.toCharArray();
        int uniqueCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\0') continue;
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (chars[j] != '\0' && chars[i] == chars[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueCount++;
            }
        }
        char[] unique = new char[uniqueCount];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\0') continue;
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (chars[j] != '\0' && chars[i] == chars[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[index++] = chars[i];
            }
        }
        return unique;
    }

    public static String[][] findCharFrequency(String text) {
        char[] unique = findUniqueChars(text);
        String[][] result = new String[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == unique[i]) {
                    count++;
                }
            }
            result[i][0] = Character.toString(unique[i]);
            result[i][1] = Integer.toString(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        String[][] frequencies = findCharFrequency(text);
        System.out.println("Character frequencies:");
        for (String[] freq : frequencies) {
            System.out.println("'" + freq[0] + "': " + freq[1]);
        }
        sc.close();
    }
}