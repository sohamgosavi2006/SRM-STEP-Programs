
import java.util.*;

public class EvenOddNumbers {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of values to store");
        int number = sc.nextInt();

        if (number < 1) {
            System.out.println("Enter Number greater than 0");
        }

        int evenNumbers[] = new int[(number / 2) + 1];
        int oddNumbers[] = new int[(number / 2) + 1];

        for(int i = 0 ; i< evenNumbers.length; i++){
            evenNumbers[i]=0;
            oddNumbers[i]=0;
        }

        int oddIndex = 0, evenIndex = 0;

        System.out.println("Enter Numbers into Array");

        int input = 0;
        for (int i = 0; i < number; i++) {
            input = sc.nextInt();

            if(input % 2 ==0){
                evenNumbers[evenIndex]=input;
                evenIndex++;
            }
            else{
                oddNumbers[oddIndex]=input;
                oddIndex++;
            }
        }

        System.out.println("Even Numbers are : ");
        for(int i = 0 ; i< evenIndex; i++){
            System.out.print(evenNumbers[i] + ",");
        }
        System.out.println("");
        System.out.println("Odd Numbers are : ");
        for(int i = 0 ; i< oddIndex; i++){
            System.out.print(oddNumbers[i] + ",");
        }

    }
}
