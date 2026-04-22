import java.util.Scanner;

class CharFrequency {
    public static String[][] findCharFrequency(String text) {
        int[] freq = new int[256];
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 0) {
                count++;
            }
            freq[text.charAt(i)]++;
        }
        String[][] result = new String[count][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = Character.toString((char) i);
                result[index][1] = Integer.toString(freq[i]);
                index++;
            }
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