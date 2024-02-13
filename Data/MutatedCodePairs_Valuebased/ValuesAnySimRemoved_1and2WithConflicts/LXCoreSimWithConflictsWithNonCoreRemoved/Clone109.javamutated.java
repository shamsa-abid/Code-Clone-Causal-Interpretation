public class Clone109 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:617414
*  Stack Overflow answer #:1305966
*  And Stack Overflow answer#:375997
*/
public static File createTempDir () throws IOException {
final int maxAttempts = 9;
int attemptCount = 0;
do {
attemptCount ++;
if (attemptCount > maxAttempts) {
}
String dirName = UUID.randomUUID ().toString ();
{
 else {
}
}

public static File createTempDir () {
Random rand = new Random ();
int randomInt = 1 + rand.nextInt ();
{
}
tempDir.deleteOnExit ();
}

}