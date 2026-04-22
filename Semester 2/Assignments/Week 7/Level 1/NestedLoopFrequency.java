import java.util.Scanner;

class NestedLoopFrequency {
    public static String[] findCharFrequency(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\0') continue;
            freq[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] != '\0' && chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '\0';
                }
            }
        }
        int count = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) count++;
        }
        String[] result = new String[count * 2];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (freq[i] > 0) {
                result[index++] = Character.toString(chars[i]);
                result[index++] = Integer.toString(freq[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        String[] frequencies = findCharFrequency(text);
        System.out.println("Character frequencies:");
        for (int i = 0; i < frequencies.length; i += 2) {
            System.out.println("'" + frequencies[i] + "': " + frequencies[i + 1]);
        }
        sc.close();
    }
}