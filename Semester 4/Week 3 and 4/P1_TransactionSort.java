package Week3Week4;
import java.util.*;

class Transaction {
    String id;
    double fee;
    String time;

    Transaction(String id, double fee, String time) {
        this.id = id;
        this.fee = fee;
        this.time = time;
    }

    public String toString() {
        return id + ":" + fee;
    }
}

public class P1_TransactionSort {

    static void bubbleSort(ArrayList<Transaction> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    static void insertionSort(ArrayList<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).fee > key.fee) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        ArrayList<Transaction> list = new ArrayList<>();
        list.add(new Transaction("id1", 10.5, "10:00"));
        list.add(new Transaction("id2", 25.0, "09:30"));
        list.add(new Transaction("id3", 5.0, "10:15"));

        bubbleSort(list);
        System.out.println("Bubble Sort: " + list);

        insertionSort(list);
        System.out.println("Insertion Sort: " + list);
    }
}