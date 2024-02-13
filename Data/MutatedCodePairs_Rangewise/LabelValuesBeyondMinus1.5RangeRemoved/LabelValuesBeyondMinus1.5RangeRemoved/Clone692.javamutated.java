public class Clone692 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:30755370
*  Stack Overflow answer #:30757009
*  And Stack Overflow answer#:30772540
*/
public void start (Stage primaryStage) throws Exception {
Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
alert.setTitle ("Title");
alert.setHeaderText ("Some Text");
alert.setContentText ("Choose your option.");
ButtonType buttonTypeOne = new ButtonType ("Yes");
ButtonType buttonTypeCancel = new ButtonType ("No", ButtonBar.ButtonData.CANCEL_CLOSE);
alert.getButtonTypes ().setAll (buttonTypeOne, buttonTypeCancel);
{(
{
{
}
}{
}
})
Optional < ButtonType > result = alert.showAndWait ();
}

@Override
public void start (final Stage primaryStage) {
Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
alert.setTitle ("Title");
alert.setHeaderText ("Some Text");
alert.setContentText ("Choose your option.");
ButtonType buttonTypeOne = new ButtonType ("Yes");
alert.initModality (Modality.NONE);
ButtonType buttonTypeCancel = new ButtonType ("No", ButtonBar.ButtonData.CANCEL_CLOSE);
alert.getButtonTypes ().setAll (buttonTypeOne, buttonTypeCancel);
{(
{
{
}
}
})
Optional < ButtonType > result = alert.showAndWait ();
{
}{
}
}

}