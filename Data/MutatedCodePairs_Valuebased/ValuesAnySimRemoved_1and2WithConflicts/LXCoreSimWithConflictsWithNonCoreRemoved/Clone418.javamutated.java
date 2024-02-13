public class Clone418 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3911966
*  Stack Overflow answer #:3911982
*  And Stack Overflow answer#:3911982
*/
public String getName (String value) {
int number;
if (value.isEmpty ()) {
number = 0;
} else if (value.length () > 4) {
number = Integer.valueOf (value.substring (value.length () - 4), 10);
} else {
number = Integer.valueOf (value, 10);
}
number %= 1000;
if (number >= 100) {
}
String tensName = tensProcessor.getName (number % 100);
}
}

public String getName (String value) {
String high, low;
if (value.length () < getPartDivider ()) {
high = "";
low = value;
} else {
int index = value.length () - getPartDivider ();
high = value.substring (0, index);
low = value.substring (index);
}
String highName = getHighProcessor ().getName (high);
String lowName = getLowProcessor ().getName (low);
if (! highName.isEmpty ()) {
}
}
}
}

}