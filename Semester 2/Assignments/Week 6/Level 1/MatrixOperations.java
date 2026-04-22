import java.util.Scanner;

public class MatrixOperations {
    public static int[][] generateMatrix(int r, int c) {
        int mat[][] = new int[r][c];
        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++)
                mat[i][j] = (int)(Math.random()*10);
        return mat;
    }
    
    public static int[][] addMatrices(int a[][], int b[][]) {
        int r=a.length, c=a[0].length;
        int res[][] = new int[r][c];
        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++)
                res[i][j] = a[i][j]+b[i][j];
        return res;
    }
    
    public static int[][] subtractMatrices(int a[][], int b[][]) {
        int r=a.length, c=a[0].length;
        int res[][] = new int[r][c];
        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++)
                res[i][j] = a[i][j]-b[i][j];
        return res;
    }
    
    public static int[][] multiplyMatrices(int a[][], int b[][]) {
        int ra=a.length, ca=a[0].length, cb=b[0].length;
        int res[][] = new int[ra][cb];
        for(int i=0; i<ra; i++)
            for(int j=0; j<cb; j++)
                for(int k=0; k<ca; k++)
                    res[i][j] += a[i][k]*b[k][j];
        return res;
    }
    
    public static int[][] transposeMatrix(int mat[][]) {
        int r=mat.length, c=mat[0].length;
        int res[][] = new int[c][r];
        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++)
                res[j][i] = mat[i][j];
        return res;
    }
    
    public static int determinant2x2(int mat[][]) {
        return mat[0][0]*mat[1][1] - mat[0][1]*mat[1][0];
    }
    
    public static int determinant3x3(int mat[][]) {
        return mat[0][0]*(mat[1][1]*mat[2][2]-mat[1][2]*mat[2][1])
              -mat[0][1]*(mat[1][0]*mat[2][2]-mat[1][2]*mat[2][0])
              +mat[0][2]*(mat[1][0]*mat[2][1]-mat[1][1]*mat[2][0]);
    }
    
    public static double[][] inverse2x2(int mat[][]) {
        int det = determinant2x2(mat);
        if(det==0) return null;
        double inv[][] = new double[2][2];
        inv[0][0] = mat[1][1]/(double)det;
        inv[0][1] = -mat[0][1]/(double)det;
        inv[1][0] = -mat[1][0]/(double)det;
        inv[1][1] = mat[0][0]/(double)det;
        return inv;
    }
    
    public static void displayMatrix(int mat[][]) {
        for(int r[]: mat) {
            for(int x: r)
                System.out.printf("%4d",x);
            System.out.println();
        }
    }
    
    public static void displayDoubleMatrix(double mat[][]) {
        if(mat==null) {
            System.out.println("Not invertible");
            return;
        }
        for(double r[]: mat) {
            for(double x: r)
                System.out.printf("%8.2f",x);
            System.out.println();
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Rows: ");
        int r = sc.nextInt();
        System.out.print("Cols: ");
        int c = sc.nextInt();
        int a[][] = generateMatrix(r,c);
        int b[][] = generateMatrix(r,c);
        System.out.println("Matrix A:");
        displayMatrix(a);
        System.out.println("Matrix B:");
        displayMatrix(b);
        System.out.println("A+B:");
        displayMatrix(addMatrices(a,b));
        System.out.println("A-B:");
        displayMatrix(subtractMatrices(a,b));
        System.out.println("A*B:");
        displayMatrix(multiplyMatrices(a,b));
        System.out.println("Transpose A:");
        displayMatrix(transposeMatrix(a));
        if(r==2 && c==2) {
            System.out.println("Det A: "+determinant2x2(a));
            System.out.println("Inverse A:");
            displayDoubleMatrix(inverse2x2(a));
        }
        if(r==3 && c==3)
            System.out.println("Det A: "+determinant3x3(a));
        sc.close();
    }
}