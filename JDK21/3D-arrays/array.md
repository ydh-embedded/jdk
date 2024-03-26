# 3D array

 5 , 14 , 11 , 10
 2 , 22 , 19 , 15
 0 ,  3 ,  5

Ein dreidimensionales Array in Java ist ein Array von Arrays von Arrays.
Es kann als Container für mehrere zweidimensionale Arrays betrachtet werden.
Die allgemeine Syntax zum Deklarieren eines dreidimensionalen Arrays lautet:

```java
data_type[][][] array_name = new data_type[array_length_1][][][];
```



Hier, array_length_1 ist die Anzahl der zweidimensionalen Arrays,
die im dreidimensionalen Array gespeichert werden können
 und data_type ist der Datentyp, der im Array gespeichert wird.

Hier ist ein Beispiel für die Initialisierung und den Druck der Werte eines dreidimensionalen Arrays:

 ```java
 public class Main {
    public static void main(String[] args) {
        //initialize 3-d array
        int[][][] intArray = {
            {{10, 20, 30},{20, 40, 60}}, 
            { {10, 30,50,70},{50},{80, 90}} 
        };
        System.out.println("Multidimensional Array (3-d) is as follows:");
        // use for..each loop to iterate through elements of 3d array
        for (int[][] array_2D: intArray) {
            for (int[] array_1D: array_2D) {
                for(int elem: array_1D) {
                    System.out.print(elem + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
 ```