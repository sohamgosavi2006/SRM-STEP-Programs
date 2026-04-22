import java.util.*;
 
public class RocketLaunch
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       System.out.println("Enter Countdown Value");

        int counter = sc.nextInt();

        while(counter>=1){
            System.out.println(counter);
            counter--;
        }
 
    }
}