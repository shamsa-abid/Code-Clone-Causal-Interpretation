public class Clone179 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6309407
*  Stack Overflow answer #:6310273
*  And Stack Overflow answer#:6375412
*/
public void actionPerformed (ActionEvent e) {
System.out.println ();
System.out.println ("Close Dialogs");
{
{
}
}
Runtime.getRuntime ().gc ();
}

public void actionPerformed (ActionEvent e) {
if (runProcess) {
{
{
}
}
System.out.println ("    Remove Cycle Done :-)");
runProcess = false;
new Thread () {
@Override
public void run () {
try {
Thread.sleep (100);
} catch (InterruptedException e) {
e.printStackTrace ();
}
Runtime.getRuntime ().gc ();
}}
.start ();
} else {
pastRemWins ();
runProcess = true;
}
}

}