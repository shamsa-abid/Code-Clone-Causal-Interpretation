public class Clone739 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8664705
*  Stack Overflow answer #:26765051
*  And Stack Overflow answer#:34588482
*/
public int read () throws IOException {
if (currentPos < currentLineEnd) {
return readByte;
} else if (currentPos > lastPosInFile && currentLineStart < currentLineEnd) {
findPrevLine ();
if (lastChar != '\n' && lastChar != '\r') {
return '\n';
} else {
return read ();
}
    } else if  {}

 else {
}
}

public int read () throws IOException {
}
if (! lineBuffered) {
}
if (lineBuffered) {
if (currentLineReadPos == 0) {
lineBuffered = false;
}
}
return 0;
}

}