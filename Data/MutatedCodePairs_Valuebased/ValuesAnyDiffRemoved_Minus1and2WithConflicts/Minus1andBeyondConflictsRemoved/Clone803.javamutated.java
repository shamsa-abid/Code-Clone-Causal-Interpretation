public class Clone803 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3316674
*  Stack Overflow answer #:3316696
*  And Stack Overflow answer#:3316743
*/
public void shuffle (String input) {
{
}
while (characters.size () != 0) {
int randPicker = (int) (Math.random () * characters.size ());
output.append (characters.remove (randPicker));
}
System.out.println (output.toString ());
}

static String shuffle (String text) {
String temp1 = shuffle (text.substring (0, split));
String temp2 = shuffle (text.substring (split));
if (Math.random () > 0.5) return temp1 + temp2;
else return temp2 + temp1;
}

}