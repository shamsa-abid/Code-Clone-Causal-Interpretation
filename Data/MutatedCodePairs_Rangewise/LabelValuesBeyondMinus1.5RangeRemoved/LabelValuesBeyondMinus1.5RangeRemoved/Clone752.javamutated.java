public class Clone752 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:28816691
*  Stack Overflow answer #:28835815
*  And Stack Overflow answer#:29165280
*/
public static void main (String [] args) throws Exception {
ObservableList < Integer > olist = new ObservableList < > ();
olist.getObservable ().subscribe (System.out :: println);
olist.add (1);
olist.add (2);
}

public static void main (String [] args) {
List < Integer > initialNumbers = new ArrayList < Integer > ();
initialNumbers.add (1);
initialNumbers.add (2);
Observable < Integer > observableInitial = Observable.from (initialNumbers);
Observable < Integer > source = Observable.merge (observableInitial, subject);
source.subscribe (System.out :: println);
(
){
}
}

}