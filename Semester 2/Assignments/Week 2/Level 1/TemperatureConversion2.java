
import java.util.*;

public class TemperatureConversion2 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double  fahrenheit = sc.nextDouble();

        double celsiusResult = 0.0;
        celsiusResult = ( fahrenheit - 32) * 5/9 + 32;

        System.out.println("The " + fahrenheit + " fahrenheit is " + celsiusResult + " celcius");

    }
}
