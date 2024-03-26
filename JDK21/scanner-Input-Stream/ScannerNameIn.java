import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerNameIn {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        System.out.println("Vorname: ");
        String firstName = scanner.nextLine();

        System.out.println("Nachname: ");
        String lastName = scanner.nextLine();

        System.out.println("For addition, enter numbers (type 'end' to finish): ");

        int sum = 0;
        String input;
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

        System.out.printf("Hello %s %s! The sum of the numbers is: %d%n", firstName, lastName, sum);

        scanner.close();
    }
}