import java.util.*;

public class SideSquare
{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        double perimeter;

        System.out.println("Enter Base And Height of Triangle");

        perimeter=sc.nextDouble();

        double side= perimeter/4;

          System.out.println("The length of the side is "+side+" whose perimeter is "
          +perimeter);


    }
}
