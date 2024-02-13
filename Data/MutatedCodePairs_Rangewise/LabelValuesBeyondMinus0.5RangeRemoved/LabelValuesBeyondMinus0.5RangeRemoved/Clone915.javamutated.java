public class Clone915 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:332079
*  Stack Overflow answer #:2197650
*  And Stack Overflow answer#:334295
*/
public static String toHexString (byte [] bytes) {
for (int j = 0;
j < bytes.length; j ++) {
v = bytes [j] & 0xFF;
hexChars [j * 2] = hexArray [v / 16];
hexChars [j * 2 + 1] = hexArray [v % 16];
}
return new String (hexChars);
}

public static String toHexString (byte bytes []) {
{
}
for (int iter = 0;
iter < bytes.length; iter ++) {
byte high = (byte) ((bytes [iter] & 0xf0)>> 4);
byte low = (byte) (bytes [iter] & 0x0f);
sb.append (nibble2char (high));
sb.append (nibble2char (low));
}
return sb.toString ();
}

}