import java.util.*;
 
public class ArrayDimension
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
        System.out.println("Enter Rows and Colums");

        int row = sc.nextInt();
        int column= sc.nextInt();

        int array2D[][] = new int[row][column];
        int array1D[] = new int[row*column];
        int index=0;

        System.out.println("Enter Elements into 2D Array");
        for(int i=0; i<row;i++){
            for(int j=0 ; j<column;j++){
                array2D[i][j] = sc.nextInt();
                array1D[index] = array2D[i][j];
                index++;
            }
        }

        for(int i=0; i<array1D.length;i++){
            System.out.print(array1D[i]+" ");
        }

 
    }
}