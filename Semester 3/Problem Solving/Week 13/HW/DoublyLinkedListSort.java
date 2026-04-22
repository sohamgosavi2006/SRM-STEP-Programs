public class DoublyLinkedListSort {
    class Node {
        int data;
        Node prev, next;
        Node(int data) {
            this.data = data;
        }
    }

    Node head, tail;

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void bubbleSort() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" ⇄ ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedListSort list = new DoublyLinkedListSort();
        list.add(40);
        list.add(10);
        list.add(30);
        list.add(20);
        System.out.println("Before sorting:");
        list.display();
        list.bubbleSort();
        System.out.println("After sorting:");
        list.display();
    }
}