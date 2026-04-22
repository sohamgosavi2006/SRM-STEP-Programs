package Week3Week4;
import java.util.*;

class Client {
    String name;
    int risk;

    Client(String name, int risk) {
        this.name = name;
        this.risk = risk;
    }

    public String toString() {
        return name + ":" + risk;
    }
}

public class P2_ClientRisk {

    static void bubbleSort(Client[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].risk > arr[j + 1].risk) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Client[] arr = {
            new Client("A", 20),
            new Client("B", 50),
            new Client("C", 80)
        };

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}