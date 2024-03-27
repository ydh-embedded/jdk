$outputDirectory = "out" ;
# wenn die output date existiert wird diese gelöscht
if (Test-Path $outputDirectory){
    
    Remove-Item-Recurse $outputDirectory ;
}
                                                             #NOTE Verzeichnisslisten werden in Linux mit einem : Doppelpunkt getrennt
$javaClassPath= ".;$outputDirectory;C:\dev\my-library.jar"  #NOTE Verzeichnisslisten wird mit dem SemiKolon getrennt

javac -d $outputDirectory --class-path $javaClassPath MainApp.java ;        #NOTE Wir kompilieren das PRG und legen es ins Output-Verzeichniss

if ($? -eq $true ) {
    java --class-path $javaClassPath MainApp ;
}