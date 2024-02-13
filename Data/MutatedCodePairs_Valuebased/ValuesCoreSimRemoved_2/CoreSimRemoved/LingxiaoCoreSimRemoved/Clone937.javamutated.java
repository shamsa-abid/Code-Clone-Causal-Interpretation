public class Clone937 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5366606
*  Stack Overflow answer #:5366720
*  And Stack Overflow answer#:5366833
*/
public static void main (String [] args) {
List < Object > myArray = new ArrayList < Object > ();
myArray.add (MyJsonObject.parse ("{\"lon\": 0.001, \"lat\": 0.001, \"desc\": \"test\"}"));
myArray.add (MyJsonObject.parse ("{\"lon\": 0.001, \"lat\": 0.001, \"desc\": \"test2\"}"));
List seenObjects = new ArrayList < Object > ();
{
{
}{
}
}
{
}
}

public static void main (String [] args) {
String s = "[" + " {\"lon\": 0.001, \"lat\": 0.001, \"desc\": \"test\"}," + " {\"lon\": 0.002, \"lat\": 0.001, \"desc\": \"test3\"}," + " {\"lon\": 0.002, \"lat\": 0.005, \"desc\": \"test4\"}," + " {\"lon\": 0.002, \"lat\": 0.001, \"desc\": \"test5\"}," + " {\"lon\": 0.001, \"lat\": 0.001, \"desc\": \"test2\"}]";
Gson gson = new Gson ();
Location [] al = gson.fromJson (s, Location [].class);
List < Location > tl = Arrays.asList (al);
Collections.sort (tl);
List < Location > fl = new ArrayList < Location > ();
Location current = null;
(
){
}
}

}