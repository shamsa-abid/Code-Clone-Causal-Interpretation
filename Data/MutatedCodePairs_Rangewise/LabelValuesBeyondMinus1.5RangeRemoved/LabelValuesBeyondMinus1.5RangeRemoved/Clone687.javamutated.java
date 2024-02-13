public class Clone687 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:44964937
*  Stack Overflow answer #:44965307
*  And Stack Overflow answer#:44965676
*/
synchronized public void print () throws InterruptedException {
{
for (int i = 0;
i < 5; i ++) {
count ++;
System.out.println (count + " -- " + Thread.currentThread ());
}
}
}

public void print () {
{
for (int i = 0;
i < 5; i ++) {
System.out.println (String.format ("%d -- %s", i + start, Thread.currentThread ().getName ()));
}
}{
}
}

}