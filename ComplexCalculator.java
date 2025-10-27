import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ComplexCalculator {

    private static final Map<Character, Integer> PRECEDENCE = new HashMap<>();

    static {
        PRECEDENCE.put('+', 1);
        PRECEDENCE.put('-', 1);
        PRECEDENCE.put('*', 2);
        PRECEDENCE.put('/', 2);
        PRECEDENCE.put('^', 3); // Exponentiation
    }

    public double evaluate(String expression) {
        // Remove whitespace for easier parsing
        expression = expression.replaceAll("\\s+", "");

        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                i--; // Decrement i as it's incremented one extra time in the loop condition
                numbers.push(Double.parseDouble(sb.toString()));
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    applyOperation(numbers, operators);
                }
                operators.pop(); // Pop the '('
            } else if (PRECEDENCE.containsKey(c)) {
                while (!operators.isEmpty() && PRECEDENCE.containsKey(operators.peek()) &&
                       PRECEDENCE.get(operators.peek()) >= PRECEDENCE.get(c)) {
                    applyOperation(numbers, operators);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            applyOperation(numbers, operators);
        }

        return numbers.pop();
    }

    private void applyOperation(Stack<Double> numbers, Stack<Character> operators) {
        char operator = operators.pop();
        double b = numbers.pop();
        double a = numbers.pop();

        switch (operator) {
            case '+':
                numbers.push(a + b);
                break;
            case '-':
                numbers.push(a - b);
                break;
            case '*':
                numbers.push(a * b);
                break;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                numbers.push(a / b);
                break;
            case '^':
                numbers.push(Math.pow(a, b));
                break;
        }
    }

    public static void main(String[] args) {
        ComplexCalculator calculator = new ComplexCalculator();
        String expression1 = "3 + 5 * (2 - 8) / 2"; // Example with parentheses and precedence
        String expression2 = "2^3 + 10 / 5"; // Example with exponentiation

        System.out.println("Result of \"" + expression1 + "\": " + calculator.evaluate(expression1));
        System.out.println("Result of \"" + expression2 + "\": " + calculator.evaluate(expression2));
    }

        System.out.println("Result of \"" + expression1 + "\": " + calculator.evaluate(expression1));
}