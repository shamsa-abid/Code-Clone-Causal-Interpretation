public class Clone479 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:32447043
*  Stack Overflow answer #:32448101
*  And Stack Overflow answer#:32450479
*/
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
g2.drawString (yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight () / 2) - 3);
}
}
(
){
{
{
FontMetrics metrics = g2.getFontMetrics ();
int labelWidth = metrics.stringWidth (xLabel);
g2.drawString (xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight () + 3);
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

public void paintComponent (Graphics g) {
super.paintComponent (g);
Graphics2D gg = (Graphics2D) g;
gg.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
Font font = new Font ("Arial", Font.PLAIN, 15);
String string = "Distance (m)";
FontMetrics metrics = g.getFontMetrics (font);
int width = metrics.stringWidth (string);
int height = metrics.getHeight ();
gg.setFont (font);
gg.drawString (string, (getWidth () - width) / 2, 11);
}

}