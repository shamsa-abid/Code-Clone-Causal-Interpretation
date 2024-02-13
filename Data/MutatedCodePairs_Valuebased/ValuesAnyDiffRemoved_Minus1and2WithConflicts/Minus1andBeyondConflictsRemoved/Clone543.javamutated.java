public class Clone543 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15045640
*  Stack Overflow answer #:21553499
*  And Stack Overflow answer#:37772633
*/
public boolean isAnagram (String leftString, String rightString) {
{
} else if (leftString.length () != rightString.length ()) {
return false;
}
for (char l : letters) {
occurrencesMap.put (l, 0);
}
for (int i = 0;
i < leftString.length (); i ++) {
char charFromLeft = leftString.charAt (i);
Integer nrOfCharsInLeft = occurrencesMap.get (charFromLeft);
occurrencesMap.put (charFromLeft, ++ nrOfCharsInLeft);
char charFromRight = rightString.charAt (i);
Integer nrOfCharsInRight = occurrencesMap.get (charFromRight);
occurrencesMap.put (charFromRight, -- nrOfCharsInRight);
}
for (Integer occurrencesNr : occurrencesMap.values ()) {
if (occurrencesNr != 0) {
return false;
}
}
return true;
}

private static boolean isAnagram (String s1, String s2) {
if (s1.length () != s2.length ()) return false;
for (int i = 0;
i < s1.length (); i ++) {
seen [s1.charAt (i)] = seen [s1.charAt (i)] + 1;
}
for (int i = 0;
i < s2.length (); i ++) {
if (seen [s2.charAt (i)] == 0) return false;
seen [s2.charAt (i)] = seen [s2.charAt (i)] - 1;
}
for (int i = 0;
i < 256; i ++) {
if (seen [i] != 0) return false;
}
return true;
}

}