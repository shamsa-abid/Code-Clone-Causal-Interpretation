public class Clone700 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14326598
*  Stack Overflow answer #:14327483
*  And Stack Overflow answer#:14327260
*/
public static void main (String [] args) throws Exception {
XMLInputFactory xif = XMLInputFactory.newFactory ();
XMLStreamReader xsr = xif.createXMLStreamReader (xml);
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
while (xsr.hasNext ()) {
if (xsr.isStartElement ()) {
System.out.println ("start: " + xsr.getLocalName ());
} else if (xsr.isCharacters ()) {
if (xsr.getText ().trim ().length () > 0) {
System.out.println ("chars: " + xsr.getText ());
}
} else if (xsr.isEndElement ()) {
System.out.println ("end: " + xsr.getLocalName ());
}
xsr.next ();
}
}

public static void main (String [] args) throws FileNotFoundException, XMLStreamException {
XMLInputFactory xmlif = XMLInputFactory.newFactory ();
XMLStreamReader2 xmlsr = (XMLStreamReader2) xmlif.createXMLStreamReader (fis);
while (xmlsr.hasNext ()) {
int eventType = xmlsr.next ();
switch (eventType) {
case (XMLEvent2.START_ELEMENT) :
currentElementName = xmlsr.getName ().toString ();
if ("dad".equals (currentElementName) == true) {
System.out.println ("isStartElement: " + xmlsr.isStartElement ());
System.out.println ("Element BEGIN: " + currentElementName);
xmlsr.skipElement ();
} else {
System.out.println (currentElementName);
}
}
}
}

}