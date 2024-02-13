public class Clone80 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5357455
*  Stack Overflow answer #:24632346
*  And Stack Overflow answer#:23816494
*/
public CharSequence filter (CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
String replacement = source.subSequence (start, end).toString ();
if (TextUtils.isEmpty (source)) return dest.subSequence (dstart, dend);
}

public CharSequence filter (CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
String lsStart = "";
String lsInsert = "";
String lsEnd = "";
String lsText = "";
Log.d ("debug", moPattern.toString ());
Log.d ("debug", "source: " + source + ", start: " + start + ", end:" + end + ", dest: " + dest + ", dstart: " + dstart + ", dend: " + dend);
lsText = dest.toString ();
if (lsText.length () > 0) {
Log.d ("debug", "lsStart : " + lsStart);
if (source != "") {
lsInsert = source.toString ();
Log.d ("debug", "lsInsert: " + lsInsert);
}
Log.d ("debug", "lsEnd   : " + lsEnd);
Log.d ("debug", "lsText  : " + lsText);
}
Log.d ("debug", "loMatcher.matches(): " + loMatcher.matches () + ", lsText: " + lsText);
if (! loMatcher.matches ()) {
}
}

}