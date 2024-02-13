public class Clone154 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25130557
*  Stack Overflow answer #:25131007
*  And Stack Overflow answer#:25131379
*/
public static void throwException (final String key) throws Throwable {
{
try {
Class < Throwable > exceptionClass = (Class < Throwable >) Class.forName (exceptionMapping.getClassName ());
{
throw exceptionClass.cast (exceptionClass.newInstance ());
}{
}{
}
} catch (ClassNotFoundException e) {
e.printStackTrace ();
}
}
}

static void throwException (final String exClassName) throws CheckedException, UncheckedException {
try {
clazz = Class.forName (exClassName);
} catch (ClassNotFoundException cnfe) {
throw new InternalError (exClassName, cnfe);
}
{
throw newException (clazz.asSubclass (CheckedException.class));
}{
throw newException (clazz.asSubclass (UncheckedException.class));
}{
}
}

}