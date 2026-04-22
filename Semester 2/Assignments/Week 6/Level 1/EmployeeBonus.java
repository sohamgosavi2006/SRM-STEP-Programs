public class EmployeeBonus {
    public static int[][] generateEmployeeData(int n) {
        int data[][] = new int[n][2];
        for(int i=0; i<n; i++) {
            data[i][0] = (int)(Math.random()*90000)+10000;
            data[i][1] = (int)(Math.random()*10);
        }
        return data;
    }
    
    public static double[][] calculateBonus(int emp[][]) {
        double res[][] = new double[emp.length][2];
        for(int i=0; i<emp.length; i++) {
            double rate = emp[i][1]>5 ? 0.05 : 0.02;
            double bonus = emp[i][0]*rate;
            res[i][0] = emp[i][0]+bonus;
            res[i][1] = bonus;
        }
        return res;
    }
    
    public static void displaySummary(int emp[][], double bonuses[][]) {
        double oldSum=0, newSum=0, bonusSum=0;
        for(int i=0; i<emp.length; i++) {
            oldSum += emp[i][0];
            newSum += bonuses[i][0];
            bonusSum += bonuses[i][1];
        }
        System.out.printf("%-10s %-15s %-15s %-10s\n","Emp","Old","New","Bonus");
        for(int i=0; i<emp.length; i++)
            System.out.printf("%-10d %-15d %-15.2f %-10.2f\n",(i+1),emp[i][0],bonuses[i][0],bonuses[i][1]);
        System.out.println("Old Total: "+oldSum);
        System.out.println("New Total: "+newSum);
        System.out.println("Bonus Total: "+bonusSum);
    }
    
    public static void main(String args[]) {
        int emp[][] = generateEmployeeData(10);
        double bonuses[][] = calculateBonus(emp);
        displaySummary(emp,bonuses);
    }
}