import java.util.Scanner;

public class ArrayIndexErrorDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many names do you want to enter? ");
        int count = input.nextInt();
        input.nextLine();
        
        String[] nameList = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter name #" + (i + 1) + ": ");
            nameList[i] = input.nextLine();
        }
        
        triggerArrayError(nameList);
        handleArrayError(nameList);
        
        input.close();
    }
    
    public static void triggerArrayError(String[] arr) {
        System.out.println(arr[arr.length + 5]);
    }
    
    public static void handleArrayError(String[] arr) {
        try {
            System.out.println(arr[arr.length + 5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Some other runtime error: " + e.getMessage());
        }
    }
}