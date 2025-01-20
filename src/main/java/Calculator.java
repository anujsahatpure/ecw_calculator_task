public class Calculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Error: Please provide exactly 3 arguments: num1, num2, and operator.");
            return;
        }

        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);
        String operator = args[2];  // This is the operator (+, -, *, /)

        System.out.println("Basic Calculator");
        System.out.println("----------------");

        // Perform calculation based on the operator
        switch (operator) {
            case "+":
                System.out.printf("%.2f + %.2f = %.2f%n", num1, num2, (num1 + num2));
                break;
            case "-":
                System.out.printf("%.2f - %.2f = %.2f%n", num1, num2, (num1 - num2));
                break;
            case "*":
                System.out.printf("%.2f * %.2f = %.2f%n", num1, num2, (num1 * num2));
                break;
            case "/":
                if (num2 != 0) {
                    System.out.printf("%.2f / %.2f = %.2f%n", num1, num2, (num1 / num2));
                } else {
                    System.out.println("Error: Cannot divide by zero! Try using any non-zero value.");
                }
                break;
            default:
                System.out.println("Invalid operator! Use +, -, *, or /.");
        }
    }
}