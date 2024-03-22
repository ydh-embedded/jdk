import java.util.Scanner ;
import java.util.InputMismatchException;
import java.util.Locale ; 


public class ScannerNumberIn {
    public static void main(String[] args) {
        double sum = 0;
        // Set locale to Germany (it does not make a difference in this case since we're parsing integers)
        var scanner = new Scanner(System.in).useLocale(Locale.GERMANY);
        
        System.out.println("Locale: " + scanner.locale());

        System.out.println("Eingabe einer Zahl: ");
        String input = scanner.nextLine().replace(",",".");
        try {
            double firstNumber = Double.parseDouble(input);
            sum += firstNumber;
            System.out.println("Eingabe einer zweiten Zahl: ");
            input = scanner.nextLine().replace(",",".");
            double secondNumber = Double.parseDouble(input);
            sum += secondNumber;
            System.out.printf("%.1f + %.1f = %.1f!\n", firstNumber, secondNumber, sum);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.close();
            return;
        }

        System.out.println("Eingabe weiterer Zahlen (type 'end' to finish): ");

        while (true) {
            input = scanner.nextLine().replace(",",".");

            if (input.equalsIgnoreCase("end")) {
                break;
            }

            try {
                double number = Double.parseDouble(input);
                sum += number;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        System.out.printf("The sum of the numbers is: %,.2f", sum);

        scanner.close();
    }
}