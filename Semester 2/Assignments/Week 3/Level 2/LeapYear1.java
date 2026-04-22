import java.util.*;
 
public class LeapYear1
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       System.out.println("Enter a Year");

       int year = sc.nextInt();

       if(year<1582){
        System.out.println("Year should be greater than 1581");
        System.exit(0);
       }

       if(year%4==0){
            System.out.println(year + " is Leap Year");
       }
       else if(year%400==0){
            System.out.println(year + " is Leap Year");
       }
       else{
            System.out.println(year + "is not a Leap Year");
       }
 
    }
}