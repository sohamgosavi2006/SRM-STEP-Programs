import java.util.*;

public class AreaOfTriangle
{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        double base,height;

        System.out.println("Enter Base And Height of Triangle");

        base=sc.nextDouble();
        height=sc.nextDouble();

        double centimeterArea= (1/2)*base*height;
         double inchesArea= centimeterArea/2.54;
         double feetArea= centimeterArea/12;


        System.out.println("Your Area in cm is "+centimeterArea+"while in feet is "
        +feetArea+"and inches is "+inchesArea);

    }
}