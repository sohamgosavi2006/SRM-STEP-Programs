import java.util.*;

public class frequencyDigit {
    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number ");
        int number = sc.nextInt();
        
        int frequency[] = new int[10];
        
        int temp = Math.abs(number);
        while (temp > 0) {
            int digit = temp % 10;
            frequency[digit]++;
            temp /= 10;
        }
        
        System.out.println("\nDigit Frequency ");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + "is  " + frequency[i]);
            }
        }
        
    }
}
