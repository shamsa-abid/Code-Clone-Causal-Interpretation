public class Clone109 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:617414
*  Stack Overflow answer #:1305966
*  And Stack Overflow answer#:375997
*/
public static File createTempDir () throws IOException {
File newTempDir;
final int maxAttempts = 9;
int attemptCount = 0;
do {
attemptCount ++;
if (attemptCount > maxAttempts) {
throw new IOException ("The highly improbable has occurred! Failed to " + "create a unique temporary directory after " + maxAttempts + " attempts.");
}
String dirName = UUID.randomUUID ().toString ();
} while (newTempDir.exists ());
{
} else {
throw new IOException ("Failed to create temp dir named " + newTempDir.getAbsolutePath ());
}
}

public static File createTempDir () {
Random rand = new Random ();
int randomInt = 1 + rand.nextInt ();
{
}
tempDir.deleteOnExit ();
return tempDir;
}

}