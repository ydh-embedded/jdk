![](.\screens\java.ico)

   # Java

## launch4j


## Quellen:
-   mittel.com (1)
-   javatpoint.com (2)
-   mittel.com (3)
-   wikihow.com (4)

Wir erstellen eine ausführbare Datei (.exe) von ```App.jar```-Datei mit Launch4j 

## Steps:

-  Suchen oder erstellen Sie ein 256 x 256-Bild,
   das als Symbol für Ihre EXE-Datei verwendet werden kann.
   -  Konvertieren Sie das Bild mit einer Website wie in eine ```"ico"``` -Datei https://convertico.com/
-  Laden Sie ```Launch4j``` von herunter http://sourceforge.net/projects/launch4j/files/launch4j-3/3.1.0-beta1/

-  Öffnen Sie Launch4j
-  ```This application requires a java Runtime Enviroment 1.8.0````
-  Wir müssen zunächst eine alte Runtime lokal installieren


## Download JRE 1.8.0:
First, you'll need to download the JRE 1.8.0 installer from the official Oracle website.
You can find the download link here.
Make sure to select the appropriate version for your operating system (Windows, Mac, or Linux).

## Install JRE 1.8.0:
Once you've downloaded the installer, run the installer and follow the on-screen instructions to install the JRE. During the installation process, you may choose to install the JRE in a specific directory,
such as C:\working-directory\jdk\jre1.8.0.

## Download Launch4J:
Launch4J is a tool that allows you to create
native Windows executables from Java applications.
You can download the latest version of Launch4J from the official website.
Once downloaded, extract the contents of the zip file to a directory of your choice.

## Create a Launch4J Configuration File:
In order to create a native Windows executable for your Java application,
you'll need to create a Launch4J configuration file.
This file specifies the location of the JRE installation,
as well as other settings for your application. Here's an example configuration file:

```js
<launch4jConfig>
  <headerType>console</headerType>
  <dontWrapJar>false</dontWrapJar>
  <jar>path/to/your/application.jar</jar>
  <jre>
    <minVersion>1.8.0</minVersion>
    <initialHeapSize>256</initialHeapSize>
    <maxHeapSize>512</maxHeapSize>
    <path>C:\working-directory\jdk\jre1.8.0</path>
  </jre>
  <versionInfo>
    <fileVersion>1.0.0.0</fileVersion>
    <productVersion>1.0.0.0</productVersion>
    <fileDescription>Your application name</fileDescription>
    <copyright>Copyright © Your name</copyright>
    <productName>Your application name</productName>
    <companyName>Your company name</companyName>
  </versionInfo>
</launch4jConfig>
```
Replace the values in the versionInfo section with the appropriate information for your application.

## Run Launch4J:
 Once you've created the configuration file, run Launch4J and open the configuration file. Click the "Build" button to create the native Windows executable. Launch4J will create a .exe file in the directory where you saved the configuration file.

## Test the Application:
 Double-click the .exe file to test the application. If the application requires a Java Runtime Environment, Launch4J will automatically launch the application using the JRE you specified in the configuration file.

That's it!
 You've successfully created a native Windows executable for your Java application using Launch4J and JRE 1.8.0.

-  geben Sie den Namen und das Ziel der Ausgabedatei für die EXE-Datei neben ```"Ausgabedatei"``` ein."
-  Wählen Sie die JAR-Datei neben ```"Jar."```
-  Wählen Sie die ICO-Datei neben ```"Ico."```
-  Klicken Sie auf die Registerkarte ```"JRE"``` und geben Sie ```"1.4.0"``` neben ```"Min JRE"``` ein."
-  Klicken Sie auf das Zahnradsymbol
   und geben Sie einen Namen für die Datei ```".xml"``` neben ```"Dateiname"``` ein.
   Klicken Sie auf ```"Speichern."```
-  Doppelklicken Sie auf erstellte EXE-Datei, um Ihre Anwendung auszuführen.
