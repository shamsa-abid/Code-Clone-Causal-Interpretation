public class Clone263 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19459197
*  Stack Overflow answer #:20782126
*  And Stack Overflow answer#:25526428
*/
public int solution (int X, int [] A) {
for (int x = 0;
x < size; x ++) {
int temp = A [x];
if (temp <= X) {
if (check [temp - 1] > 0) {
continue;
}
check [temp - 1] ++;
cmp ++;
}
if (cmp == X) {
time = x;
break;
}
}
return time;
}

public int solution (int X, int [] A) {
for (int i = 0;
i <= X; i ++) {
sum1 += i;
}
for (int i = 0;
i < A.length; i ++) {
if (set.contains (A [i])) continue;
set.add (A [i]);
sum2 += A [i];
if (sum1 == sum2) return i;
}
return - 1;
}

}