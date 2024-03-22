

try {
    // code that might throw an exception
    int result = 10 / 0; // dividing by zero will throw an ArithmeticException
} catch (ArithmeticException e) {
    // code that will execute if an ArithmeticException is thrown
    System.out.println("An ArithmeticException occurred: " + e.getMessage());
}






try {
    // code that might throw an exception
} catch (ArithmeticException | NullPointerException e) {
    // code that will execute if either an ArithmeticException or NullPointerException is thrown
}