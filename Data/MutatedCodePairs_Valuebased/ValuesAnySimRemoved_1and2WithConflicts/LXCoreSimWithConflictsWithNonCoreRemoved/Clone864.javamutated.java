public class Clone864 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:33706467
*  Stack Overflow answer #:33706602
*  And Stack Overflow answer#:33706653
*/
@Override
public View getView (final int position, View convertView, ViewGroup parent) {
final ViewHolder holder;
if (convertView == null) {
holder = new ViewHolder ();
holder.checkbox = (CheckBox) convertView.findViewById (R.id.add_food_item);
convertView.setTag (holder);
} else {
holder = (ViewHolder) convertView.getTag ();
}
holder.checkbox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
@Override
public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
{
 else {
if (position < array.size ()) array.remove (position);
}
}}
);
}

public View getView (final int position, View convertview, ViewGroup parent) {
View v = convertview;
LayoutInflater vi = (LayoutInflater) getSystemService (Context.LAYOUT_INFLATER_SERVICE);
TextView txt_name = (TextView) v.findViewById (R.id.txt_name);
CheckBox checkBox1 = (CheckBox) findViewById (R.id.checkBox1);
{
}
btn_clear.setOnItemClickListener (new Listener () {
public void onClick (View v) {
x_list.clear ();
x_list.add (new_al);
}}
);
notifyDataSetChanged ();
}

}