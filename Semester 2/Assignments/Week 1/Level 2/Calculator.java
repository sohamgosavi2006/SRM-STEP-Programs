import java.util.*;

public class Calculator
{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        float number1,number2;

        System.out.println("Enter Two Numbers");

        number1=sc.nextFloat();
        number2=sc.nextFloat();

        float resAdd,resSubstract,resMultiple,resDivision;

        resAdd= number1+number2;

        resSubstract=number1-number2;

        resMultiple = number1*number2;

        if(number2!=0){
            resDivision=number1/number2;
        }
        else{
            resDivision=-1;
        }

        System.out.println("The addition, subtraction, multiplication and division value of 
        2 numbers "+number1+" and "+number2+"is "+resAdd+","+resSubstract+","+ 
        resMultiple+" and "+resDivision);



    }
}