public class Clone532 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7121243
*  Stack Overflow answer #:7123982
*  And Stack Overflow answer#:7123982
*/
public void run () {
try {
Thread.sleep (500);
Thread.sleep (500);
count = 0;
Thread.sleep (750);
} catch (Exception e) {
System.out.println (e);
}
}

public void run () {
try {
runs = true;
if (noColor < 2) {
noColor ++;
changeBtnForegroung (clr [noColor]);
} else {
noColor = 0;
changeBtnForegroung (clr [noColor]);
}
changeBtnMargin (new Insets (initMargin.top, initMargin.left + 10, initMargin.bottom, initMargin.right - 10));
border = new EmptyBorder (0, 5, 10, 5);
changePnlBorder (border);
Thread.sleep (100);
changeBtnMargin (new Insets (initMargin.top, initMargin.left - 10, initMargin.bottom, initMargin.right + 10));
border = new EmptyBorder (0, 0, 10, 10);
changePnlBorder (border);
Thread.sleep (100);
changeBtnMargin (new Insets (initMargin.top, initMargin.left + 10, initMargin.bottom, initMargin.right - 10));
border = new EmptyBorder (5, 10, 5, 0);
changePnlBorder (border);
Thread.sleep (100);
changeBtnMargin (new Insets (initMargin.top, initMargin.left - 10, initMargin.bottom, initMargin.right + 10));
border = new EmptyBorder (10, 10, 0, 0);
changePnlBorder (border);
Thread.sleep (100);
changeBtnMargin (new Insets (initMargin.top, initMargin.left, initMargin.bottom, initMargin.right));
border = new EmptyBorder (5, 5, 5, 5);
changePnlBorder (border);
Thread.sleep (100);
count ++;
} catch (Exception e) {
System.out.println (e);
}
}

}