import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        int size = 5;
        
        
        int[] numbers = generate4DigitRandomArray(size);

        double[] results = findAverageMinMax(numbers);

        System.out.print("Generated Numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println("\nAverage: " + results[0]);
        System.out.println("Minimum: " + (int) results[1]);
        System.out.println("Maximum: " + (int) results[2]);
    }
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            numbers[i] = 1000 + random.nextInt(9000); // Ensures a 4-digit number (1000-9999)
        }
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;

        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double average = (double) sum / numbers.length;
        return new double[]{average, min, max}; // Returning an array with avg, min, and max
    }
}
