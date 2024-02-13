public class Clone368 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16963405
*  Stack Overflow answer #:27650365
*  And Stack Overflow answer#:16964055
*/
public static void main (String [] args) throws InterruptedException {
(
){
{
{
}}
Runnable worldTask = new Runnable () {
@Override
public void run () {
new ThreadSeq ().printWorld ();
}}
;
Thread t2 = new Thread (worldTask);
t1.join ();
t2.start ();
t2.join ();
}
}

public static void main (String [] args) {
int sayThisManyTimes = 5;
AtomicBoolean saidHello = new AtomicBoolean (false);
(
){
while (saidHello.get ()) {
}
saidHello.set (true);
}
}

}