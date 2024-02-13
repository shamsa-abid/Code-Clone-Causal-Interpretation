public class Clone376 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14522239
*  Stack Overflow answer #:39584230
*  And Stack Overflow answer#:40787814
*/
private static void verifyDirsAreEqual (Path one, Path other) throws IOException {
{(
{
{
}
}}
)
}

private static void verifyDirsAreEqual (File expected, File generated) throws IOException {
assertTrue ("Generated Folder doesn't exist: " + generated, generated.exists ());
assertTrue ("Generated is not a folder?!?!: " + generated, generated.isDirectory ());
assertTrue ("Expected Folder doesn't exist: " + expected, expected.exists ());
assertTrue ("Expected is not a folder?!?!: " + expected, expected.isDirectory ());
{(
@Override
public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attrs) throws IOException {
FileVisitResult result = super.preVisitDirectory (dir, attrs);
Path relativize = expected.toPath ().relativize (dir);
File otherDir = generated.toPath ().resolve (relativize).toFile ();
log.debug ("=== preVisitDirectory === compare " + dir + " to " + otherDir);
assertEquals ("Folders doesn't contain same file!?!?", Arrays.toString (dir.toFile ().list ()), Arrays.toString (otherDir.list ()));
return result;
}
{
}}
)
}

}