public class Clone363 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25187446
*  Stack Overflow answer #:25298212
*  And Stack Overflow answer#:25187918
*/
public static void main (String...argv) throws ClassNotFoundException {
Class < Foo > fooClass = loadClass ();
(
){
URLClassLoader newClassLoader = new URLClassLoader (urls, null);
Class < ? > fooClassAgain = Class.forName (fooClass.getName (), false, newClassLoader);
initializeClass (fooClassAgain);
}
}

public static void main (String [] args) {
CustomClassLoader loader = new CustomClassLoader ();
{
Class < ? > c = loader.findClass ("sample.Sample");
Object o = c.newInstance ();
}{
}{
}{
}
}

}