import java.util.*;
 
public class Voting
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       int age[] = new int[10];

       System.out.println("Enter Age for 10 people");

       for(int i =0 ; i< age.length ;i++){
            age[i] = sc.nextInt();

            if(age[i]<0)
                System.out.println("Invalid Age");
            else if(age[i]<18)
                System.out.println("The student with the age "+ age[i] +"CANNOT vote.");
            else{
                System.out.println("The student with the age "+ age[i] +"CAN vote.");
            }
       }


 
    }
}