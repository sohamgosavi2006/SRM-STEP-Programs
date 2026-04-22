package src;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackBasedPalindromeChecker {
    public static void main(String[] args) {
        String input = "radar";
        Deque<Character> deque = new ArrayDeque<>();

        // 1. Fill the Deque
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        boolean isPalindrome = true;

        // 2. Compare from both ends
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Is '" + input + "' a palindrome? " + isPalindrome);
    }
}
