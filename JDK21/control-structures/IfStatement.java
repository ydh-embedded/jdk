public class IfStatement {
    public static void main(String[] args){
        if (args.length >= 2) {
            System.out.printf("Fullname: %s , %s \n" , args[0], args[1]);
        } else if (args.length >= 1 ) {
            System.out.printf("Fullname: %s" , args[0]);

        } else {
            System.out.println("Bitte den Namen und Vornamen eingeben");

        }
    }
}