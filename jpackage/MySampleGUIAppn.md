## jpackage


Sources: 
-  [launch4j](launch4j.sourceforge.net) (1) launch4j.sourceforge.net (2) levelup.gitconnected.com (3) javatidbits.wordpress.com (4)

Yes, you can use the jpackage tool, which is included in the Java Development Kit (JDK) starting from JDK 14, as a modern alternative to Launch4j for creating an executable Java file.

Here is an example of how to create an executable JAR file using the jar command:

First, create a manifest file called MySampleGUIAppn.mf with the following content:

```ps
Main-Class: MySampleGUIAppn
```

-   Make sure to add a newline at the end of the manifest file for it to work correctly.

-   Next, create the executable JAR file using the following command:

```java
jar cmf MySampleGUIAppn.mf MySampleGUIAppn.jar MySampleGUIAppn.class MySampleGUIAppn.java
```