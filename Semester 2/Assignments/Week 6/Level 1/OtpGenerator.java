public class OtpGenerator {
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }
    
    public static int[] generateTenOTPs() {
        int otps[] = new int[10];
        for(int i=0; i<10; i++)
            otps[i] = generateOTP();
        return otps;
    }
    
    public static boolean areOTPsUnique(int arr[]) {
        for(int i=0; i<arr.length; i++)
            for(int j=i+1; j<arr.length; j++)
                if(arr[i] == arr[j]) return false;
        return true;
    }
    
    public static void main(String args[]) {
        int otps[] = generateTenOTPs();
        System.out.println("OTPs:");
        for(int x: otps)
            System.out.println(x);
        System.out.println("Unique: "+areOTPsUnique(otps));
    }
}