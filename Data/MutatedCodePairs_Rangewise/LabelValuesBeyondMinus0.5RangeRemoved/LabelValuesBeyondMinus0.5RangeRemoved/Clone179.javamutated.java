public class Clone179 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6309407
*  Stack Overflow answer #:6310273
*  And Stack Overflow answer#:6375412
*/
public void actionPerformed (ActionEvent e) {
for (Window window : Window.getWindows ()) {
if (window instanceof JDialog) {
JDialog dialog = (JDialog) window;
System.out.println ("\tClosing " + dialog.getTitle ());
dialog.dispose ();
}
}
Runtime.getRuntime ().gc ();
}

public void actionPerformed (ActionEvent e) {
{
for (Window win : Window.getWindows ()) {
if (win instanceof JDialog) {
System.out.println ("    Trying to Remove JDialog");
win.dispose ();
}
}
)
{
{
{
}{
}
Runtime.getRuntime ().gc ();
}}
}{
}
}

}