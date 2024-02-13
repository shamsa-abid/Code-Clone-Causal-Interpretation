public class Clone481 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:32447043
*  Stack Overflow answer #:32448101
*  And Stack Overflow answer#:32450479
*/
protected void paintComponent (Graphics g) {
double xScale = ((double) getWidth () - (2 * padding) - labelPadding) / (scores.size () - 1);
double yScale = ((double) getHeight () - 2 * padding - labelPadding) / (getMaxScore () - getMinScore ());
List < Point > graphPoints = new ArrayList < > ();
for (int i = 0;
i < scores.size (); i ++) {
int x1 = (int) (i * xScale + padding + labelPadding);
int y1 = (int) ((getMaxScore () - scores.get (i)) * yScale + padding);
graphPoints.add (new Point (x1, y1));
}
g2.setColor (Color.WHITE);
g2.fillRect (padding + labelPadding, padding, getWidth () - (2 * padding) - labelPadding, getHeight () - 2 * padding - labelPadding);
g2.setColor (Color.BLACK);
for (int i = 0;
i < numberYDivisions + 1; i ++) {
int x0 = padding + labelPadding;
int x1 = pointWidth + padding + labelPadding;
int y0 = getHeight () - ((i * (getHeight () - padding * 2 - labelPadding)) / numberYDivisions + padding + labelPadding);
int y1 = y0;
if (scores.size () > 0) {
g2.setColor (gridColor);
g2.drawLine (padding + labelPadding + 1 + pointWidth, y0, getWidth () - padding, y1);
g2.setColor (Color.BLACK);
String yLabel = ((int) ((getMinScore () + (getMaxScore () - getMinScore ()) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
int labelWidth = metrics.stringWidth (yLabel);
}
g2.drawLine (x0, y0, x1, y1);
}
for (int i = 0;
i < scores.size (); i ++) {
if (scores.size () > 1) {
int x0 = i * (getWidth () - padding * 2 - labelPadding) / (scores.size () - 1) + padding + labelPadding;
int x1 = x0;
int y0 = getHeight () - padding - labelPadding;
int y1 = y0 - pointWidth;
if ((i % ((int) ((scores.size () / 20.0)) + 1)) == 0) {
g2.setColor (gridColor);
g2.drawLine (x0, getHeight () - padding - labelPadding - 1 - pointWidth, x1, padding);
g2.setColor (Color.BLACK);
String xLabel = i + "";
int labelWidth = metrics.stringWidth (xLabel);
}
g2.drawLine (x0, y0, x1, y1);
}
}
g2.drawLine (padding + labelPadding, getHeight () - padding - labelPadding, padding + labelPadding, padding);
g2.drawLine (padding + labelPadding, getHeight () - padding - labelPadding, getWidth () - padding, getHeight () - padding - labelPadding);
Stroke oldStroke = g2.getStroke ();
g2.setColor (lineColor);
g2.setStroke (GRAPH_STROKE);
for (int i = 0;
i < graphPoints.size () - 1; i ++) {
int x1 = graphPoints.get (i).x;
int y1 = graphPoints.get (i).y;
int x2 = graphPoints.get (i + 1).x;
int y2 = graphPoints.get (i + 1).y;
g2.drawLine (x1, y1, x2, y2);
}
g2.setStroke (oldStroke);
g2.setColor (pointColor);
for (int i = 0;
i < graphPoints.size (); i ++) {
int x = graphPoints.get (i).x - pointWidth / 2;
int y = graphPoints.get (i).y - pointWidth / 2;
int ovalW = pointWidth;
int ovalH = pointWidth;
g2.fillOval (x, y, ovalW, ovalH);
}
}

public void paintComponent (Graphics g) {
Font font = new Font ("Arial", Font.PLAIN, 15);
String string = "Distance (m)";
int width = metrics.stringWidth (string);
int height = metrics.getHeight ();
gg.setFont (font);
}

}