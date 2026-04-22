
import java.util.*;

public class ZaraBonus {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double oldSalary[] = new double[10];
        int years[] = new int[10];

        double newSalary[] = new double[10];
        double bonus[] = new double[10];

        double totalBonus=0.0,totalOldSalary=0.0,totalNewSalary=0.0;

        System.out.println("Enter Salary And Years of Service");

        for(int i=0;i<oldSalary.length;i++){
            oldSalary[i]=sc.nextDouble();
            years[i]=sc.nextInt();
            if(oldSalary[i]<0 || years[1]<1){
                System.out.println("Invalid Input,Enter Again!");
                i--;
            }
            
        }

        for(int i=0;i<oldSalary.length;i++){
            if(years[i]>5){
                bonus[i] = 0.05 * oldSalary[i];
            }
            if(years[i]<=5){
                bonus[i] = 0.02 * oldSalary[i];
            }
            newSalary[i]=oldSalary[i]+bonus[i];
        }

        for(int i=0;i<oldSalary.length;i++){
            
            totalBonus+=bonus[i];
            totalOldSalary+=oldSalary[i];
            totalNewSalary+=newSalary[i];

        }

        System.out.println("The Total Old Salary = "+totalOldSalary);
        System.out.println("The Total Bonus = "+totalBonus);
        System.out.println("The Total New Salary = "+totalNewSalary);

    }

}
