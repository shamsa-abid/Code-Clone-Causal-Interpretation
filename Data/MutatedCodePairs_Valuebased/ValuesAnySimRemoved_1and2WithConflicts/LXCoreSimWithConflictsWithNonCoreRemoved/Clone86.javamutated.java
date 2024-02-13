public class Clone86 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10075841
*  Stack Overflow answer #:10081196
*  And Stack Overflow answer#:10516705
*/
public void start (Stage stage) {
hideImageNodesMatching (htmlEditor, Pattern.compile (".*(Cut|Copy|Paste).*"), 0);
Node seperator = htmlEditor.lookup (".separator");
seperator.setVisible (false);
seperator.setManaged (false);
}

public void start (Stage primaryStage) {
for (Node toolBar = htmlEditor.lookup (".tool-bar");
toolBar != null; toolBar = htmlEditor.lookup (".tool-bar")) {
((Pane) toolBar.getParent ()).getChildren ().remove (toolBar);
}
}

}