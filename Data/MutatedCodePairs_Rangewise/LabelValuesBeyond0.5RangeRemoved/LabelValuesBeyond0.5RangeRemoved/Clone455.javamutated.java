public class Clone455 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25922372
*  Stack Overflow answer #:25925208
*  And Stack Overflow answer#:25922612
*/
public static void main (String [] args) throws InterruptedException {
Collection < Callable < Object > > tasks = new ArrayList < > (THREADS);
for (int i = 0;
i < THREADS; i ++) {
tasks.add (new Callable < Object > () {
private SecureRandom rand = new SecureRandom ();
private String task () {
return rand.nextDouble () > 0.5 ? Thread.currentThread ().getName () : null;
}@Override
public Object call () {
for (int i;
(i = outputCount.get ()) < TASKS;) {
String output = task ();
if (output != null) {
if ((i = outputCount.incrementAndGet ()) < TASKS) {
System.out.println (output + ": " + i);
}
}
}
return null;
}}
);
}
threadPool.invokeAll (tasks);
System.out.println ("done");
}

public static void main (String [] args) throws InterruptedException {
for (int i = 0;
i < 4; ++ i) {
pool.execute (new MyTask (counter));
}
pool.awaitTermination (1, TimeUnit.HOURS);
}

}