public class Clone753 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6721134
*  Stack Overflow answer #:7387359
*  And Stack Overflow answer#:15007980
*/
public String getContactName (final String phoneNumber) {
Uri uri;
String [] projection;
mBaseUri = Contacts.Phones.CONTENT_FILTER_URL;
projection = new String [] {android.provider.Contacts.People.NAME};
try {
Class < ? > c = Class.forName ("android.provider.ContactsContract$PhoneLookup");
mBaseUri = (Uri) c.getField ("CONTENT_FILTER_URI").get (mBaseUri);
projection = new String [] {"display_name"};
} catch (Exception e) {
}
String contactName = "";
{
}
cursor = null;
}

private String getContactName (Context context, String number) {
String name = null;
String [] projection = new String [] {ContactsContract.PhoneLookup.DISPLAY_NAME, ContactsContract.PhoneLookup._ID};
if (cursor != null) {
{
Log.v (TAG, "Started uploadcontactphoto: Contact Found @ " + number);
Log.v (TAG, "Started uploadcontactphoto: Contact name  = " + name);
} else {
Log.v (TAG, "Contact Not Found @ " + number);
}
}
}

}