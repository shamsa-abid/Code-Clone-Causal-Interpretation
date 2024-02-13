public class Clone87 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1248510
*  Stack Overflow answer #:19393755
*  And Stack Overflow answer#:11779211
*/
public void type (char c) {
String altCode = Integer.toString (c);
for (int i = 0;
i < altCode.length (); i ++) {
c = (char) (altCode.charAt (i) + '0');
}
}

public static void type (String characters) {
Clipboard clipboard = Toolkit.getDefaultToolkit ().getSystemClipboard ();
StringSelection stringSelection = new StringSelection (characters);
clipboard.setContents (stringSelection, clipboardOwner);
}

}