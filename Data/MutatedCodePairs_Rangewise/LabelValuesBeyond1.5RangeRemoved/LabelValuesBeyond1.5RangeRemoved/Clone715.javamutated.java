public class Clone715 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:26737852
*  Stack Overflow answer #:26738642
*  And Stack Overflow answer#:26738104
*/
private static void decimalToHex (int decimal) {
int maxDigit = 1;
while (maxDigit * 16 <= decimal && maxDigit > 0) {
maxDigit *= 16;
}
if (maxDigit <= 0) {
throw new IllegalArgumentException ("Can not convert " + decimal);
}
(
){
}
}

private static void decimalToHex (int decimal) {
{
} else {
System.out.print ("0");
}
{
} else {
System.out.print ("0");
}
decimal /= 16;
}

}