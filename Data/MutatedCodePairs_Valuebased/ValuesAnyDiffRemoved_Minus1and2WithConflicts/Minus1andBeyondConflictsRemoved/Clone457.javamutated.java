public class Clone457 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25922372
*  Stack Overflow answer #:25928966
*  And Stack Overflow answer#:25922612
*/
public static void main (String [] args) throws InterruptedException {
ExecutorService service = Executors.newCachedThreadPool ();
for (int i = 0; i < 4; i ++) {
service.execute (new CountDownTask (theLatch, output, random));
}
service.shutdown ();

public static void main (String [] args) throws InterruptedException {
ExecutorService pool = Executors.newFixedThreadPool (4);
for (int i = 0; i < 4; ++ i) {
pool.execute (new MyTask (counter));
}
pool.shutdown ();
}

}