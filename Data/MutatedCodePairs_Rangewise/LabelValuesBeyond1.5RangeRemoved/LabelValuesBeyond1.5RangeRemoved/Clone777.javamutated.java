public class Clone777 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:443730
*  Stack Overflow answer #:444118
*  And Stack Overflow answer#:25953824
*/
@Override
public String toString () {
[(
{
{
try {
} catch (IllegalAccessException e) {
}
}
}
()
}

public String toString (Object obj) {
if (obj == null) return "null";
if (visited.contains (obj)) return "...";
visited.add (obj);
Class cl = obj.getClass ();
if (cl == String.class) return (String) obj;
if (cl.isArray ()) {
String r = cl.getComponentType () + "[]{";
for (int i = 0;
i < Array.getLength (obj); i ++) {
if (i > 0) r += ",";
Object val = Array.get (obj, i);
if (cl.getComponentType ().isPrimitive ()) r += val;
else r += toString (val);
}
return r + "}";
}
String r = cl.getName ();
do {
[
Field [] fields = cl.getDeclaredFields ();
AccessibleObject.setAccessible (fields, true);
{
{
if (! r.endsWith ("[")) r += ",";
try {
Class t = f.getType ();
if (t.isPrimitive ()) r += val;
 r += toString (val);
} catch (Exception e) {
e.printStackTrace ();
}
}
}
]
cl = cl.getSuperclass ();
} while (cl != null);
}

}