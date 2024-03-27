![](.\screens\java.ico)

   # Java

## wir legen den Path zur Java.exe fest :

```powershell
>> terminal

   $env:PATH += ";C:\working-directory\jdk\JDK21\jdk-21.0.2\bin\"

```
.

```powershell
>> terminal #NOTE wir geben aus, ob der vorherige Befehl ohne Fehler abgeschlossen wurde!

   $?

```
.


![](.\screens\cmd.png)

.
## Wir führen die App aus


```js
>> terminal 

   java App

```

![](.\screens\App.png)

```js
>> terminal //#NOTE wir erzeugen die JAR-Datei mit allen Dateien im aktuellen Verzeichniss (mit -C . . )


   jar --create --file HelloWorld.jar --verbose --main-class App -C . . 
```
.

```js
>> terminal //#NOTE wir erzeugen die JAR-Datei mit zusätzlichen Dateien im Pfad JDK22


   jar --create --file HelloWorld.jar --verbose --main-class App -C . . -C C:\working-directory\jdk\JDK22 .
```
.

```js
>> terminal # wir prüfen , ob der Befehl ausgeführt worden ist

   $?

```
.

-  Dieser Befehl erstellt eine JAR-Datei mit dem Namen ```HelloWorld.jar```
-  Sie enthält die ```App.class``` Datei mit dem angegebenen ```main-class```.

-  Kurze Erklärung des jar verwendete Befehlsoptionen:

   -  ```--create``` Erstellt eine neue JAR-Datei.
   -  ```--file <filename>``` Gibt den Ausgabe-JAR-Dateinamen an.
   -  ```--main-class <classname>``` Legt die Hauptklasse für die JAR-Datei fest.
   -  ```-C <directory> <path>``` Ändert das Verzeichnis und enthält den angegebenen Pfad.

.

![](.\screens\Jar.png)

.


```js
>> terminal //#NOTE wir führen die JAR Datei aus

   java -jar HelloWorld.jar

```
.

