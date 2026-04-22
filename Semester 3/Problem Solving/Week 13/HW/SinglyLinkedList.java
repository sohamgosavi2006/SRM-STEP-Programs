import java.util.Scanner;

public class SinglyLinkedList {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position <= 1 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        int count = 1;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtPosition(10, 1);
        list.insertAtPosition(20, 2);
        list.insertAtPosition(30, 3);
        list.insertAtPosition(40, 4);
        list.display();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value to insert: ");
        int val = sc.nextInt();
        System.out.print("Enter position: ");
        int pos = sc.nextInt();
        
        list.insertAtPosition(val, pos);
        list.display();
        sc.close();
    }
}