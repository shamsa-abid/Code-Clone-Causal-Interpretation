public class Clone455 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25922372
*  Stack Overflow answer #:25925208
*  And Stack Overflow answer#:25922612
*/
public static void main (String [] args) throws InterruptedException {
final AtomicInteger outputCount = new AtomicInteger (0);
ExecutorService threadPool = Executors.newFixedThreadPool (THREADS);
Collection < Callable < Object > > tasks = new ArrayList < > (THREADS);
for (int i = 0;
i < THREADS; i ++) {
{(
{
}
{
(
){
{
{
}
}
}
}}
)
}
threadPool.shutdownNow ();
System.out.println ("done");
}

public static void main (String [] args) throws InterruptedException {
AtomicInteger counter = new AtomicInteger ();
ExecutorService pool = Executors.newFixedThreadPool (4);
for (int i = 0;
i < 4; ++ i) {
}
pool.shutdown ();
pool.awaitTermination (1, TimeUnit.HOURS);
}

}