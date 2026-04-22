import java.util.Scanner;

public class CharFrequency {

    public static String[][] findFrequency(String text) {
        int[] freq = new int[256];
        int n = text.length();

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            freq[c]++;
        }

        String[][] result = new String[n][2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (freq[c] != 0) {
                result[index][0] = String.valueOf(c);
                result[index][1] = String.valueOf(freq[c]);
                freq[c] = 0;
                index++;
            }
        }

        String[][] finalResult = new String[index][2];
        for (int i = 0; i < index; i++) {
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }

        return finalResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] freqArray = findFrequency(text);

        for (int i = 0; i < freqArray.length; i++) {
            System.out.println(freqArray[i][0] + " : " + freqArray[i][1]);
        }

        sc.close();
    }
}