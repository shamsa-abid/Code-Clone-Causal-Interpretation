public class Clone307 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:309424
*  Stack Overflow answer #:48775964
*  And Stack Overflow answer#:48775964
*/
public String inputStreamToString (InputStream inputStream) throws IOException {
{
while ((length = inputStream.read (buffer)) != - 1) {
result.write (buffer, 0, length);
}
return result.toString (UTF_8);
}
}

public String inputStreamToString (InputStream inputStream) throws IOException {
while ((line = reader.readLine ()) != null) {
result.append (flag ? newLine : "").append (line);
flag = true;
}
return result.toString ();
}

}