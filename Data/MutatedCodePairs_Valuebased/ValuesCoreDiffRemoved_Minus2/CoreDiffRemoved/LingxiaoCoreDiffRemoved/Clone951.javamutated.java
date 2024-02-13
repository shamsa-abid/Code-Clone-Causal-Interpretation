public class Clone951 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:28356506
*  Stack Overflow answer #:37916222
*  And Stack Overflow answer#:28357193
*/
public Object instantiateItem (ViewGroup collection, int position) {
switch (position) {
case 0 :
tvLabel.setText ("Log In");
tvLabel.setOnClickListener (new View.OnClickListener () {
@Override
public void onClick (View v) {
}}
);
break;
case 1 :
tvLabel.setText ("Sign Up");
tvLabel.setOnClickListener (new View.OnClickListener () {
@Override
public void onClick (View v) {
}}
);
break;
case 2 :
tvLabel.setText ("Send Reset Link");
tvLabel.setOnClickListener (new View.OnClickListener () {
@Override
public void onClick (View v) {
}}
);
break;
}
collection.addView (layout);
return layout;
}

public Object instantiateItem (final ViewGroup container, int position) {
final int page = position;
button.setOnClickListener (new View.OnClickListener () {
@Override
public void onClick (View v) {
}}
);
container.addView (layout);
return layout;
}

}