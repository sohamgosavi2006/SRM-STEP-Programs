import java.util.*;

// 1. Define the Strategy Interface
interface PalindromeStrategy {
    boolean isValid(String text);
}

// 2. Implementation: Stack-Based Strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : cleaned.toCharArray()) stack.push(c);

        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// 3. Implementation: Deque-Based Strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : cleaned.toCharArray()) deque.addLast(c);

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// 4. Context Class: The "Checker" that uses a strategy
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String text) {
        return strategy.isValid(text);
    }
}

// 5. Main Application
public class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("--- UC12: Strategy Pattern Palindrome App ---");
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        System.out.println("Select Strategy: 1) Stack  2   ) Deque");
        int choice = scanner.nextInt();

        // Polymorphism in action: Injecting the strategy at runtime
        if (choice == 1) {
            context.setStrategy(new StackStrategy());
            System.out.println("Using Stack Strategy...");
        } else {
            context.setStrategy(new DequeStrategy());
            System.out.println("Using Deque Strategy...");
        }

        if (context.executeStrategy(input)) {
            System.out.println("Result: Valid Palindrome.");
        } else {
            System.out.println("Result: Not a Palindrome.");
        }
        scanner.close();
    }
}