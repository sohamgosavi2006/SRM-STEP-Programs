import java.util.Scanner;

public class UseCase8PalindromeCheckerApp {

    // Node class representing an element in the Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Linked List Based Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }
        scanner.close();
    }

    public static boolean isPalindrome(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (cleaned.isEmpty()) return true;

        // Step 1: Convert String to Singly Linked List
        Node head = new Node(cleaned.charAt(0));
        Node current = head;
        for (int i = 1; i < cleaned.length(); i++) {
            current.next = new Node(cleaned.charAt(i));
            current = current.next;
        }

        // Step 2: Use Fast & Slow pointers to find the middle
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse the second half of the list in-place
        Node secondHalf = reverseList(slow);
        Node firstHalf = head;

        // Step 4: Compare the two halves
        Node tempSecond = secondHalf;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        return true;
    }

    // Helper method to reverse a Linked List
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}