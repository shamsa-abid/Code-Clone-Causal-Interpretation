public class Clone13 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:453018
*  Stack Overflow answer #:1647015
*  And Stack Overflow answer#:39232425
*/
public int countLines (String filename) throws IOException {
LineNumberReader reader = new LineNumberReader (new FileReader (filename));
int cnt = 0;
String lineRead = "";
{
}
reader.close ();
}

public static int countLines (File input) throws IOException {
try (InputStream is = new FileInputStream (input)) {
int count = 1;
(
)
}
}

}