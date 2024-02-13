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
while ((lineRead = reader.readLine ()) != null) {
}
cnt = reader.getLineNumber ();
return cnt;
}

public static int countLines (File input) throws IOException {
int count = 1;
for (int aChar = 0;
aChar != - 1; aChar = is.read ()) count += aChar == '\n' ? 1 : 0;
return count;
}
}

}