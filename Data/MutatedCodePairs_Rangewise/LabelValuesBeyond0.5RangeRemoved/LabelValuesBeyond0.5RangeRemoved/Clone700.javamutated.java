public class Clone700 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14326598
*  Stack Overflow answer #:14327483
*  And Stack Overflow answer#:14327260
*/
public static void main (String [] args) throws Exception {
StreamSource xml = new StreamSource ("src/forum14326598/input.xml");
xsr = xif.createFilteredReader (xsr, new StreamFilter () {
private boolean accept = true;
@Override
public boolean accept (XMLStreamReader reader) {
if ((reader.isStartElement () || reader.isEndElement ()) && "dad".equals (reader.getLocalName ())) {
accept = ! accept;
return false;
} else {
return accept;
}
}}
);
{
{
if (xsr.getText ().trim ().length () > 0) {
System.out.println ("chars: " + xsr.getText ());
}
} else if (xsr.isEndElement ()) {
System.out.println ("end: " + xsr.getLocalName ());
}
}
}

public static void main (String [] args) throws FileNotFoundException, XMLStreamException {
System.setProperty ("javax.xml.stream.XMLInputFactory", "com.ctc.wstx.stax.WstxInputFactory");
System.setProperty ("javax.xml.stream.XMLOutputFactory", "com.ctc.wstx.stax.WstxOutputFactory");
System.setProperty ("javax.xml.stream.XMLEventFactory", "com.ctc.wstx.stax.WstxEventFactory");
FileInputStream fis = new FileInputStream (new File ("family.xml"));
String currentElementName = null;
{
{
if ("dad".equals (currentElementName) == true) {
System.out.println ("isStartElement: " + xmlsr.isStartElement ());
xmlsr.skipElement ();
} else {
System.out.println (currentElementName);
}
}
}
}

}