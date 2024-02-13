public class Clone482 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:32447043
*  Stack Overflow answer #:32448101
*  And Stack Overflow answer#:32450479
*/
public void paintComponent (Graphics g) {
super.paintComponent (g);
Graphics2D gg = (Graphics2D) g;
gg.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
Font font = new Font ("Arial", Font.PLAIN, 15);
String string = "Time (s)";
FontMetrics metrics = g.getFontMetrics (font);
int width = metrics.stringWidth (string);
int height = metrics.getHeight ();
gg.setFont (font);
}

protected void paintComponent (Graphics g) {
super.paintComponent (g);
Graphics2D g2 = (Graphics2D) g;
g2.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
(
){
}
(
){
{
FontMetrics metrics = g2.getFontMetrics ();
int labelWidth = metrics.stringWidth (yLabel);
}
}
(
){
{
{
FontMetrics metrics = g2.getFontMetrics ();
int labelWidth = metrics.stringWidth (xLabel);
}
}
}
(
){
}
(
){
}
}

}