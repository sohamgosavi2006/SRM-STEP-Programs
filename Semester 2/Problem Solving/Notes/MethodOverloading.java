
import java.util.*;

public class MethodOverloading {

    public double area(double radius) {

        return Math.PI * radius * radius;
    }

    public double area(double length, double breadth) {

        return length * breadth;
    }

    public static double area(double base, double height, boolean isTriangle) {

        return 0.5 * base * height;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        MethodOverloading obj = new MethodOverloading();

        System.out.println("Circle Area : " + obj.area(2.5));
        System.out.println("Rectangle Area : " + obj.area(2.5, 3.5));
        System.out.println("Triangle Area : " + area(5.0, 10.0, true));

    }
}
