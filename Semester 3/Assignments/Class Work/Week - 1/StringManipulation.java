public class StringManipulation {
    public static void main(String[] args) {
        String s1 = "Java Programming";
        String s2 = new String("Java Programming");
        char[] arr = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        String s3 = new String(arr);

        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // true

        String quote = "Programming Quote:\n\t\"Code is poetry\" - Unknown\n\tPath: C:\\Java\\Projects";
        System.out.println(quote);
    }
}