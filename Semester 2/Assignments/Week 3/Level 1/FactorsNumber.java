import java.util.*;
 
public class FactorsNumber
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       System.out.println("Enter a Number");

        int number = sc.nextInt();

        System.out.println("Factors -> ");
        for(int i=1;i<=number;i++){
            if(number%i==0){
                System.out.println(i);
            }
        }
 
    }
}