public class Clone363 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25187446
*  Stack Overflow answer #:25298212
*  And Stack Overflow answer#:25187918
*/
public static void main (String...argv) throws ClassNotFoundException {
initializeClass (fooClass);
URLClassLoader myClassLoader = ((URLClassLoader) InitializeClassMultipleTimes.class.getClassLoader ());
URL [] urls = myClassLoader.getURLs ();
for (int i = 0;
i < 2; i ++) {
System.out.format ("%nLoading class using another class loader%n", Foo.class.getSimpleName ());
}
}

public static void main (String [] args) {
try {
} catch (ClassNotFoundException e) {
e.printStackTrace ();
} catch (InstantiationException e) {
e.printStackTrace ();
} catch (IllegalAccessException e) {
e.printStackTrace ();
}
}

}