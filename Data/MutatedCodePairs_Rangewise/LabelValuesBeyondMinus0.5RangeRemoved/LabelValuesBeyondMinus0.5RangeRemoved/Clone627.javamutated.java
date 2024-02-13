public class Clone627 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:35492790
*  Stack Overflow answer #:35708141
*  And Stack Overflow answer#:35713657
*/
public Comparable [] findCommonElements () {
for (Comparable x : collectionSet1) {
if (! collectionSet2.add (x)) {
commonStuff.add (x);
}
}
return commonStuff.toArray ();
}

public static Comparable [] findCommonElements (Comparable [] [] collections) {
if (arr1.length < arr2.length && arr1.length < arr3.length || arr2.length <= arr3.length) {
hashArray = arr1;
queryArray = ArrayUtils.addAll (arr2, arr3);
} else if (arr2.length < arr1.length && arr2.length < arr3.length || arr1.length <= arr3.length) {
hashArray = arr2;
queryArray = ArrayUtils.addAll (arr1, arr3);
} else if (arr3.length < arr1.length && arr3.length < arr2.length || arr1.length <= arr2.length) {
hashArray = arr3;
queryArray = ArrayUtils.addAll (arr1, arr2);
}
HashSet < Comparable > intersectionSet = new HashSet < > ();
HashSet < Comparable > arrayToHash = new HashSet < > ();
for (Comparable element : hashArray) {
arrayToHash.add (element);
}
for (Comparable element : queryArray) {
if (element != null) {
comparisons ++;
}
if (arrayToHash.contains (element)) {
intersectionSet.add (element);
}
}
return intersectionSet.toArray (new Comparable [0]);
}

}