# Pfad zum Java-Installationsverzeichnis anpassen.
# $installationLocation =  "${home}\desktop\jdk-21.0.2"
$installationLocation =  "C:\working-directory\jdk\JDK21\jdk-21.0.2"
$binaryLocation = Join-Path -Path $installationLocation -ChildPath bin

# Temporäre Umgebungsvariablen erstellen.
$env:JAVA_HOME = $installationLocation
$env:PATH = "$binaryLocation;$($env:PATH)"

Write-Host -ForegroundColor Cyan "Installierte Java-Version:"
Write-Host Path: (Get-Command java).Source
java --version
Write-Host ""
