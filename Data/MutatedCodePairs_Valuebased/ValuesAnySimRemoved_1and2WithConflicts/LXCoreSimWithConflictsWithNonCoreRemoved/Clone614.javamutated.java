public class Clone614 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3391794
*  Stack Overflow answer #:3444682
*  And Stack Overflow answer#:3444682
*/
public void run () {
final int [] orgSize = new int [1];
final int [] currentSize = new int [1];
final Object lock = new Object ();
{
}
display.syncExec (new Runnable () {
public void run () {
{
}
{
}
}}
);
while (currentSize [0] == orgSize [0]) {
{
}
display.syncExec (new Runnable () {
public void run () {
synchronized (lock) {
{
}
{
}{
}
}
}}
);
}
}

public void run () {
{
}
{
}
}

}