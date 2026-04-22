

public class UniversityFee{

    public static void main(String Args[]){

       double fee =125000;

       double discountPercent =10;

       double discount= (discountPercent/100)*fee;

       double discountFee = fee-discount;

     System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "
     +discountFee);


    }
    
}