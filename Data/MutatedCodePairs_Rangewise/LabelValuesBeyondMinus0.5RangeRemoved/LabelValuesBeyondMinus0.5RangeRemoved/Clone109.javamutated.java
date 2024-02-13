public class Clone109 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:617414
*  Stack Overflow answer #:1305966
*  And Stack Overflow answer#:375997
*/
public static File createTempDir () throws IOException {
final File sysTempDir = new File (System.getProperty ("java.io.tmpdir"));
File newTempDir;
{
{
throw new IOException ("The highly improbable has occurred! Failed to " + "create a unique temporary directory after " + maxAttempts + " attempts.");
}
newTempDir = new File (sysTempDir, dirName);
if (newTempDir.mkdirs ()) {
return newTempDir;
} else {
throw new IOException ("Failed to create temp dir named " + newTempDir.getAbsolutePath ());
}
}

public static File createTempDir () {
final String baseTempPath = System.getProperty ("java.io.tmpdir");
File tempDir = new File (baseTempPath + File.separator + "tempDir" + randomInt);
if (tempDir.exists () == false) {
tempDir.mkdir ();
}
return tempDir;
}

}