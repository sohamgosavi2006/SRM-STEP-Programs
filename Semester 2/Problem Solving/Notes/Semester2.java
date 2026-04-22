
public class Semester2 {

    int value = 10;  // Instance variable (class member)

    public void printValue() {
        int value = 20;  // Local variable with the same name as Instance Variable
        // Local Variable 'shadows/hides' instance variable
        System.out.println("Local variable: " + value);    
        System.out.println("Class member variable: " + this.value); 
    }

    // Can call from another class without object
    public static void staticMethod() {
        System.out.println("Parent static method");
    }

    public static void main(String args[]) {

        // Labeled Loop --->
        outerLoop:// label name
        for (int i = 0; i < 2; i++) {
            innerLoop:
            for (int j = 0; j < 2; j++) {
                if (i < j) {
                    System.out.println("Label Break");
                    // label break (to exit a specific loop)

                    //break outerLoop; // Exit Outer Loop
                    break innerLoop; // Exit Inner Loop
                }
            }
            System.out.println("In Outer Loop");
        }

        // Short Circuiting --->

        // Logical AND (&&) performs Short-Circuiting
        if (false && true) {
            // The first condition is false, the overall result will always be false, 
            // so it doesn't even bother checking the second condition. 
            // It only evaluates first operand only for faster execution
        }
        // Bitwise AND (&): No short-circuiting, always evaluates both operands.

        //Array --->
        // Values at index 0,1,2 will be '0'
        // Each element is automatically initialized to the default value for that type
        int[] arr = new int[3];
        // For String default value is NULL

        // Jagged Array : Allows you to have rows with different column sizes
        int[][] jaggedArray = new int[3][]; // 3 Rows
        jaggedArray[0] = new int[2];  // Row 0 has 2 columns
        jaggedArray[1] = new int[3];  // Row 1 has 3 columns
        jaggedArray[2] = new int[4];  // Row 2 has 4 columns
        // In 2D array all rows and column should be equal in length (n,m)

        // Widening Conversion -> (Implicit)
        // smaller data type is automatically converted to a larger data type
        int num = 10;
        double wideResult = num;   // Widening: int(32-bit) to double (64-bit)

        // Narrowing Conversion -> (Explicit)
        // Need to manually tell the compiler for typecasting
        double value = 10.5;
        int narrowResult = (int) value;  // Narrowing: double(64-bit) to int (32-bit)

        // Generate Documentation using Javadoc
        /**
            This is Java Document.
         */

        // Array is Passed By Reference in method/functions hence data of 
        // original array is affected if changed in method/functions

        staticMethod(); // Static method can be called without object creation

        // To call non-static method, Object creation is required
        Semester2 obj = new Semester2();
        obj.printValue();

    }
}

class Test {
    public static void main(String[] args) {
        // Calling the static method of another class directly using the class name
        Semester2.staticMethod();  
    }
}
