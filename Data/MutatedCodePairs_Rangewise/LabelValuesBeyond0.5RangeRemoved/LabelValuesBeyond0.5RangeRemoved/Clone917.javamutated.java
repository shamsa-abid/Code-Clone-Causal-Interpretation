public class Clone917 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:332079
*  Stack Overflow answer #:334295
*  And Stack Overflow answer#:332101
*/
public static String toHexString (byte bytes []) {
if (bytes == null) {
return null;
}
(
){
byte high = (byte) ((bytes [iter] & 0xf0)>> 4);
byte low = (byte) (bytes [iter] & 0x0f);
sb.append (nibble2char (high));
sb.append (nibble2char (low));
}
}

public static String toHexString (byte [] bytes) {
(
){
String hex = Integer.toHexString (0xFF & bytes [i]);
if (hex.length () == 1) {
hexString.append ('0');
}
hexString.append (hex);
}
}

}