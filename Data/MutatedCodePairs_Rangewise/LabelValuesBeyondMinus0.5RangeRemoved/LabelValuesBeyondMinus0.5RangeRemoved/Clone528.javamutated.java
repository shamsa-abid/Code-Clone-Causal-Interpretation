public class Clone528 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6346075
*  Stack Overflow answer #:19528723
*  And Stack Overflow answer#:15986264
*/
public View getView (int position, View convertView, ViewGroup parent) {
{
rowView = inflater.inflate (R.layout.test_row, null);
}
{
}
{
{
{
}
{
}
{
}
{
}
}
{
}}
return rowView;
}

public View getView (int position, View convertView, ViewGroup parent) {
convertView = mInflater.inflate (R.layout.listview_row, null);
return convertView;
}

}