public class DATE {
//#region #NOTE global variables

//#endregion


  public static void main(String[] args) {

      // #STUB -  <Datum>
  public static String daysOfMonth(int year, int month) {

    if (year < 1 || month < 1 )
        throw new RuntimeException("the method daysOfMonth is is not running [Line: ]");
    else { // maximale Anzahl der Tage in dem jeweiligen Monat
    
        switch (month) {

            case 2:       // Februar
                if (isLeapYear(year)) {
                    numDays = 29;
                } else {
                    numDays = 28;
                }
                break;

            case 1:       // Januar
            case 3:       // März
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;


            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;


            default:
                numDays = 0;
        }

        formattedDate.append(numDays);
        formattedDate.append(" ");
    }
    else {
        int iY   = year      ;
        int iM   = month     ;

      StringBuilder  formattedDate = new StringBuilder() ;



      if (iM < 10) { formattedDate.append("0") ; }     //#NOTE Format: mm.
                     formattedDate.append(iM)  ;
                     formattedDate.append(".") ;

                     formattedDate.append(iY)  ;
                     formattedDate.append(" ") ;       //#NOTE Format: yyyy


    }
    return formattedDate.toString();
    

  }

  // #STUB - <Uhrzeit>
  public static String formatTime(int hours, int minutes) {

        int iH    = hours   ;
        int iM    = minutes ;
    //  int iS    = seconds ;

    if (hours < 1 || minutes < 1  )
        throw new RuntimeException("The method formatTime is not running [ Line:  ]");
    else
    {
      StringBuilder   formattedTime = new StringBuilder() ;

      if (iH < 10) {  formattedTime.append("0") ; }     //#NOTE Format: hh:
                      formattedTime.append(iH)  ;
                      formattedTime.append(":") ;

      if (iM < 10) {  formattedTime.append("0") ; }     //#NOTE Format: mm.
                      formattedTime.append(iM)  ;
                      formattedTime.append(".") ;

      if (iS < 10) {  formattedTime.append("0") ; }     //#NOTE Format: ss
                      formattedTime.append(iS)  ;
                      formattedTime.append("/n") ;
    }
    return formattedTime.toString();

  }

  // #STUB - <Datum> DD.MM.YYYY
  public static String formatDate(int year, int month, int day) {
    if (year < 1 || month < 1 || day < 1 )
        throw new RuntimeException("The method formatDate is not running [ Line:  ]");
    else
    {
      StringBuilder   printDate = new StringBuilder() ;

                      printDate.append(day)    ;     //#NOTE Format: DD.

                      printDate.append(month)  ;     //#NOTE Format: MM.

                      printDate.append(year)   ;     //#NOTE Format: YYYY
    }
    return printDate.toString();
  }


    
  }
}