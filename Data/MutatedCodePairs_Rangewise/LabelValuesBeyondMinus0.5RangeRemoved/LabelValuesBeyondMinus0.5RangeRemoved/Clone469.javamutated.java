public class Clone469 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11506321
*  Stack Overflow answer #:29460716
*  And Stack Overflow answer#:11506847
*/
public static void main (String [] args) {
{
InetAddress address = InetAddress.getByName ("192.168.1.103");
boolean reachable = address.isReachable (10000);
System.out.println ("Is host reachable? " + reachable);
}{
}
}

public static void main (String [] args) throws UnknownHostException, IOException {
inet = InetAddress.getByAddress (new byte [] {127, 0, 0, 1});
System.out.println (inet.isReachable (5000) ? "Host is reachable" : "Host is NOT reachable");
inet = InetAddress.getByAddress (new byte [] {(byte) 173, (byte) 194, 32, 38});
System.out.println (inet.isReachable (5000) ? "Host is reachable" : "Host is NOT reachable");
}

}