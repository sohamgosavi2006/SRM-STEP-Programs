import java.util.*;
 
public class OddEvenNumber
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       System.out.println("Enter a Positive Number");

       int number = sc.nextInt();

       if(number<1){
        System.err.println("Negative Number");
        System.exit(0);
       }

       for(int i=1;i<number;i++){
            if(i%2==0){
                System.out.println(i+" is Even Number");
            }
            else{
               System.out.println(i+" is Odd Number");

            }
       }
 
    }
}