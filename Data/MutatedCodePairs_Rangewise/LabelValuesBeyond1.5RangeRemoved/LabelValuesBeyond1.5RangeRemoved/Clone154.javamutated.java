public class Clone154 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25130557
*  Stack Overflow answer #:25131007
*  And Stack Overflow answer#:25131379
*/
public static void throwException (final String key) throws Throwable {
ExceptionMapping exceptionMapping = exceptionMappings.getExceptionMappings ().get (key);
if (exceptionMapping != null) {
{
try {
throw exceptionClass.cast (exceptionClass.newInstance ());
} catch (InstantiationException e) {
e.printStackTrace ();
} catch (IllegalAccessException e) {
e.printStackTrace ();
}
}{
e.printStackTrace ();
}
}
}

static void throwException (final String exClassName) throws CheckedException, UncheckedException {
Class < ? > clazz;
{
}{
throw new InternalError (exClassName, cnfe);
}
if (CheckedException.class.isAssignableFrom (clazz)) {
throw newException (clazz.asSubclass (CheckedException.class));
} else if (UncheckedException.class.isAssignableFrom (clazz)) {
throw newException (clazz.asSubclass (UncheckedException.class));
} else {
throw new InternalError (exClassName + " is not a valid exception");
}
}

}