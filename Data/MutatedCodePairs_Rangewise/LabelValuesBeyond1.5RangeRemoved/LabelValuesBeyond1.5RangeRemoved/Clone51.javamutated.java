public class Clone51 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17533028
*  Stack Overflow answer #:17533186
*  And Stack Overflow answer#:17533330
*/
public static void main (String [] args) {
Scanner scan = new Scanner (System.in);
while (scan.hasNext ()) {
String line = scan.next ();
if (line.equals ("x=")) exes += scan.nextInt ();
else whys += scan.nextInt ();
}
}

public static void main (String [] args) throws IOException {
FileReader file = new FileReader ("D:\\Test.txt");
BufferedReader br = new BufferedReader (file);
String str;
while ((str = br.readLine ()) != null) {
if (str.contains ("x=")) {
xSum += Integer.parseInt (str.split ("=") [1].trim ());
}
if (str.contains ("y=")) {
ySum += Integer.parseInt (str.split ("=") [1].trim ());
}
}
}

}