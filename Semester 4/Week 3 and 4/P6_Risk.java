package Week3Week4;
public class P6_Risk {

    static int floor(int[] arr, int key) {
        int res = -1;
        for (int num : arr)
            if (num <= key) res = num;
        return res;
    }

    static int ceil(int[] arr, int key) {
        for (int num : arr)
            if (num >= key) return num;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};
        int key = 30;

        System.out.println("Floor: " + floor(arr, key));
        System.out.println("Ceil: " + ceil(arr, key));
    }
}