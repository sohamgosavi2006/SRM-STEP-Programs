import java.util.*;

public class KilometerToMiles{

    public static void main(String Args[]){

        double kilometer=0.0;

        System.out.println("Enter distance in Kilometers");

        Scanner sc = new Scanner(System.in);
        kilometer = sc.nextDouble();

        double miles = 1.6*kilometer;

        System.out.println("The total miles is "+miles+" mile for the given "+
        kilometer+ " km");




    }
    
}