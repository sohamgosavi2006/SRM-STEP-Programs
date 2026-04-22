
import java.util.*;

public class TemperatureConversion1 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double celcius = sc.nextDouble();

        double farenheitResult = 0.0;
        farenheitResult = (celcius * 9 / 5) + 32;

        System.out.println("The " + celcius + " celcius is " + farenheitResult + " fahrenheit");

    }
}
