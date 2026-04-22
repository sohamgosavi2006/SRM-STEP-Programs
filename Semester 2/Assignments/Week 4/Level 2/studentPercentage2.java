import java.util.*;

public class studentPercentage2 {
    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        
        int[][] marks = new int[numStudents][3];
        double[] percentage = new double[numStudents];
        char[] grade = new char[numStudents];
        
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                do {
                    System.out.print("Enter marks for " + subject + " for student " + (i + 1) );
                    marks[i][j] = sc.nextInt();
                } while (marks[i][j] < 0 || marks[i][j] > 100);
            }
        }
        
        for (int i = 0; i < numStudents; i++) {
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 80) grade[i] = 'B';
            else if (percentage[i] >= 70) grade[i] = 'C';
            else if (percentage[i] >= 60) grade[i] = 'D';
            else grade[i] = 'F';
        }
                
        System.out.println("\nStudent Details:");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-10d %-10d %-10d %-10.2f %-10c\n", marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }
    }
}
