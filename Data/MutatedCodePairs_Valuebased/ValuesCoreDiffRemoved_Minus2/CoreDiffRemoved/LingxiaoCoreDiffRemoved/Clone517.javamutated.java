public class Clone517 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5730330
*  Stack Overflow answer #:5730464
*  And Stack Overflow answer#:17203514
*/
public static void main (String [] args) throws Exception {
for (int len : new int [] {100 * 1000 * 1000, 10 * 1000 * 1000, 1000 * 1000, 100 * 1000, 10 * 1000, 1000}) {
int [] nums = new int [len];
for (int i = 0;
)
long timeArray = 0;
long timeSet = 0;
(
){
}
System.out.printf ("For %,d numbers, using an array took %,d us on average, using a Set took %,d us on average, ratio=%.1f%n", len, timeArray / 1000 / runs, timeSet / 1000 / runs, 1.0 * timeSet / timeArray);
}
}

public static void main (String [] args) throws Exception {
int [] x = {1, 2, - 3, 4, - 5, - 11, - 2, 3, - 4, 5};
int [] y = new int [0];
System.out.println (count);
}

}