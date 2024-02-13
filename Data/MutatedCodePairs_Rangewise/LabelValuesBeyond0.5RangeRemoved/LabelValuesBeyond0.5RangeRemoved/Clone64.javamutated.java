public class Clone64 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6887296
*  Stack Overflow answer #:6887332
*  And Stack Overflow answer#:6887354
*/
public void actionPerformed (ActionEvent e) {
Container parent = getParent ();
int nextX = getLocation ().x + (deltaX * directionX);
{
}
if (nextX + getSize ().width > parent.getSize ().width) {
nextX = parent.getSize ().width - getSize ().width;
}
int nextY = getLocation ().y + (deltaY * directionY);
{
}
if (nextY + getSize ().height > parent.getSize ().height) {
nextY = parent.getSize ().height - getSize ().height;
}
setLocation (nextX, nextY);
}

public void actionPerformed (ActionEvent e) {
{
}
}

}