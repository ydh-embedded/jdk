// You are free to use these classes, but don't
// add your own imports.
import java.util.Arrays;
import java.io.IOException;
import static java.lang.System.out;
import static java.lang.System.err;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TimeSheetReport {

  // These global variables can be used in your code.
  // Feel free to add your own.
  public static final int BORDER_LENGTH = 70;
  public static final String THIN_BORDER = "-".repeat(BORDER_LENGTH);
  public static final String THICK_BORDER = "=".repeat(BORDER_LENGTH);
  public static final String PIPE = "|";
  public static final String DELIMITER = " " + PIPE + " ";
  public static final int MINUTES_PER_HOUR = 60;
  public static final String TIME_SHEET_EXTENSION = ".txt";
  public static final String NOT_AVAILABLE = "n/a";
  public static final String CLARIFICATION_NEEDED = "clarification needed";
  public static final String PRESENT = "fully present";
  public static final String ABSENT = "absent";
  public static final int TIME_FIELD_WIDTH = 5;
  public static final int DURATION_FIELD_WIDTH = 8;
  public static final int DATE_FIELD_WIDTH = 10;

  // This scanner is used to open and close a time sheet.
  // It's also used to read the next record in the file.
  public static Scanner fileScanner;

  // The program's execution starts here.
  // The name of the time sheet file is provided as
  // a command line argument. You must append the
  // file extension txt and locate the file in the
  // sub directory time-sheets.
  // If no argument is provided by the user, a help
  // message should be printed.
  public static void main(String[] args) {
    // 1. Print a help message, if no arguments are provided.
    //    and exit.

    // 2. Extract year, month and employee from the filename.
    // 3. Build the path to the time sheet file and open it.
    // 4. Print the full report.

    // If an IOException occurs, inform the user with a message,
    // close the time sheet and exit gracefully.
  }

  // Return the number of days in a month.
  // Leap years are taken into account.
  public static int daysOfMonth(int year, int month) {
    throw new RuntimeException("Not implemented yet");
  }

  // Return a string in the format hh:mm.
  public static String formatTime(int hours, int minutes) {
    throw new RuntimeException("Not implemented yet");
  }

  // Returns a formatted date of the form: dd.mm.yyyy.
  public static String formatDate(int year, int month, int day) {
    throw new RuntimeException("Not implemented yet");
  }

  // Format given minutes in hours and seconds
  // and return these values as a string in the format
  // xxh yym. Example: 02h 15m
  public static String formatDuration(int totalMinutes) {
    throw new RuntimeException("Not implemented yet");
  }

  // Add spaces to string until it contains
  // at least minLength characters. If prepend is true,
  // spaces are added to the start of the string, otherwise they
  // are appended to the end.
  public static String pad(String s, int minLength, boolean prepend) {
    throw new RuntimeException("Not implemented yet");
  }

  // Add spaces to the start of the string until it has
  // at least minLength characters. Avoid code redundancy
  // by using pad method.
  public static String padStart(String s, int minLength) {
    throw new RuntimeException("Not implemented yet");
  }

  // Add spaces to the end of the string until it has
  // at least minLength characters. Avoid code redundancy
  // by using pad method.
  public static String padEnd(String s, int minLength) {
    throw new RuntimeException("Not implemented yet");
  }

  // Calculate the duration between the two given times, in minutes.
  // If the second time is before the first time, assume that the second time
  // refers to the next day.
  public static int durationInMinutes(int startHours, int startMinutes, int endHours, int endMinutes) {
    throw new RuntimeException("Not implemented yet");
  }

  // Print a line for the given date.
  // A line has the format: <date> <start-time> <end-time> <duration> <remarks>.
  // Date has the format: dd.mm.yyyy.
  // Time and duration have the format: hh:mm.
  // Missing values are printed as: n/a.
  // If startHours or startMinutes is negative, the start time is considered missing.
  // If endHours or endMinutes is negative, the end time is considered missing.
  // If start and end time are missing, remarks is "absent".
  // If both start and end time are available, remarks is "fully present".
  // If exactly one time value is missing, remarks is "clarification needed".
  public static void printLine(String date, int startHours, int startMinutes, int endHours, int endMinutes) {
    throw new RuntimeException("Not implemented yet");
  }

  // Prints the report's header.
  // The header contains borders, year, month and employee id.
  // It also prints the column names for the day entries.
  public static void printHeader(int year, int month, String employeeId) {
    throw new RuntimeException("Not implemented yet");
  }

  // Prints the report's footer.
  // totalRecords   - number of records read from time sheet file
  // incompleteDays - number of days where either start or end time is missing
  // absentDays     - number of days with no records at all
  // presentDays    - number of days with start and end time
  // workingTime    - number of total minutes worked in this month
  public static void printFooter(int totalRecords, int incompleteDays, int absentDays, int presentDays, int workingTime) {
    throw new RuntimeException("Not implemented yet");
  }

  // Opens the time sheet file using the fileScanner.
  // Assume that the file is encoded in UTF8.
  // If the time sheet is already open, do nothing.
  // An IOException must be handled in main.
  public static void openTimeSheet(Path path) throws IOException {
    throw new RuntimeException("Not implemented yet");
  }

  // Closes the time sheet by closing the fileScanner.
  // If the time sheet isn't open, do nothing.
  public static void closeTimeSheet() {
    throw new RuntimeException("Not implemented yet");
  }

  // Reads the next line from the time sheet and converts
  // its values to integers (day, hours, minutes).
  // If there is no more line, null is returned.
  // Blank lines must be skipped automatically.
  public static int[] nextRecord() {
    throw new RuntimeException("Not implemented yet");
  }

  // Prints the full report: header, day entries, footer.
  // This method makes use of nextRecord and calculates the
  // statistics which are then printed in the footer.
  public static void printReport(int year, int month, String employeeId) {
    throw new RuntimeException("Not implemented yet");
  }

}
