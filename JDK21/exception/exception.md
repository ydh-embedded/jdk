# exception

Wenn in Java eine Ausnahme auftritt, ist dies ein Hinweis darauf, dass während der Ausführung des Programms etwas schief gelaufen ist. Indem Sie Ausnahmen abfangen, können Sie diese anmutig handhaben und verhindern, dass Ihr Programm abstürzt.

Hier ist ein Beispiel dafür, wie Sie eine Ausnahme in Java abfangen können:

```powershell

```

```java

    try {
        // code that might throw an exception
        int result = 10 / 0; // dividing by zero will throw an ArithmeticException
    } catch (ArithmeticException e) {
        // code that will execute if an ArithmeticException is thrown
        System.out.println("An ArithmeticException occurred: " + e.getMessage());
    }

```
In diesem Beispiel versuchen wir zu teilen 10 durch 0, die einen werfen wird ArithmeticException. Wir verpacken den Code, der eine Ausnahme in eine try blockieren und dann die spezifische Ausnahme abrufen, an der wir interessiert sind (ArithmeticException) in a catch Block.

Wenn ein ArithmeticException wird geworfen, der Code in der catch Block wird ausgeführt und eine Fehlermeldung an die Konsole gedruckt. Wenn keine Ausnahme geworfen wird, wird die catch Block wird übersprungen.

Sie können auch mehrere Ausnahmen in einer einzigen erfassen catch Blockieren Sie, indem Sie sie in a auflisten catch Klausel mit vertikaler Stange (|) sie trennen:

```java

    try {
        // code that might throw an exception
    } catch (ArithmeticException | NullPointerException e) {
        // code that will execute if either an ArithmeticException or NullPointerException is thrown
    }
    
```