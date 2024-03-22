
public class SwitchStatement {

    public static void main(String[] args ) {

        //#NOTE Mehrfachauswahl

//#region        //#NOTE switch Monate
        String month = "january" ;
        int daysInMonth = 0     ;
        switch (month) {

            case "january"  :               // Fall Januar
                daysIn Month = 31 ;            //Blockanweisung
                break;

            case "february"  :               // Fall Januar
                daysIn Month = 28 ;            //Blockanweisung
                break;

            case "march"  :               // Fall Januar
                daysIn Month = 31 ;            //Blockanweisung
                break;

            case "april"  :               // Fall Januar
                daysIn Month = 30 ;            //Blockanweisung
                break;

            case "may"  :               // Fall Januar
                daysIn Month = 31 ;            //Blockanweisung
                break;

            case "june"  :               // Fall Januar
                daysIn Month = 30 ;            //Blockanweisung
                break;

            case "july"  :               // Fall Januar
                daysIn Month = 31 ;            //Blockanweisung
                break;

            case "August"  :               // Fall Januar
                daysIn Month = 30 ;            //Blockanweisung
                break;

            case "september"  :               // Fall Januar
                daysIn Month = 31 ;            //Blockanweisung
                break;

            case "october"  :               // Fall Januar
                daysIn Month = 30 ;            //Blockanweisung
                break;

            case "november"  :               // Fall Januar
                daysIn Month = 31 ;            //Blockanweisung
                break;

            case "december"  :               // Fall Januar
                daysIn Month = 30 ;            //Blockanweisung
                break;

        default:
                daysInMonth = 30 ;
                break;
        }
//#endregion
//#region        //#NOTE switch Letter
        char letter = 'e' ;
        switch (letter) {

                case 'a' , 'e' , 'i' -> {
                 System.out.printf("Letter %c is a vowel \n" , letter) ;                // #NOTE -> ist eine expliziete Anweisung und führt den nachstehenden Code-CBlock aus
                 System.out.printf("Vowels are a,e,i,o \n") ; }                         // #NOTE -> ist eine expliziete Anweisung und führt den nachstehenden Code-CBlock aus
        }
//#endregion
    }
}