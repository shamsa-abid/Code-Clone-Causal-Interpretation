public class Clone612 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7032556
*  Stack Overflow answer #:7583435
*  And Stack Overflow answer#:7033191
*/
public static void main (String [] args) throws IOException {
File scrFile = ((TakesScreenshot) driver).getScreenshotAs (OutputType.FILE);
FileUtils.copyFile (scrFile, new File (RESULT_FILENAME));
driver.close ();
p.destroy ();
}

public static void main (String [] args) {
try {
BufferedImage bi = robot.createScreenCapture (new Rectangle (Toolkit.getDefaultToolkit ().getScreenSize ()));
ImageIO.write (bi, "jpg", new File ("C:/imageTest.jpg"));
} catch (AWTException e) {
e.printStackTrace ();
} catch (IOException e) {
e.printStackTrace ();
}
}

}