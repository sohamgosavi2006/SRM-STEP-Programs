

public class ProfitPercentage{

    public static void main(String Args[]){

        double costPrice=129,sellingPrice=191;

        double profit=sellingPrice-costPrice;

        double percentage = (profit/costPrice)*100;

        System.out.println("The Cost Price is INR "+costPrice+" and Selling Price is INR "+
        sellingPrice+"\n"+"The Profit is INR "+profit+" and the Profit Percentage is "+percentage);

    }
    
}