public class Clone867 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:221525
*  Stack Overflow answer #:20644976
*  And Stack Overflow answer#:6125609
*/
public V put (K key, V value) {
readWriteLock.writeLock ().lock ();
{
old = super.put (key, value);
}{
readWriteLock.writeLock ().unlock ();
}
}

public void put (Key key, Value val) {
{
}
{
}
synchronized (this) {
queue.add (key);
map.put (key, val);
}
}

}