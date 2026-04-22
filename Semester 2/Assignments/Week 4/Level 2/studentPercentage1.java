
import java.util.*;

public class studentPercentage1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students ");
        int numStudents = sc.nextInt();

        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];
        int[][] marks = new int[numStudents][3];
        String[] subjects = {"Physics", "Chemistry", "Maths"};

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) );

            for (int j = 0; j < 3; j++) {
                while (true) {
                    System.out.print("Enter marks for " + subjects[j]);
                    int mark = sc.nextInt();
                    if (mark < 0) {
                        System.out.println("Enter a positive value.");
                        continue;
                    }
                    marks[i][j] = mark;
                    break;
                }
            }

            int totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300.0) * 100;

            if (percentages[i] >= 90) {
                grades[i] = 'A';
            } else if (percentages[i] >= 80) {
                grades[i] = 'B';
            } else if (percentages[i] >= 70) {
                grades[i] = 'C';
            } else if (percentages[i] >= 60) {
                grades[i] = 'D';
            } else {
                grades[i] = 'F';
            }
        }

        System.out.println("\nStudent Results:");
        System.out.println("S.No | Physics | Chemistry | Maths | Percentage | Grade");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%4d | %7d | %8d | %5d | %10.2f | %c\n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
}
