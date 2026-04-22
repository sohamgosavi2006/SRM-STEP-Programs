import java.util.Scanner;

public class StudentScorecard {
    public static int[][] generateScores(int n) {
        int scores[][] = new int[n][3];
        for(int i=0; i<n; i++)
            for(int j=0; j<3; j++)
                scores[i][j] = (int)(Math.random()*91)+10;
        return scores;
    }
    
    public static double[][] calculateMetrics(int scores[][]) {
        double metrics[][] = new double[scores.length][3];
        for(int i=0; i<scores.length; i++) {
            double total = scores[i][0]+scores[i][1]+scores[i][2];
            metrics[i][0] = total;
            metrics[i][1] = Math.round(total/3.0*100)/100.0;
            metrics[i][2] = Math.round(total/300.0*100*100)/100.0;
        }
        return metrics;
    }
    
    public static String getGrade(double p) {
        if(p>=80) return "A";
        if(p>=70) return "B";
        if(p>=60) return "C";
        if(p>=50) return "D";
        if(p>=40) return "E";
        return "R";
    }
    
    public static void displayScorecard(int scores[][], double metrics[][]) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                         "Student","Phys","Chem","Math","Total","Avg","%");
        for(int i=0; i<scores.length; i++)
            System.out.printf("%-10d %-10d %-10d %-10d %-10.2f %-10.2f %-10.2f%% %s\n",
                             (i+1),scores[i][0],scores[i][1],scores[i][2],
                             metrics[i][0],metrics[i][1],metrics[i][2],getGrade(metrics[i][2]));
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Students: ");
        int n = sc.nextInt();
        int scores[][] = generateScores(n);
        double metrics[][] = calculateMetrics(scores);
        displayScorecard(scores,metrics);
        sc.close();
    }
}