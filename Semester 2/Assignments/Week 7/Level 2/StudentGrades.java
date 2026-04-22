import java.util.Scanner;

class StudentGrades {
    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int) (Math.random() * 100);
            }
        }
        return scores;
    }

    public static double[][] calculateMetrics(int[][] scores) {
        double[][] metrics = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            metrics[i][0] = Math.round(total * 100.0) / 100.0;
            metrics[i][1] = Math.round(average * 100.0) / 100.0;
            metrics[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return metrics;
    }

    public static String[][] calculateGrades(double[][] metrics) {
        String[][] grades = new String[metrics.length][1];
        for (int i = 0; i < metrics.length; i++) {
            double percentage = metrics[i][2];
            if (percentage >= 80) {
                grades[i][0] = "A";
            } else if (percentage >= 70) {
                grades[i][0] = "B";
            } else if (percentage >= 60) {
                grades[i][0] = "C";
            } else if (percentage >= 50) {
                grades[i][0] = "D";
            } else if (percentage >= 40) {
                grades[i][0] = "E";
            } else {
                grades[i][0] = "R";
            }
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] metrics, String[][] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2] + "\t" +
                    metrics[i][0] + "\t" + metrics[i][1] + "\t" + metrics[i][2] + "%\t\t" + grades[i][0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] scores = new int[10][3];
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter scores for student " + (i + 1) + ":");
            System.out.print("Physics: ");
            scores[i][0] = sc.nextInt();
            System.out.print("Chemistry: ");
            scores[i][1] = sc.nextInt();
            System.out.print("Maths: ");
            scores[i][2] = sc.nextInt();
        }
        double[][] metrics = calculateMetrics(scores);
        String[][] grades = calculateGrades(metrics);
        displayScorecard(scores, metrics, grades);
        sc.close();
    }
}