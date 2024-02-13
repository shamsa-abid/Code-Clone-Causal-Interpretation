public class Clone840 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1978933
*  Stack Overflow answer #:22714883
*  And Stack Overflow answer#:13878279
*/
public static String join (String [] strings, int startIndex, String separator) {
StringBuffer sb = new StringBuffer ();
(
){
}
}

public static String join (String separator, String...values) {
if (values.length == 0) return "";
char [] sep = separator.toCharArray ();
int totalSize = (values.length - 1) * sep.length;
for (int i = 0;
i < values.length; i ++) {
if (values [i] == null) values [i] = "";
else totalSize += values [i].length ();
}
char [] joined = new char [totalSize];
int pos = 0;
(
){
}
}

}