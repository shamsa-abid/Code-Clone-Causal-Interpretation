public class Clone557 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:12683533
*  Stack Overflow answer #:12683632
*  And Stack Overflow answer#:12683632
*/
public void actionPerformed (ActionEvent arg0) {
if (dirty) {
result = showConfirmDialog (gui, "Erase the current painting?");
}
clear (canvasImage);
}
}

public void actionPerformed (ActionEvent arg0) {
if (! dirty) {
JFileChooser ch = getFileChooser ();
int result = ch.showOpenDialog (gui);
if (result == JFileChooser.APPROVE_OPTION) {
try {
BufferedImage bi = ImageIO.read (ch.getSelectedFile ());
setImage (bi);
} catch (IOException e) {
showError (e);
e.printStackTrace ();
}
}
} else {
showMessageDialog (gui, "TODO - prompt save image..");
}
}

}