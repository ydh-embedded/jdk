import java.math.BigDecimal;
import java.math.RoundingMode;

public class FiboNew {
    public static void main(String[] args) {
        if (args.length == 1) {
            long startTime = System.nanoTime();
            int size = Integer.parseInt(args[0]);
            if (size < 1) {
                showHelp();
                return;
            }

            BigDecimal[] fibonacci = new BigDecimal[size];

            countFibonacci(size, fibonacci);

            boolean isPrime = isPrime(fibonacci[size-1]);

            if (isPrime) {
                System.out.printf("#%d%s Fibo Number is a Prime Number\n", size, checkNumeral(size));
            } else {
                System.out.printf("#%d%s Fibo Number is NOT a Prime Number\n", size, checkNumeral(size));
            }

            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000;
            System.out.printf("Program execution time: %.3f seconds", duration / 1000.0);
        } else {
            System.out.println("Programmaufruf: 'java FibonacciSequence n'");
        }
    }

    private static boolean isPrime(BigDecimal fibonacci) {
        System.out.println("Checking...");
        BigDecimal divisor = BigDecimal.valueOf(2);
        BigDecimal max = new BigDecimal(String.valueOf(fibonacci.divide(BigDecimal.valueOf(2), RoundingMode.DOWN)));
        while(divisor.compareTo(max) < 0) {
            BigDecimal quotient = fibonacci.divide(divisor, RoundingMode.UP);
            BigDecimal quotientRounded = fibonacci.divide(divisor, RoundingMode.DOWN);
            boolean isDivisible = quotient.compareTo(quotientRounded) == 0;
            if (isDivisible) {
                return false;
            }
            divisor = divisor.add(BigDecimal.valueOf(1));
        }
        return true;
    }

    private static void countFibonacci(int size, BigDecimal[] fibonacci) {
        fibonacci[0] = new BigDecimal("1");                     // #1
        System.out.printf("[#%d%s : %s] \n", 1, checkNumeral(1),fibonacci[0]);
        if (size > 1) {
            fibonacci[1] = new BigDecimal("1");                 // #2
            System.out.printf("[#%d%s : %s] \n", 2, checkNumeral(2),fibonacci[1]);
        }
        for (int i = 2; i < size; i++) {
            fibonacci[i] = fibonacci[i - 2].add(fibonacci[i - 1]);  // #n
            System.out.printf("[#%d%s : %s] \n", i + 1, checkNumeral(i + 1),fibonacci[i]);
        }
    }

    private static String checkNumeral(int n) {
        switch (n) {
            case 1 -> {
                return "-st";
            }
            case 2 -> {
                return "-nd";
            }
            case 3 -> {
                return "-rd";
            }
            default -> {
                return "-th";
            }
        }
    }

    public static void showHelp() {
        System.out.println("n muss ein positiv integer sein!");
        System.out.println("Starte das Programm neu mit Korrekten Parametern!");
    }
}
