public class FibonacciSequence {
    public static void main(String[] args) {
        if (args.length == 1) {
            long startTime = System.nanoTime();
            int n = Integer.parseInt(args[0]); //  <- Max. 92-th Term
            if (n < 1 || n > 92) {
                showHelp();
                return;
            }

            long[] fib = countFibos(n);
            String numeral = getNumeral(n);

            for (int i = 0; i < n; i++) {
                System.out.printf("[#%d : %s], ", i + 1, fib[i]);
            }
            System.out.printf("#%d%s number of Fibonacci Sequence: %d\n", n, numeral, fib[n - 1]);

            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000;
            System.out.printf("Program execution time: %.3f seconds", duration / 1000.0);
        } else {
            System.out.println("Programmaufruf: 'java FibonacciSequence n'");
        }
    }

    private static long[] countFibos(int n) {
        long[] fib = new long[n];
        fib[0] = 1;
        if (fib.length > 1) fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }
        return fib;
    }

    private static String getNumeral(int n) {
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
        System.out.println("n muss sich im Bereich 1 - 92 befinden!");
        System.out.println("Starte das Programm neu mit Korrekten Parametern!");
    }
}
