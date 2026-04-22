

public class VolumeOfEarth{

    public static void main(String Args[]){

        double pi=3.14;
        double radius=6378;

        double volumeCubicKilometer = (4/3)*pi*Math.pow(radius,3);

        double volumeCubicMiles = volumeCubicKilometer*1.6;

        
     System.out.println("The volume of earth in cubic kilometers is "+volumeCubicKilometer+
     " and cubic miles is "+volumeCubicMiles);


    }
    
}