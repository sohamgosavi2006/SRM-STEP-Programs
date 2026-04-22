import java.util.Scanner;

public class CollinearPoints {
    public static boolean areCollinearBySlope(int x1,int y1,int x2,int y2,int x3,int y3) {
        double s1 = (double)(y2-y1)/(x2-x1);
        double s2 = (double)(y3-y2)/(x3-x2);
        double s3 = (double)(y3-y1)/(x3-x1);
        return Math.abs(s1-s2)<0.0001 && Math.abs(s2-s3)<0.0001;
    }
    
    public static boolean areCollinearByArea(int x1,int y1,int x2,int y2,int x3,int y3) {
        double area = 0.5 * Math.abs(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2));
        return Math.abs(area)<0.0001;
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
        System.out.print("x3: ");
        int x3 = sc.nextInt();
        System.out.print("y3: ");
        int y3 = sc.nextInt();
        System.out.println("Points: ("+x1+","+y1+"), ("+x2+","+y2+"), ("+x3+","+y3+")");
        System.out.println("Collinear (Slope): "+areCollinearBySlope(x1,y1,x2,y2,x3,y3));
        System.out.println("Collinear (Area): "+areCollinearByArea(x1,y1,x2,y2,x3,y3));
        sc.close();
    }
}