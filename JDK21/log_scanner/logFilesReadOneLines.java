import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;

import java.nio.file.AccessDeniedException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.nio.charset.StandardCharsets;

import java.io.IOException;
import java.io.FileNotFoundException;


public class logFilesReadOneLines {

    
  //public static void main(String[] args) throws IOException { #NOTE damit delegieren wir die exception an den main zurück
    public static void main(String[] args) {
        if (args.length < 1) {
                System.out.println("Aufruf: LogReader <pfad>");
        return;
}
            String logContent = Files.readString(logPath, StandardCharsets.UTF_8) ;

            Path logPath = Path.of(args[0]) ;
            // if(Files.notExists(logPath)){
            //     System.err.printf("Die Datei %s existiert nicht") ;
            //     return ;

            // }
        
        var scanner = new Scanner(logContent).useLocale(Locale.GERMANY);


        try {

            for (int lineNumber =1 ; scanner.hasNextLine() == true ; lineNumber++) {

                String line = scanner.nextLine() ;
                formatLogLine(lineNumber , line );
            }

        } catch (NoSuchFileException nsfe) {

            System.err.printf("Die Datei %s existiert nicht in dem Pfad!\n" , logPath) ;
        

        } catch (AccesDeniedException ade) {

            System.err.printf("Die Datei %s konnte nicht mit den Benutzer Rechten gelesen werden .\n" , logPath) ;
        
        } catch (IOException ioe) {

            System.err.printf("Die Datei %s konnte nicht gelesen werden .\n" , logPath) ;
            System.err.printf("Details %s\n" , ioe.getMessage()) ;

        } finally {
            scanner.close();
        }


    }

    public static void formatLogLine(int lineNumber , String line) {
        var scanner = new Scanner(line) ;
        String date = scanner.next()    ;
        String time = scanner.next()    ;
        String message = scanner.nextLine() ;


        final String ruler = "=" .repeat(60) ;
        System.out.println(ruler) ;

        System.out.printf( "Zeile:  %04d \n"    , lineNumber ) ;
        System.out.printf( "Datum:  %s\n"       , date      ) ;
        System.out.printf( "Zeit:   %s\n"       , time      ) ;
        System.out.printf( "Message:%s\n"       , message   ) ;
    }
}