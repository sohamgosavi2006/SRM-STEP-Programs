import java.util.*;

public class TextCalculator {
    static boolean isValid(String expr) {
        int balance = 0;
        char prev = ' ';
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (!(c >= '0' && c <= '9' || c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == ' ')) return false;
            if (c == '(') balance++;
            if (c == ')') balance--;
            if (balance < 0) return false;
            if ((c == '+' || c == '*' || c == '/') && (prev == '+' || prev == '-' || prev == '*' || prev == '/' || prev == ' ')) return false;
            prev = c;
        }
        return balance == 0;
    }

    static List<Double> parseNumbers(String expr) {
        List<Double> nums = new ArrayList<>();
        int i = 0;
        while (i < expr.length()) {
            char c = expr.charAt(i);
            if (c >= '0' && c <= '9' || (c == '-' && (i == 0 || expr.charAt(i - 1) == '('))) {
                int j = i + 1;
                while (j < expr.length() && expr.charAt(j) >= '0' && expr.charAt(j) <= '9') j++;
                nums.add(Double.parseDouble(expr.substring(i, j)));
                i = j;
            } else i++;
        }
        return nums;
    }

    static List<Character> parseOperators(String expr) {
        List<Character> ops = new ArrayList<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (!(c == '-' && (i == 0 || expr.charAt(i - 1) == '('))) ops.add(c);
            }
        }
        return ops;
    }

    static double evaluateNoParen(String expr, StringBuilder steps) {
        List<Double> nums = parseNumbers(expr);
        List<Character> ops = parseOperators(expr);
        for (int i = 0; i < ops.size();) {
            char op = ops.get(i);
            if (op == '*' || op == '/') {
                double a = nums.get(i), b = nums.get(i + 1);
                double res = op == '*' ? a * b : a / b;
                steps.append(a + " " + op + " " + b + " = " + res + "\n");
                nums.set(i, res);
                nums.remove(i + 1);
                ops.remove(i);
            } else i++;
        }
        double result = nums.get(0);
        for (int i = 0; i < ops.size(); i++) {
            double b = nums.get(i + 1);
            char op = ops.get(i);
            if (op == '+') result += b;
            else result -= b;
            steps.append(result + "\n");
        }
        return result;
    }

    static double evaluateWithParens(String expr, StringBuilder steps) {
        while (expr.contains("(")) {
            int close = expr.indexOf(")");
            int open = expr.lastIndexOf("(", close);
            String sub = expr.substring(open + 1, close);
            double val = evaluateNoParen(sub, steps);
            expr = expr.substring(0, open) + val + expr.substring(close + 1);
        }
        return evaluateNoParen(expr, steps);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression:");
        String expr = sc.nextLine();
        if (!isValid(expr)) {
            System.out.println("Invalid expression");
            sc.close();
            return;
        }
        StringBuilder steps = new StringBuilder();
        steps.append("Original: " + expr + "\n");
        double res = evaluateWithParens(expr, steps);
        steps.append("Result: " + res + "\n");
        System.out.println(steps.toString());

        sc.close();
    }
}