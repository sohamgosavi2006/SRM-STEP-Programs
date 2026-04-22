import java.util.*;
 
public class MultipleNumber
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       System.out.println("Enter a Number");

        int number = sc.nextInt();

        for(int i=100 ; i>0;i--){
            if(i%number==0){
                System.out.println(i);
            }
        }
 
    }
}