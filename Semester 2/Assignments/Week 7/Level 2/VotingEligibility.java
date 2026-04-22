import java.util.Scanner;

class VotingEligibility {
    public static int[] generateAges(int numStudents) {
        int[] ages = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            ages[i] = (int) (Math.random() * 80) + 10;
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            result[i][1] = (ages[i] >= 18 && ages[i] >= 0) ? "true" : "false";
        }
        return result;
    }

    public static void displayVotingTable(String[][] table) {
        System.out.println("Age\tCan Vote");
        for (String[] row : table) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }
        String[][] votingStatus = checkVotingEligibility(ages);
        displayVotingTable(votingStatus);
        sc.close();
    }
}