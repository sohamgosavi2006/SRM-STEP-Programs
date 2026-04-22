

public class PensDistribution{

    public static void main(String Args[]){

        int pens=14,students=3;

        int remainingPens = pens%students;
        int penPerStudent = pens/students;

         System.out.println("The Pen Per Student is "+penPerStudent+
         " and the remaining pen not distributed is "+remainingPens);


    }
    
}