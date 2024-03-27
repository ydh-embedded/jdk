![](java.ico)

## packaging in jar

-   Der Punkt am Ende sagt aus, dass alle Dateien im aktuellen Verzeichniss angewendet werden.


-   oder ausgeschrieben:

```java
>> java

jar --create --file MyApp.jar -verbose --main-class de.iad.MainApp .

```
- mit folgenden Befehl führen wir jar aus

```powershell
>> powershell

 .\build.ps1
 cd .\out\
 jar -c -f my-app.jar -v --main-class MainApp .
 java -jar .\my-app.jar

```

```powershell
>> powershell

jar -c -f MyApp.jar -v --main-class MainApp .

```

```powershell
>> powershell

java -jar C:\dev\MyApp.jar --argument1 --argument2 .

```



## packages anlegen

-   ein java package ist eine Verzeichnissstruktur, in der Quelltext-Dateien und class-Dateien für den compiler hinterlegt sind. 

## classPath

-   dieser ist eine Liste von Verzeichnissen& JAR-Dateine getrenn durch Semikolon 

-   unter Windows
```powershell
>> powershell

java -d output --class-path ".;C:\libs\*;C:\vendor\my-packages"

```
# generelle Aufruf
-   unter Windows
```powershell
>> powershell

jar --create --file <filename-of-jar> --main-class  <full-qualified-name-of-main-class>
```

