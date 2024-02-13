public class Clone355 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:48280166
*  Stack Overflow answer #:48280313
*  And Stack Overflow answer#:48281085
*/
private static void printPath (int [] [] mat, int i, int j) {
System.out.println ("(" + i + "," + j + ")");
{
}{
}{
}{
}
}

private static void printPath (int [] [] mat, int i, int j) {
if (mat.length == 0 || mat [0].length == 0) {
System.out.println ("Empty matrix");
return;
}
System.out.println ("(" + i + "," + j + ")");
if (rightValue > leftValue) {
if (rightValue > belowValue) {
if (rightValue > aboveValue) {
} else {
}
} else {
if (belowValue > aboveValue) {
} else {
}
}
} else {
if (leftValue > belowValue) {
if (leftValue > aboveValue) {
} else {
}
} else {
if (belowValue > aboveValue) {
} else {
}
}
}
}

}