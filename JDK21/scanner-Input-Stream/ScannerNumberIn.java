import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerNumberIn {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        double sum = 0;
        System.out.println("Eingabe einer Zahl: ");
        String input = scanner.nextLine();
        try {
            double firstNumber = Integer.parseInt(input);
            sum += firstNumber;
            System.out.println("Eingabe einer zweiten Zahl: ");
            input = scanner.nextLine();
            double secondNumber = Integer.parseInt(input);
            sum += secondNumber;
            System.out.printf("%d + %d = %d!\n", firstNumber, secondNumber, sum);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.close();
            return;
        }

        System.out.println("Eingabe weiterer Zahlen (type 'end' to finish): ");

        while (true) {
            input = scanner.next();

            if (input.equalsIgnoreCase("end")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                sum += number;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        System.out.printf("The sum of the numbers is: %d%n", sum);

        scanner.close();
    }
}