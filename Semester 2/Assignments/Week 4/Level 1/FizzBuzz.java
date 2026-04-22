import java.util.*;
 
public class FizzBuzz
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       System.out.println("Enter Number for FizzBuzz");
        int number = sc.nextInt();
        int index=0;

        String buzzData[] = new String[10];

        if(number<=0)
        {
            System.out.println("Negative Number NOT Allowed");
            System.exit(0);
        }

        for(int i =0;i<=number;i++)
        {

            if(i%3==0){
                buzzData[index] ="Fizz";
                index++;
            }
            else if(i%5==0){
                buzzData[index] ="Buzz";
                index++;
            }
            else if(i%3==0 && i%5==0){
                buzzData[index] ="FizzBuzz";
                index++;
            }

        }

        for(int i=0; i<index;i++){
            System.out.print(buzzData[i]+" ");
        }
 
    }
}