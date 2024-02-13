public class Clone699 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:31655284
*  Stack Overflow answer #:31655785
*  And Stack Overflow answer#:31655990
*/
public static void main (String [] args) throws IOException {
JFrame myFrame = new JFrame ("myJfTitle");
myFrame.setSize (300, 100);
JPanel myPanel = new JPanel ();
myBar.setPreferredSize (new Dimension (myFrame.getWidth (), myFrame.getHeight ()));
myFrame.addComponentListener (new ComponentAdapter () {
public void componentResized (ComponentEvent evt) {
Component c = (Component) evt.getSource ();
myBar.setPreferredSize (new Dimension (myFrame.getWidth (), myFrame.getHeight ()));
}}
);
JPanel glass = (JPanel) myFrame.getGlassPane ();
glass.setVisible (true);
glass.add (myButton, BorderLayout.CENTER);
myFrame.revalidate ();
myFrame.repaint ();
}

public static void main (String [] args) throws IOException {
JFrame myFrame = new JFrame ("myJfTitle");
myButton.setAlignmentX (Component.CENTER_ALIGNMENT);
LayoutManager overlay = new OverlayLayout (myBar);
myBar.setLayout (overlay);
myBar.add (myButton);
myFrame.pack ();
myFrame.setSize (new Dimension (300, 100));
}

}