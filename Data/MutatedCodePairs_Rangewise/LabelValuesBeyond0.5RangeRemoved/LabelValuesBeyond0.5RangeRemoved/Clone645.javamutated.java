public class Clone645 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:32672371
*  Stack Overflow answer #:32672679
*  And Stack Overflow answer#:32672701
*/
public static void main (final String...args) {
if (args.length == 0) throw new IllegalArgumentException ("missing pattern as an argument");
final Pattern pattern = Pattern.compile (args [0]);
final Charset cs = Charset.defaultCharset ();
final CharsetDecoder decoder = cs.newDecoder ().onMalformedInput (CodingErrorAction.REPORT);
{
}
}

public static void main (String [] args) throws FileNotFoundException {
String s = "this is line one\n" + "this is line two\n" + "This is line three";
Pattern p = Pattern.compile ("this");
Scanner scanner = new Scanner (s);
{
{
}
}
}

}