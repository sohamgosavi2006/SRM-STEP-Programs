
import java.util.*;

public class NaturalNumber {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First 10 Natural Numbers");

        int naturalNumbers[]= new int[10]; // declaring Array

        for (int i = 0; i < naturalNumbers.length; i++) {
                naturalNumbers[i]= sc.nextInt();
                if(naturalNumbers[i]<1){
                    System.out.println("The number "+naturalNumbers[i]+" is not a natural number");
                    i--;
                }
        }


        double naturalSum = (naturalNumbers.length * (naturalNumbers.length+1))/2;

        System.out.println("The sum of "+naturalNumbers.length+" natural numbers is " + naturalSum);

    }
}
