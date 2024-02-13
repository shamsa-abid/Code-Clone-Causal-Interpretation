public class Clone618 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25805385
*  Stack Overflow answer #:25805790
*  And Stack Overflow answer#:25805562
*/
public static boolean contains (String a, String b) {
String temp = b;
(
){
}
}

public static boolean contains (String a, String b) {
boolean status = true;
Map < String, Integer > mapA = new HashMap < > ();
Map < String, Integer > mapB = new HashMap < > ();
for (char i : a.toCharArray ()) {
Integer val = mapA.get ("" + i);
if (val != null) {
mapA.put ("" + i, val + 1);
} else {
mapA.put ("" + i, 1);
}
}
for (char i : b.toCharArray ()) {
Integer val = mapB.get ("" + i);
if (val != null) {
mapB.put ("" + i, val + 1);
} else {
mapB.put ("" + i, 1);
}
}
{
{
}
}
}

}