public class Clone664 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11544843
*  Stack Overflow answer #:14466771
*  And Stack Overflow answer#:31668619
*/
public void run () {
int i = 1;
while (true) {
System.out.println (i);
{
Thread.sleep (1000);
cb.await ();
}{
 catch (BrokenBarrierException e) {
e.printStackTrace ();
}
}
}

public synchronized void run () {
int i = 3;
while (i < 50) {
while (s.getState () != 2) {
synchronized (s) {
{
s.wait ();
}{
}
}
}
synchronized (s) {
if (s.getState () == 2) System.out.println ("t3 " + i);
s.setState (3);
s.notifyAll ();
}
}
}

}