import java.util.*;
 
public class AthleteRound
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       double side1=sc.nextDouble(),side2=sc.nextDouble(),side3=sc.nextDouble();

        double addSide=side1+side2+side3;

       double perimeter=5.0;

       double numberOfRounds = perimeter-addSide;

       System.out.println("The total number of rounds the athlete will run is "
       +numberOfRounds+" to complete 5 km");
 
    }
}