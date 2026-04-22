
import java.util.*;

public class NumbersCheck {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double numbers[] = new double[10];

        for(int i = 0 ; i< numbers.length; i++){
            numbers[i]=0;
        }

        double total = 0.0;
        int index = 0;

        System.out.println("Enter Numbers");
        while (true) { 
            numbers[index] = sc.nextDouble();

            if(numbers[index]==0 || numbers[index] <0 || index==10)
                break;

            index++;
        }

        System.out.println("All Numbers are -> ");
        for(int i = 0 ; i< numbers.length; i++){
            total += numbers[i];
            System.out.print(numbers[i] + ",");
        }

        System.out.println("Sum of Numbers is = " + total);

    }
}
