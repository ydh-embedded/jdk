@echo off
powershell .\build.ps1
cd .\out\
jar -c -f MyApp.jar -v --main-class MainApp .
java -jar .\MyApp.jar

pause