public class Clone840 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1978933
*  Stack Overflow answer #:22714883
*  And Stack Overflow answer#:13878279
*/
public static String join (String [] strings, int startIndex, String separator) {
for (int i = startIndex;
i < strings.length; i ++) {
if (i != startIndex) sb.append (separator);
sb.append (strings [i]);
}
return sb.toString ();
}

public static String join (String separator, String...values) {
(
){
}
for (int i = 0, end = values.length - 1;
i < end; i ++) {
System.arraycopy (values [i].toCharArray (), 0, joined, pos, values [i].length ());
pos += values [i].length ();
System.arraycopy (sep, 0, joined, pos, sep.length);
pos += sep.length;
}
System.arraycopy (values [values.length - 1].toCharArray (), 0, joined, pos, values [values.length - 1].length ());
return new String (joined);
}

}