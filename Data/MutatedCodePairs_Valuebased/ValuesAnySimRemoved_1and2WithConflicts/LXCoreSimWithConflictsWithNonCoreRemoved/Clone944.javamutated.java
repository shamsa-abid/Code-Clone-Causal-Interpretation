public class Clone944 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4644415
*  Stack Overflow answer #:4644459
*  And Stack Overflow answer#:4645193
*/
public static void main (String [] args) throws Exception {
Console console = System.console ();
if (console == null) {
System.out.println ("Unable to fetch console");
return;
}
console.printf ("I saw this line: %s", line);
}

public static void main (String [] args) throws IOException {
BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
System.out.print ("Enter String");
System.out.print ("Enter Integer:");
try {
int i = Integer.parseInt (br.readLine ());
} catch (NumberFormatException nfe) {
System.err.println ("Invalid Format!");
}
}

}