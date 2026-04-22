import java.util.Scanner;

public class EuclideanDistance {
    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }
    
    public static double[] getLineEquation(int x1,int y1,int x2,int y2) {
        double m = (double)(y2-y1)/(x2-x1);
        double b = y1 - m*x1;
        return new double[]{m,b};
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x1: ");
        int x1 = sc.nextInt();
        System.out.print("y1: ");
        int y1 = sc.nextInt();
        System.out.print("x2: ");
        int x2 = sc.nextInt();
        System.out.print("y2: ");
        int y2 = sc.nextInt();
        System.out.println("Point 1: ("+x1+", "+y1+")");
        System.out.println("Point 2: ("+x2+", "+y2+")");
        System.out.printf("Distance: %.2f\n",calculateDistance(x1,y1,x2,y2));
        double eq[] = getLineEquation(x1,y1,x2,y2);
        System.out.printf("Line: y = %.2fx + %.2f\n",eq[0],eq[1]);
        sc.close();
    }
}