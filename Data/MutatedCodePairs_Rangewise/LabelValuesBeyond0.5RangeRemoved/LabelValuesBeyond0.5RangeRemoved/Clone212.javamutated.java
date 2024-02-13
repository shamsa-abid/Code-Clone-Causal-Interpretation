public class Clone212 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1102891
*  Stack Overflow answer #:13955940
*  And Stack Overflow answer#:43306526
*/
public static boolean isNumber (String s) {
(
){
}
}

public static boolean isNumber (String str) {
int i = 0, len = str.length ();
if (i < len && (str.charAt (i) == '+' || str.charAt (i) == '-')) i ++;
{
}
{
}
{
}
if (i < len && (str.charAt (i) == '+' || str.charAt (i) == '-') && c) i ++;
while (i < len && isDigit (str.charAt (i))) {
i ++;
d = true;
}
}

}