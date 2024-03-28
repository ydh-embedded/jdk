public class DURATION {
//#region #NOTE global variables

//#endregion


public static void main(String[] args) {
  public static void printLine(int lineNumber, String date, int startHours, int startMinutes, int endHours, int endMinutes) {

    var scanner = new Scanner(lineNumber);

        int lineNumber    = scanner.next();
        String date       = scanner.next();         // DATE
        int startHours    = scanner.next();         // START
        int startMinutes  = scanner.next();
        int endHours      = scanner.next();         // END
        int endMinutes    = scanner.next();
        String message    = scanner.nextLine();     // REMARKS



//#region // #NOTE  <HEADER>
  public static void printHeader(String year, String month, String employeeId) {
    
    String ID = employeeId ;
    String M  = month ;
    String Y  = year  ;

        System.out.println(THICK_BORDER);
    //  System.out.println("YEAR: 2024 / MONTH: 03 / ID: WE007");
        System.out.println("YEAR: %s / MONTH: %s / ID: %s" , Y , M , ID);
        System.out.println(THICK_BORDER);

  }
//#endregion

//#region // #NOTE   <MAIN> 
  public static void printReport(int year, int month, String employeeId) {

    System.out.printf(
            "%s"  + "%s" + "%d"+ "%s"        + "%d"+ "%s"         + "%d"+ "%d" + "%s"     + "%s"+ "%s"    + "(Zeile: %02d)\n"
          , date, PIPE   , startHours, PIPE  , startMinutes, PIPE , endHours, endMinutes, PIPE , message, PIPE , lineNumber);
    
  }

//#endregion 

//#region // #NOTE  <Footer>
  public static void printFooter( int workingTime , int presentDays  , int absentDays , int incompleteDays , int totalRecords,   ) {



        System.out.println(THIN_BORDER);
        System.out.printf( "WORKING TIME : %02d\n"  , workingTime)      ;
        System.out.printf( "PRESENT: %02d\n"        , presentDays)      ;
        System.out.printf( "ABSENT: %02d\n"         , absentDays)       ;
        System.out.printf( "INCOMPLETE: %02d\n"     , incompleteDays)   ;
        System.out.printf( "RECORDS: %02d\n"        , totalRecords)     ;
        System.out.println(THIN_BORDER);


        scanner.close();
//#endregion


  }










  }
}