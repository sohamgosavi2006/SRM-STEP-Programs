import java.util.*;

public class Distance
{
    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);

        double distanceInFeet;

        System.out.println("Enter Distance in Feet");

        distanceInFeet=sc.nextDouble();

        double distanceInYard,distanceInMile;

        distanceInYard = distanceInFeet/3;
        distanceInMile= distanceInYard/1760;

System.out.println("Your Distance in feet is "+distanceInFeet+"while in yard is "
        +distanceInYard+"and miles is "+distanceInMile);
    }
}