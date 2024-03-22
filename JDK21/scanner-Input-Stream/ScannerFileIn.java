import  java.util.Scanner ;
import  java.util.InputMismatchExcception ;


public class ScannerFileIn {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Zahl-Eingabe: ") ;                   
        System.out.println("für eine Addition ") ;         //#NOTE 
        int sum = 0 ;

        while (true) {
            try {
                int number = scanner.nextInt() ;
                sum += number ;
            } catch (InputMismatchExcception ime) {                    //#NOTE wir schauen in der API nach der Exception nach
                                                                    // und importieren diese im kopf
                
                System.out.println("Es wurden keine Zahlen eingegeben: " + scanner.nextInt() ) ;                   
                break ;
            } catch (Exception e){

                System.out.println("Es wurden keine Eingaben gemacht: " + scanner.nextInt() ) ;                   
                break ;
            }
        }
    
    
    
    
    
        scanner.close();
    }

}