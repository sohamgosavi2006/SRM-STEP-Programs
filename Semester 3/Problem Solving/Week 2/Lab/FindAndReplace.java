import java.util.Scanner;

public class FindAndReplace {

    public static int[] findOccurrences(String text, String find) {
        int index = text.indexOf(find);
        int count = 0;

        while (index != -1) {
            count++;
            index = text.indexOf(find, index + find.length());
        }

        int[] positions = new int[count];
        index = text.indexOf(find);
        int i = 0;
        while (index != -1) {
            positions[i] = index;
            i++;
            index = text.indexOf(find, index + find.length());
        }

        return positions;
    }

    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - find.length() && text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static boolean compareWithBuiltIn(String text, String find, String replace) {
        String manual = manualReplace(text, find, replace);
        String builtin = text.replace(find, replace);
        return manual.equals(builtin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the main text:");
        String text = sc.nextLine();

        System.out.println("Enter the substring to find:");
        String find = sc.nextLine();

        System.out.println("Enter the substring to replace with:");
        String replace = sc.nextLine();

        int[] positions = findOccurrences(text, find);
        System.out.print("Occurrences found at positions: ");
        for (int pos : positions) {
            System.out.print(pos + " ");
        }
        System.out.println();

        String manualResult = manualReplace(text, find, replace);
        System.out.println("Manual Replace Result: " + manualResult);

        String builtinResult = text.replace(find, replace);
        System.out.println("Built-in Replace Result: " + builtinResult);

        boolean same = compareWithBuiltIn(text, find, replace);
        System.out.println("Do both results match? " + same);

        sc.close();
    }
}
