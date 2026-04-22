import java.util.*;

public class TotalPrice
{
    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);

        double unitPrice,quantity;

        System.out.println("Enter Unit Price and Quantity");

        unitPrice=sc.nextDouble();
        quantity=sc.nextDouble();

        double totalPrice = unitPrice*quantity;

        System.out.println("The total purchase price is INR "+totalPrice+" if the quantity "
        +quantity+" and unit price is INR "+unitPrice);
    }
}