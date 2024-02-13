public class Clone687 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:44964937
*  Stack Overflow answer #:44965307
*  And Stack Overflow answer#:44965676
*/
synchronized public void print () throws InterruptedException {
while (count < 15) {
(
){
}
notifyAll ();
wait ();
}
}

public void print () {
try {
waitForSemaphore.acquire ();
int start = nextStartIdx;
(
){
}
nextStartIdx += 5;
next.release ();
} catch (InterruptedException ie) {
Thread.currentThread ().interrupt ();
}
}

}