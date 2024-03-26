public class FibonacciSequenceAndPrime {
    public static void main(String[] args) {
        if (args.length == 1) {
            // Set starting time of execution
            long startTime = System.nanoTime();
            int n = Integer.parseInt(args[0]); //  <- Max. 78-th Term
            if (n < 1 || n > 78) {
                showHelp();
                return;
            }
            // Create an Array of Fibonacci numbers
            double[] fib = new double[n];
            int size = fib.length;
            countFibos(fib, size);
            // Create numeral prefix
            String numeral = getNumeral(n);
            // Create an output Array of Strings
            printFibos(size, numeral, fib, n);
            // Set ending time of execution
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000;
            System.out.printf("Program execution time: %.3f seconds", duration / 1000.0);
        } else {
            System.out.println("Programmaufruf: 'java FibonacciSequence n'");
        }
    }

    private static void printFibos(int size, String numeral, double[] fib, int n) {
        String[] outPut = new String[size];
        StringBuilder message = new StringBuilder(
                "| *** The "
                + numeral
                + " number of Fibonacci Sequence is: "
                + String.format("%,.0f", fib[n - 1])
        );
        // Format Output String and check if Prime
        for (int i = 0; i < size; i++) {
            // isPrime = true set for all numbers except 1
            boolean isPrime = i > 1;
            outPut[i] = String.format("%,.0f", fib[i]);
            for (double j = 2; j < (fib[i] / 2); j++) {
                double result = fib[i] / j;
                if (result == Math.floor(result)) {
                    // isPrime = false for all numbers that have divisors other than 1 and self
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                outPut[i] += " PRIME";
                if ( i == n - 1 ) {
                    message.append(", and it's a Prime Number");
                }
            }
            System.out.printf("[#%d : %s], \n", i + 1, outPut[i]);
        }
        message.append(" *** |");
        System.out.println(message);
    }

    private static String getNumeral(int n) {
        String numeral;
        switch (n) {
            case 1 -> numeral = "-st";
            case 2 -> numeral = "-nd";
            case 3 -> numeral = "-rd";
            default -> numeral = n + "-th";
        }
        return numeral;
    }

    private static void countFibos(double[] fib, int size) {
        fib[0] = 1;
        if (size > 1) fib[1] = 1;
        for (int i = 0; i < size - 2; i++) {
            fib[i + 2] = fib[i] + fib[i + 1];
        }
    }

    public static void showHelp() {
        System.out.println("n muss sich im Bereich 1 - 78 befinden!");
        System.out.println("Starte das Programm neu mit Korrekten Parametern!");
    }
}
