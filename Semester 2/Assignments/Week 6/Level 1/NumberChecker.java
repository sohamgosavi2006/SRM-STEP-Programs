import java.util.Scanner;

class NumberChecker {
    public static int countDigits(int num) {
        int n = Math.abs(num), count = 0;
        while(n > 0) {
            count++;
            n /= 10;
        }
        return count == 0 ? 1 : count;
    }
    
    public static int[] getDigits(int num, int c) {
        int n = Math.abs(num);
        int arr[] = new int[c];
        for(int i=c-1; i>=0; i--) {
            arr[i] = n % 10;
            n /= 10;
        }
        return arr;
    }
    
    public static boolean isDuckNumber(int arr[]) {
        for(int x: arr)
            if(x != 0) return true;
        return false;
    }
    
    public static boolean isArmstrongNumber(int num, int arr[]) {
        int sum=0, p=arr.length;
        for(int x: arr)
            sum += Math.pow(x, p);
        return sum == Math.abs(num);
    }
    
    public static int[] findLargestDigits(int arr[]) {
        int max=Integer.MIN_VALUE, second=Integer.MIN_VALUE;
        for(int x: arr) {
            if(x > max) {
                second = max;
                max = x;
            }
            else if(x > second && x != max)
                second = x;
        }
        return new int[]{max, second};
    }
    
    public static int[] findSmallestDigits(int arr[]) {
        int min=Integer.MAX_VALUE, second=Integer.MAX_VALUE;
        for(int x: arr) {
            if(x < min) {
                second = min;
                min = x;
            }
            else if(x < second && x != min)
                second = x;
        }
        return new int[]{min, second};
    }
    
    public static int sumDigits(int arr[]) {
        int sum=0;
        for(int x: arr)
            sum += x;
        return sum;
    }
    
    public static int sumSquaresDigits(int arr[]) {
        int sum=0;
        for(int x: arr)
            sum += Math.pow(x, 2);
        return sum;
    }
    
    public static boolean isHarshadNumber(int num, int arr[]) {
        return num % sumDigits(arr) == 0;
    }
    
    public static int[][] digitFrequency(int arr[]) {
        int freq[][] = new int[10][2];
        for(int i=0; i<10; i++)
            freq[i][0] = i;
        for(int x: arr)
            freq[x][1]++;
        return freq;
    }
    
    public static int[] reverseDigits(int arr[]) {
        int rev[] = new int[arr.length];
        for(int i=0; i<arr.length; i++)
            rev[i] = arr[arr.length-1-i];
        return rev;
    }
    
    public static boolean areArraysEqual(int arr1[], int arr2[]) {
        if(arr1.length != arr2.length) return false;
        for(int i=0; i<arr1.length; i++)
            if(arr1[i] != arr2[i]) return false;
        return true;
    }
    
    public static boolean isPalindrome(int num, int arr[]) {
        return areArraysEqual(arr, reverseDigits(arr));
    }
    
    public static boolean isPrimeNumber(int num) {
        if(num <= 1) return false;
        for(int i=2; i<=Math.sqrt(num); i++)
            if(num % i == 0) return false;
        return true;
    }
    
    public static boolean isNeonNumber(int num) {
        int sq = num * num, sum=0;
        while(sq > 0) {
            sum += sq % 10;
            sq /= 10;
        }
        return sum == num;
    }
    
    public static boolean isSpyNumber(int num) {
        int sum=0, prod=1;
        while(num > 0) {
            int d = num % 10;
            sum += d;
            prod *= d;
            num /= 10;
        }
        return sum == prod;
    }
    
    public static boolean isAutomorphicNumber(int num) {
        long sq = (long)num * num;
        while(num > 0) {
            if(num % 10 != sq % 10) return false;
            num /= 10;
            sq /= 10;
        }
        return true;
    }
    
    public static boolean isBuzzNumber(int num) {
        return num % 7 == 0 || num % 10 == 7;
    }
    
    public static int[] findFactors(int num) {
        num = Math.abs(num);
        int count=0;
        for(int i=1; i<=num; i++)
            if(num % i == 0) count++;
        int factors[] = new int[count];
        int j=0;
        for(int i=1; i<=num; i++)
            if(num % i == 0) factors[j++] = i;
        return factors;
    }
    
    public static int greatestFactor(int arr[]) {
        return arr[arr.length-2];
    }
    
    public static int sumFactors(int arr[]) {
        int sum=0;
        for(int x: arr)
            sum += x;
        return sum;
    }
    
    public static long productFactors(int arr[]) {
        long prod=1;
        for(int x: arr)
            prod *= x;
        return prod;
    }
    
    public static long productCubeFactors(int arr[]) {
        long prod=1;
        for(int x: arr)
            prod *= Math.pow(x, 3);
        return prod;
    }
    
    public static boolean isPerfectNumber(int num, int arr[]) {
        return sumFactors(arr) - num == num;
    }
    
    public static boolean isAbundantNumber(int num, int arr[]) {
        return sumFactors(arr) - num > num;
    }
    
    public static boolean isDeficientNumber(int num, int arr[]) {
        return sumFactors(arr) - num < num;
    }
    
    public static boolean isStrongNumber(int num) {
        int sum=0, temp=num;
        while(temp > 0) {
            int d = temp % 10, fact=1;
            for(int i=1; i<=d; i++)
                fact *= i;
            sum += fact;
            temp /= 10;
        }
        return sum == num;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number for digit checks: ");
        int num = sc.nextInt();
        int c = countDigits(num);
        int arr[] = getDigits(num, c);
        System.out.print("Digits: ");
        for(int x: arr) System.out.print(x + " ");
        System.out.println();
        
        System.out.println("Program 2:");
        System.out.println("Digit Count: "+c);
        System.out.println("Duck Number: "+isDuckNumber(arr));
        System.out.println("Armstrong Number: "+isArmstrongNumber(num, arr));
        int large[] = findLargestDigits(arr);
        System.out.println("Largest: "+large[0]+", Second: "+large[1]);
        int small[] = findSmallestDigits(arr);
        System.out.println("Smallest: "+small[0]+", Second: "+small[1]);
        System.out.println();
        
        System.out.println("Program 3:");
        System.out.println("Sum Digits: "+sumDigits(arr));
        System.out.println("Sum Squares: "+sumSquaresDigits(arr));
        System.out.println("Harshad Number: "+isHarshadNumber(num, arr));
        System.out.println("Frequencies:");
        int freq[][] = digitFrequency(arr);
        for(int x[]: freq)
            if(x[1] > 0) System.out.println("Digit "+x[0]+": "+x[1]);
        System.out.println();
        
        System.out.println("Program 4:");
        int rev[] = reverseDigits(arr);
        System.out.print("Reversed: ");
        for(int x: rev) System.out.print(x+" ");
        System.out.println();
        System.out.println("Palindrome: "+isPalindrome(num, arr));
        System.out.println("Duck Number: "+isDuckNumber(arr));
        System.out.println();
        
        System.out.println("Program 5:");
        System.out.println("Prime: "+isPrimeNumber(num));
        System.out.println("Neon: "+isNeonNumber(num));
        System.out.println("Spy: "+isSpyNumber(num));
        System.out.println("Automorphic: "+isAutomorphicNumber(num));
        System.out.println("Buzz: "+isBuzzNumber(num));
        System.out.println();
        
        System.out.print("Enter a number for factor checks: ");
        int fnum = sc.nextInt();
        int factors[] = findFactors(fnum);
        System.out.println("Program 6:");
        System.out.print("Factors: ");
        for(int x: factors) System.out.print(x+" ");
        System.out.println();
        System.out.println("Greatest Factor: "+greatestFactor(factors));
        System.out.println("Sum Factors: "+sumFactors(factors));
        System.out.println("Product Factors: "+productFactors(factors));
        System.out.println("Cube Product: "+productCubeFactors(factors));
        System.out.println("Perfect: "+isPerfectNumber(fnum, factors));
        System.out.println("Abundant: "+isAbundantNumber(fnum, factors));
        System.out.println("Deficient: "+isDeficientNumber(fnum, factors));
        System.out.println("Strong: "+isStrongNumber(fnum));
        sc.close();
    }
}