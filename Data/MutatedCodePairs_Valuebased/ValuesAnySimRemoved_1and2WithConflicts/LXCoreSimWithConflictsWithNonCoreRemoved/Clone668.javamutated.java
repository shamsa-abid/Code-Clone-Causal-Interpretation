public class Clone668 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11544843
*  Stack Overflow answer #:14466771
*  And Stack Overflow answer#:31668619
*/
public void run () {
System.out.println (i);
{
cb.await ();
Thread.sleep (1000);
}{
 catch (BrokenBarrierException e) {
e.printStackTrace ();
}
}

public void run () {
int i = 1;
while (i < 50) {
while (s.getState () != 3) {
synchronized (s) {
{
s.wait ();
}{
}
}
}
synchronized (s) {
if (s.getState () == 3) System.out.println ("t1 " + i);
s.setState (1);
s.notifyAll ();
}
}
}

}