import java.util.*;
 
public class DivideChocolates
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       int numberOfChocolates = sc.nextInt();
       int numberOfChildren = sc.nextInt();

       int childrenChocolates =numberOfChocolates/numberOfChildren;

       int remainingChocolates = numberOfChocolates%numberOfChildren;

       System.out.println("The number of chocolates each child gets is "+
       childrenChocolates+" and the number of remaining chocolates are"
       + remainingChocolates);
 
    }
}