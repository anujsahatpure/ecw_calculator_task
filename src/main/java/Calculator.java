import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;

        System.out.println("Basic Calculator");
        System.out.println("----------------");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        
        try {
            // Get first number
            System.out.print("\nEnter first number: ");
            num1 = scanner.nextDouble();

            // Get operation choice
            System.out.print("Enter operation number (1-4): ");
            int choice = scanner.nextInt();

            // Get second number
            System.out.print("Enter second number: ");
            num2 = scanner.nextDouble();

            // Perform calculation based on choice
            switch (choice) {
                case 1:
                    System.out.printf("%.2f + %.2f = %.2f%n", 
                        num1, num2, (num1 + num2));
                    break;
                case 2:
                    System.out.printf("%.2f - %.2f = %.2f%n", 
                        num1, num2, (num1 - num2));
                    break;
                case 3:
                    System.out.printf("%.2f * %.2f = %.2f%n", 
                        num1, num2, (num1 * num2));
                    break;
                case 4:
                    if (num2 != 0) {
                        System.out.printf("%.2f / %.2f = %.2f%n", 
                            num1, num2, (num1 / num2));
                    } else {
                        System.out.println("Error: Cannot divide by zero!");
                    }
                    break;
                default:
                    System.out.println("Invalid operation choice!");
            }

        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please enter valid numbers.");
        }

        scanner.close();
    }
}