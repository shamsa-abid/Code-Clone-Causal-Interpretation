public class Clone612 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7032556
*  Stack Overflow answer #:7583435
*  And Stack Overflow answer#:7033191
*/
public static void main (String [] args) throws IOException {
Process p = Runtime.getRuntime ().exec (XVFB_COMMAND);
FirefoxBinary firefox = new FirefoxBinary ();
firefox.setEnvironmentProperty ("DISPLAY", ":" + DISPLAY_NUMBER);
WebDriver driver = new FirefoxDriver (firefox, null);
driver.get (URL);
driver.close ();
p.destroy ();
}

public static void main (String [] args) {
try {
Robot robot = new Robot ();
} catch (AWTException e) {
e.printStackTrace ();
} catch (IOException e) {
e.printStackTrace ();
}
}

}