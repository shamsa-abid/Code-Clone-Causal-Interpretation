public class Clone692 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:30755370
*  Stack Overflow answer #:30757009
*  And Stack Overflow answer#:30772540
*/
public void start (Stage primaryStage) throws Exception {
Thread thread = new Thread (() -> {
try {
Thread.sleep (5000);
if (alert.isShowing ()) {
Platform.runLater (() -> alert.close ());
}
} catch (Exception exp) {
exp.printStackTrace ();
}
});
thread.setDaemon (true);
thread.start ();
Optional < ButtonType > result = alert.showAndWait ();
}

@Override
public void start (final Stage primaryStage) {
alert.initModality (Modality.NONE);
Button b = new Button ("close alert");
b.setOnAction ((ActionEvent event) -> {
for (ButtonType bt : alert.getDialogPane ().getButtonTypes ()) {
System.out.println ("bt = " + bt);
if (bt.getButtonData () == ButtonBar.ButtonData.CANCEL_CLOSE) {
Button cancelButton = (Button) alert.getDialogPane ().lookupButton (bt);
cancelButton.fire ();
break;
}
}
});
final Scene scene = new Scene (new Group (b), 400, 300);
primaryStage.setScene (scene);
primaryStage.show ();
Optional < ButtonType > result = alert.showAndWait ();
if (result.get () == buttonTypeOne) {
System.out.println ("one ");
} else if (result.get () == buttonTypeCancel) {
System.out.println ("cancel ");
}
}

}