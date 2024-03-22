public class WhileLoop {

    public static void main(String[] args) {
        int index = 0   ;                                      // Declare and initialize the index variable
        while (index < args.length) {
            System.out.printf("Argument %d: %s\n", 
                                index + 1        , 
                                args[index])    ;
            index++     ;                                        // Increment the index variable
        }
    }
}