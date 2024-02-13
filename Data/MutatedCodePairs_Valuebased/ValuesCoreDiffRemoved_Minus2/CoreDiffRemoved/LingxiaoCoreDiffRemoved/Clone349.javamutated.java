public class Clone349 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:32433864
*  Stack Overflow answer #:32441194
*  And Stack Overflow answer#:32441194
*/
public void actionPerformed (ActionEvent e) {
try {
OutputStream os = new BufferedOutputStream (new FileOutputStream (file));
XMLEncoder xe = new XMLEncoder (os);
Reader r = new BufferedReader (new InputStreamReader (new FileInputStream (file), "UTF-8"));
} catch (IOException ex) {
ex.printStackTrace ();
}
}

public void actionPerformed (ActionEvent e) {
try {
InputStream is = new BufferedInputStream (new FileInputStream (file));
XMLDecoder xd = new XMLDecoder (is);
} catch (IOException ex) {
ex.printStackTrace ();
}
}

}