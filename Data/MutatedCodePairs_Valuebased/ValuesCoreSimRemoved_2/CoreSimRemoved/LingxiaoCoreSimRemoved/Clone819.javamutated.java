public class Clone819 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:52350940
*  Stack Overflow answer #:52351119
*  And Stack Overflow answer#:52351254
*/
public static void countString (String str, char value) {
String [] arr = str.split ("");
StringBuffer tempString = new StringBuffer ();
for (String s : arr) {
tempString.append (s);
for (char ch : s.toCharArray ()) {
System.out.println ("Number of Occurrence of " + ch + " is:" + tempString.chars ().filter (i -> i == ch).count ());
}
}
{
{
{
{
}
}
}
}
}

public static void countString (String str, char searchKey) {
String count = "";
(
){
}
}

}