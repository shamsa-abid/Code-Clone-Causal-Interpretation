public class Clone364 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19538999
*  Stack Overflow answer #:19541306
*  And Stack Overflow answer#:19539055
*/
public static int TestTryFinallyBlock () {
{
int i = 0;
} catch (RuntimeException e) {
i = 40;
throw e;
}
}

public static int TestTryFinallyBlock () {
int i = 0;
{
 finally {
i = 40;
System.out.println ("local: " + i);
}
}

}