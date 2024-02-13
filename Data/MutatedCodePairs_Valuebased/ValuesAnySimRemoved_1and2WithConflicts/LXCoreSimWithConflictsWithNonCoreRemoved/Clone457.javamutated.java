public class Clone457 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25922372
*  Stack Overflow answer #:25928966
*  And Stack Overflow answer#:25922612
*/
public static void main (String [] args) throws InterruptedException {
CountDownLatch theLatch = new CountDownLatch (100);
List < String > output = Collections.synchronizedList (new ArrayList < String > ());
SecureRandom random = new SecureRandom ();
{
}
theLatch.await (1, TimeUnit.MINUTES);
System.out.println (output.size ());
}

public static void main (String [] args) throws InterruptedException {
AtomicInteger counter = new AtomicInteger ();
{
}
pool.awaitTermination (1, TimeUnit.HOURS);
}

}