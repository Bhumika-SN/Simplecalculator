import java.util.Scanner;
public class Main {
    public static void main (String[] args) {


        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Simple Calculator - day 01");
        boolean running = true;

        while (running) {
            System.out.println("\nChoose operation:");
            System.out.println("\nChoose operation:");
            System.out.println("1. Add(+)");
            System.out.println("2. Subtract(-)");
            System.out.println("3. multiply(*)");
            System.out.println("4. divide(/)");
            System.out.println("5. Exit");
            System.out.print("Enter choice(1-5): ");
            String choice = sc.nextLine().trim();  //remove spaces = trim

            try {
                switch (choice) {
                    case "1":
                    case "+":
                        double[] n1 = readTwoDoubles(sc);
                        System.out.println("Result: " + calc.add(n1[0], n1[1]));
                        break;
                    case "2":
                    case "-":
                        n1 = readTwoDoubles(sc);
                        System.out.println("Result: " + calc.subtract(n1[0], n1[1]));
                        break;
                    case "3":
                    case "*":
                        n1 = readTwoDoubles(sc);
                        System.out.println("Result: " + calc.multiply(n1[0], n1[1]));
                        break;
                    case "4":
                    case "/":
                        n1 = readTwoDoubles(sc);
                        System.out.println("Result: " + calc.divide(n1[0], n1[1]));
                        break;
                    case "5":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. please choose 1-5.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid number entered. please try again.");
            }
        }

                    System.out.println("Goodbye!");
                    sc.close();

            }
            private static double[] readTwoDoubles(Scanner sc){
                System.out.print("Enter first number: ");
                double a = Double.parseDouble(sc.nextLine().trim());
                System.out.print("Enter second number: ");
                double b = Double.parseDouble(sc.nextLine().trim());
                return new double[]{a, b};
            }

        }

