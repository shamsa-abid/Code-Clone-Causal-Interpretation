public class Clone729 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3382996
*  Stack Overflow answer #:27050680
*  And Stack Overflow answer#:40125872
*/
public static void unzip (File zipFile, File targetDirectory) throws IOException {
try {
ZipEntry ze;
int count;
byte [] buffer = new byte [8192];
{
File dir = ze.isDirectory () ? file : file.getParentFile ();
if (! dir.isDirectory () && ! dir.mkdirs ()) throw new FileNotFoundException ("Failed to ensure directory: " + dir.getAbsolutePath ());
try {
} finally {
fout.close ();
}
}
} finally {
zis.close ();
}
}

public void unzip () {
try {
ZipEntry ze = null;
{
Log.v ("Decompress", "Unzipping " + ze.getName ());
if (ze.isDirectory ()) {
_dirChecker (ze.getName ());
} else {
BufferedOutputStream bufout = new BufferedOutputStream (fout);
byte [] buffer = new byte [1024];
int read = 0;
{
}
bufout.close ();
zin.closeEntry ();
fout.close ();
}
}
zin.close ();
Log.d ("Unzip", "Unzipping complete. path :  " + _location);
} catch (Exception e) {
Log.e ("Decompress", "unzip", e);
Log.d ("Unzip", "Unzipping failed");
}
}

}