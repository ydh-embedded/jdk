public class TIME {
//#region #NOTE global variables

//#endregion


  public static void main(String[] args) {

  public static void openTimeSheet(Path path) throws IOException {

    
        if (args.length < 1) {
            System.out.println("Aufruf: LogReader <pfad>");
            return;
        }

        Path logPath = Path.of(args[0]);

        Scanner scanner = null;
        try {
            String logContent = Files.readString(logPath, StandardCharsets.UTF_8);
            scanner = new Scanner(logContent);

            for (int lineNumber = 1; scanner.hasNextLine(); lineNumber++) {
                String line = scanner.nextLine();
                formatLogLine(lineNumber, line);          //#FIXME Methode formatLogLine fehlt
            }

        } catch (AccessDeniedException e) {
            System.err.printf("Der Lesezugriff auf Datei %s wurde nicht gestattet.\n", logPath);
        } catch (NoSuchFileException e) {
            System.err.printf("Datei %s existiert nicht.\n", logPath);
        } catch (IOException ioe) {
            System.err.printf("Die Datei %s konnte aus unbekannten Gründen nicht gelesen werden.\n", logPath);
            System.err.printf("Exception: %s\n", ioe);
        } finally {
            // Dieser Block wird sowohl im Erfolgsfall als auch im
            // Fehlerfall ausgeführt.
            if (scanner != null) {
                scanner.close();
            }
        }





    throw new RuntimeException("Not implemented yet");
  }

  public static void closeTimeSheet() {
    throw new RuntimeException("Not implemented yet");
  }


  }
}