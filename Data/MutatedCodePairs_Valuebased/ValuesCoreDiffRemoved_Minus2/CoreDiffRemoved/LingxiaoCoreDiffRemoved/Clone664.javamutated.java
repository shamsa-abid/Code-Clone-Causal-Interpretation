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
{
try {
} catch (InterruptedException e) {
e.printStackTrace ();
}
i = i + 3;
}
}

public synchronized void run () {
int i = 3;
{
{
{
try {
} catch (InterruptedException e) {
e.printStackTrace ();
}
}
}
{
i = i + 3;
}
}
}

}