![](.\screens\java.ico)

   # Java
## JAR


-   Bevor Sie das jpackage-Tool verwenden können,
    müssen Sie eine auslaufbare JAR-Datei erstellen,
    die Ihre Anwendung enthält. Sobald Sie Ihre JAR-Datei haben,
    können Sie mit dem folgenden Befehl ein Installationsprogramm erstellen:



```js
>> powershell
jpackage -i ./path/to/input/directory 
-d ./path/to/output/directory --name "AppName" 
--main-class com.example.MainClass

```
.

```js
>> powershell
jpackage -i ./path/to/input/directory 
-d ./path/to/output/directory --name "AppName" 
--main-class de.iad.MainClass

```
.

## Definition

- ```-i ```Gibt das Eingabeverzeichnis an,
in dem sich die JAR-Datei befindet.
- ```-d``` Gibt das Ausgabeverzeichnis an,
 in dem das Installationsprogramm erstellt wird.
- ```--name``` gibt den Namen des Installationsprogramms an.

- ```--main-class``` Gibt die Hauptklasse für die Anwendung an.

Wenn Sie eine modulare Anwendung haben, können Sie den folgenden Befehl verwenden:


```js
>> powershell
jpackage -n name -p modulePath -m moduleName/className

```
.


```-n``` gibt den Namen der Anwendung an.

```-p``` Gibt den Pfad zum Modul an.

```-m``` Gibt den Modulnamen und den Klassennamen an.


Wenn Sie eine nicht modulare Anwendung haben, können Sie den folgenden Befehl verwenden:

```js
>> powershell

    jpackage -i inputDir -n name --main-class className --main-jar myJar.jar

```
.

```--type``` Gibt den Typ des Anwendungsbildes an.

```-n``` gibt den Namen der Anwendung an.

```-p``` Gibt den Pfad zum Modul an.

```-m``` Gibt den Modulnamen und den Klassennamen an.



-   Um ein Java-Laufzeitpaket zu generieren,
    können Sie den folgenden Befehl verwenden:


```js
>> powershell

    jpackage --sign

```
.

-   ```--signGibt``` an, wie das Paket signiert werden soll.
    Sie können das Installationsprogramm auch anpassen,
    indem Sie folgende Optionen angeben:

```js
>> powershell

--win-console
--app-version
--copyright
--argument
--java-options
--icon

```
.

```--win-console   ```Gibt an, dass die Konsole beim Start
                      der Anwendung geöffnet werden soll.

```--app-version   ```gibt die Version der Anwendung an.

```--copyright     ```gibt das Urheberrecht für die Anwendung an.

```--argument      ```Gibt die Argumente an,
                      die beim Start an die Anwendung übergeben werden sollen.

```--java-options  ```Gibt die Java-Optionen an,
                      die beim Start der Anwendung verwendet werden sollen.

```--icon          ```Gibt das Symbol an, das für die Anwendung verwendet werden soll.
