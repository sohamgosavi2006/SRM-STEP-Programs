import java.util.*;

public class HeightConverter{

    public static void main(String Args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Height In Centimeter");
        double heightCentimeter = sc.nextDouble();

        double heightInches = heightCentimeter/2.54;

        double heightFeet = heightInches/12;

        System.out.println("Your Height in cm is "+heightCentimeter+" while in feet is "+ heightFeet+
        " and inches is "+heightInches);


    }
    
}