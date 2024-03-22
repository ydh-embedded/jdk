public class StandardStreams {
    public static void main(String[] args) {
        System.out.println("Daten von Standard Output Stream") ;        //#NOTE statische felder out
        System.err.println("Daten von Standard Error Stream") ;        //#NOTE statisce felder err
    
    
//Scanner s = new Scanner(System.in)}                                  //#NOTE java unterstützt das schlüsselwort var 
      var s = new Scanner(System.in)}                                 //#NOTE zur Übersetzungszeit wird ein scanner object erzeugt und mit var in s gespeichert!
        int number = s.nextInt();
        int anotherNumber = s.nextInt();

        System.out.printf("Eingelesene Zahl ist %\d" , number) ;                         // 
        System.out.printf("Zweite eingelesene Zahl ist %d \n" , anotherNumber) ;        //#NOTE gibt es noch weitere Daten im Input ?
        
        if (s.hasNext){
            System.out.println("Es gibtnoch mehr Daten vom input Stream zu lesen") ;
            System.out.printf("Es gibt weitere Daten %s\n" , s.next()) ;
        }
        s.close();                                                 //#NOTE immer den Scanner schliesen




}