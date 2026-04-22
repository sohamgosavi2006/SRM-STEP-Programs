public class LoopRemoval {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }

    void createLoop(int position) {
        if (position <= 0) return;
        Node loopNode = head;
        for (int i = 1; i < position && loopNode != null; i++) loopNode = loopNode.next;
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = loopNode;
    }

    boolean detectAndRemoveLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                removeLoop(slow);
                return true;
            }
        }
        return false;
    }

    void removeLoop(Node loopNode) {
        Node ptr1 = head, ptr2 = loopNode;
        while (ptr1.next != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
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
        LoopRemoval list = new LoopRemoval();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.createLoop(3);

        boolean loopFound = list.detectAndRemoveLoop();
        if (loopFound) {
            System.out.println("Loop detected and removed →");
            list.display();
        } else {
            System.out.println("No loop found →");
            list.display();
        }
    }
}
