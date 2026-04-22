import java.util.Scanner;

public class Handshakes {
    static Scanner sc = new Scanner(System.in);
    
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
    
    public static void main(String[] args) {
        int students, maxHandshakes;
        
        System.out.print("Enter the number of students: ");
        students = sc.nextInt();
        
        if (students < 0) {
            System.out.println("Number of students cannot be negative!");
        } else {
            maxHandshakes = calculateHandshakes(students);
            System.out.println("Maximum number of handshakes among " + 
                             students + " students is: " + maxHandshakes);
        }
        
    }
}