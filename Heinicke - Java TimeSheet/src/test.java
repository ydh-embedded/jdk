// #STUB -  <Datum>
public static String daysOfMonth(int year, int month) {

    if (year < 1 || month < 1) {
        throw new RuntimeException("the method daysOfMonth is not running [Line: ]");
    } else {
        int iY = year;
        int iM = month;
        int numDays = 0;

        StringBuilder formattedDate = new StringBuilder();

        if (iM < 10) {
            formattedDate.append("0");
        } // NOTE: Format: MM.
        formattedDate.append(iM);
        formattedDate.append(".");

        formattedDate.append(iY);
        formattedDate.append(" "); // NOTE: Format: YYYY

        // Determine the number of days in the given month
        switch (iM) {
            case 1:
            case 3:
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
            case 2:
                // Determine the number of days in the month of February
                if (isLeapYear(iY)) {
                    numDays = 29;
                } else {
                    numDays = 28;
                }
                break;
            default:
                numDays = 0;
        }

        // Add the number of days in the month to the formatted date
        formattedDate.append(numDays);
        formattedDate.append(" ");
    }

    return formattedDate.toString();
}

// Helper method to check if the given year is a leap year
private static boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
}