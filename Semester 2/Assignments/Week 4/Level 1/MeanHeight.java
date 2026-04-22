import java.util.*;
 
public class MeanHeight
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       System.out.println("Enter Height of 11 Players");

       double playersHeight[] = new double[11];

        double sumHeight = 0;
        for (int i = 0; i < playersHeight.length; i++) {
            playersHeight[i] = sc.nextDouble();
           sumHeight += playersHeight[i];
        }

        double averageHeight = sumHeight/11;

        System.out.println("Mean Height of Football Team = "+averageHeight);
 
    }
}