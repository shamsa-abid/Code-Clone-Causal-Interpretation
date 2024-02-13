public class Clone545 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15045640
*  Stack Overflow answer #:21553499
*  And Stack Overflow answer#:21447112
*/
public boolean isAnagram (String leftString, String rightString) {
if (leftString == null || rightString == null) {
return false;
}
char letters [] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
Map < Character, Integer > occurrencesMap = new HashMap < > ();
{
}
(
){
}
{
{
}
}
}

public static boolean isAnagram (String first, String second) {
String positive = first.toLowerCase ();
String negative = second.toLowerCase ();
{
}
int [] counts = new int [26];
int diff = 0;
(
){
{
}{
}
{
}{
}
}
}

}