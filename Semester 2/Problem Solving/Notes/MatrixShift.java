
import java.util.*;

public class MatrixShift {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int arr[] = {1,2,3,4,5,6,7};
        int newArr[]= new int[arr.length];
        int k=3;

        int k1=k;
        int count=0;
        while(k1!=0){
            newArr[count]=arr[arr.length-k];
            count++;
            k1--;
        }
       
        for(int i=0;i<arr.length-k;i++){
            newArr[count]=arr[i];
            count++;
        }

        for(int i=0;i<newArr.length;i++){
            System.out.println(newArr[i]+" ");
        }

    }
}
