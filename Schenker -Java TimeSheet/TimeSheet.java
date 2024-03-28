// You are free to use these classes, but don't
// add your own imports.
import java.util.Arrays;
import java.io.IOException;
import static java.lang.System.out;
import static java.lang.System.err;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TimeSheet {

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
    if (args.length < 1) {
      out.println("Usage: TimeSheet <time-sheet-name>");
      return;
    }

    try {
      String timeSheetName = args[0].toLowerCase();
      openTimeSheet(Path.of("time-sheets", timeSheetName + TIME_SHEET_EXTENSION));

      String[] timeSheetNameFields = timeSheetName.split("-");
      int year = Integer.parseInt(timeSheetNameFields[0]);
      int month = Integer.parseInt(timeSheetNameFields[1]);
      String employeeId = timeSheetNameFields[2];

      printReport(year, month, employeeId);

    } catch (IOException e) {
      err.printf("Unable to load time sheet. Details: %s", e);
    }
    finally {
      closeTimeSheet();
    }
  }

  // Return the number of days in a month.
  // Leap years are taken into account.
  public static int daysOfMonth(int year, int month) {
    boolean isLeapYear = year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
    return switch (month) {
      case 1, 3, 5, 7, 8, 10, 12 -> 31;
      case 4, 6, 9, 11 -> 30;
      case 2 -> isLeapYear ? 29 : 28;
      default -> throw new IllegalArgumentException("Invalid month: %02d".formatted(month));
    };
  }

  // Return a string in the format hh:mm.
  public static String formatTime(int hours, int minutes) {
    return "%02d:%02d".formatted(hours, minutes);
  }

  // Returns a formatted date of the form: dd.mm.yyyy.
  public static String formatDate(int year, int month, int day) {
    return "%02d.%02d.%04d".formatted(day, month, year);
  }

  // Format given minutes in hours and seconds
  // and return these values as a string in the format
  // xxh yym. Example: 02h 15m
  public static String formatDuration(int totalMinutes) {
    int hours = totalMinutes / MINUTES_PER_HOUR;
    int minutes = totalMinutes % MINUTES_PER_HOUR;
    return "%02dh %02dm".formatted(hours, minutes);
  }

  // Add spaces to string until it contains
  // at least minLength characters. If prepend is true,
  // spaces are added to the start of the string, otherwise they
  // are appended to the end.
  public static String pad(String s, int minLength, boolean prepend) {
    if (s.length() >= minLength) {
      return s;
    }
    String padding = " ".repeat(minLength - s.length());
    return prepend ? padding + s : s + padding;
  }

  // Add spaces to the start of the string until it has
  // at least minLength characters. Avoid code redundancy
  // by using pad method.
  public static String padStart(String s, int minLength) {
    return pad(s, minLength, true);
  }

  // Add spaces to the end of the string until it has
  // at least minLength characters. Avoid code redundancy
  // by using pad method.
  public static String padEnd(String s, int minLength) {
    return pad(s, minLength, false);
  }

  // Calculate the duration between the two given times, in minutes.
  // If the second time is before the first time, assume that the second time
  // refers to the next day.
  public static int durationInMinutes(int startHours, int startMinutes, int endHours, int endMinutes) {
    boolean isStartAfterEnd = startHours > endHours || startHours == endHours && startMinutes > endMinutes;
    if (isStartAfterEnd) {
      endHours += 24;
    }
    return (endHours - startHours) * MINUTES_PER_HOUR + endMinutes - startMinutes;
  }

  // Print a line for the given date.
  // A line has the format: <date> <start-time> <end-time> <duration> <remarks>.
  // Date has the format: dd.mm.yyyy.
  // Time and duration have the format: hh:mm.
  // Missing values are printed as: n/a.
  // If startHours or startMinutes is negative, the start time is considered missing.
  // If endHours or endMinutes is negative, the end time is considered missing.
  // If start and end time are missing, remarks is "absent".
  // If both start and end time are available, remarks is "present".
  // If exactly one time value is missing, remarks is "clarification needed".
  public static void printLine(String date, int startHours, int startMinutes, int endHours, int endMinutes) {
    boolean hasStartTime = startHours >= 0 && startMinutes >= 0;
    boolean hasEndTime = endHours >= 0 && endMinutes >= 0;

    String remarks;
    if (hasStartTime && hasEndTime) {
      remarks = PRESENT;
    } else if (!(hasStartTime || hasEndTime)) {
      remarks = ABSENT;
    } else {
      remarks = CLARIFICATION_NEEDED;
    }

    String duration = hasStartTime && hasEndTime
      ? formatDuration(durationInMinutes(startHours, startMinutes, endHours, endMinutes))
      : NOT_AVAILABLE;

    String[] values = {
      padStart(date, DATE_FIELD_WIDTH),
      padEnd(hasStartTime ? formatTime(startHours, startMinutes) : NOT_AVAILABLE, TIME_FIELD_WIDTH),
      padEnd(hasEndTime ? formatTime(endHours, endMinutes) : NOT_AVAILABLE, TIME_FIELD_WIDTH),
      padEnd(duration, DURATION_FIELD_WIDTH),
      remarks,
    };

    out.println(String.join(DELIMITER, values));
  }

  // Prints the report's header.
  public static void printHeader(int year, int month, String employeeId) {
    String[] values = {
      "YEAR: %04d".formatted(year),
      "MONTH: %02d".formatted(month),
      "ID: %s".formatted(employeeId.toUpperCase()),
    };
    out.println(THICK_BORDER);
    out.println(String.join(" / ", values));
    out.println(THICK_BORDER);
    out.println();

    String[] columns = {
      padEnd("DATE", DATE_FIELD_WIDTH),
      padEnd("START", TIME_FIELD_WIDTH),
      padEnd("END", TIME_FIELD_WIDTH),
      padEnd("DURATION", DURATION_FIELD_WIDTH),
      "REMARKS",
    };
    out.println(String.join(DELIMITER, columns));
    out.println(THIN_BORDER);
  }

  // Prints the report's footer.
  // totalRecords   - number of records read from time sheet file
  // incompleteDays - number of days where either start or end time is missing
  // absentDays     - number of days with no records at all
  // presentDays    - number of days with start and end time
  // workingTime    - number of total minutes worked in this month
  public static void printFooter(int totalRecords, int incompleteDays, int absentDays, int presentDays, int workingTime) {
    final String delimiter = " %s ".formatted(PIPE);
    String[] values = {
      "WORKING TIME : %s".formatted(formatDuration(workingTime)),
      "PRESENT      : %02d".formatted(presentDays),
      "ABSENT       : %02d".formatted(absentDays),
      "INCOMPLETE   : %02d".formatted(incompleteDays),
      "RECORDS      : %02d".formatted(totalRecords),
    };
    out.println(THIN_BORDER);
    for (String value : values) {
      out.println(value);
    }
    out.println(THIN_BORDER);
  }

  // Opens the time sheet file using the fileScanner.
  // Assume that the file is encoded in UTF8.
  // If the time sheet is already open, do nothing.
  // An IOException must be handled in main.
  public static void openTimeSheet(Path path) throws IOException {
    if (fileScanner == null) {
      fileScanner = new Scanner(path, StandardCharsets.UTF_8);
    }
  }

  // Closes the time sheet by closing the fileScanner.
  // If the time sheet isn't open, do nothing.
  public static void closeTimeSheet() {
    if (fileScanner != null) {
      fileScanner.close();
    }
  }

  // Reads the next line from the time sheet and converts
  // its values to integers (day, hours, minutes).
  // If there is no more line, null is returned.
  // Blank lines must be skipped automatically.
  public static int[] nextRecord() {
    while (fileScanner.hasNextLine()) {
      String line = fileScanner.nextLine().trim();
      if (line.isBlank()) {
        continue;
      }
      String[] fields = line.split(";");
      var values = new int[fields.length];
      for (int i = 0; i < fields.length; i++) {
        values[i] = Integer.parseInt(fields[i].trim());
      }
      return values;
    }
    return null;
  }

  // Prints the full report: header, day entries, footer.
  // This method makes use of nextRecord and calculates the
  // statistics which are then printed in the footer.
  public static void printReport(int year, int month, String employeeId) {
    int daysOfMonth = daysOfMonth(year, month);
    int totalWorkingTime = 0;
    int totalRecords = 0;
    int totalAbsentDays = 0;
    int totalIncompleteDays = 0;
    int totalPresentDays = 0;

    printHeader(year, month, employeeId);

    int[] record = null;
    boolean shouldReadRecord = true;
    for (int day = 1; day <= daysOfMonth; day++) {
      if (shouldReadRecord) {
        record = nextRecord();
        totalRecords += record == null ? 0 : 1;
      }
      if (record == null || day < record[0]) {
        totalAbsentDays++;
        printLine(formatDate(year, month, day), -1, -1, -1, -1);
        // Don't read a new record in the next loop,
        // because this one is for a later day.
        shouldReadRecord = false;
        continue;
      }

      assert day == record[0];
      int startHours = record[1];
      int startMinutes = record[2];
      int endHours = -1;
      int endMinutes = -1;

      record = nextRecord();
      totalRecords += record == null ? 0 : 1;
      if (record == null || day < record[0]) {
        totalIncompleteDays++;
        shouldReadRecord = false;
      } else {
        totalPresentDays++;
        endHours = record[1];
        endMinutes = record[2];
        totalWorkingTime += durationInMinutes(startHours, startMinutes, endHours, endMinutes);
        shouldReadRecord = true;
      }

      printLine(formatDate(year, month, day), startHours, startMinutes, endHours, endMinutes);
    }

    out.println();
    printFooter(totalRecords, totalIncompleteDays, totalAbsentDays,
      totalPresentDays, totalWorkingTime);
  }

}
