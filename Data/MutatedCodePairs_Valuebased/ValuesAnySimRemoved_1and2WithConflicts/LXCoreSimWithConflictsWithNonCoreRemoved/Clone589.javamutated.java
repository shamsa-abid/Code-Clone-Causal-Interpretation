public class Clone589 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2570410
*  Stack Overflow answer #:29105532
*  And Stack Overflow answer#:47226967
*/
public static void main (String [] args) throws TwilioRestException {
TwilioRestClient client = new TwilioRestClient (ACCOUNT_SID, AUTH_TOKEN);
List < NameValuePair > params = new ArrayList < NameValuePair > ();
MessageFactory messageFactory = client.getAccount ().getMessageFactory ();
Message message = messageFactory.create (params);
System.out.println (message.getSid ());
}

public static void main (String [] args) throws Exception {
AuthMethod auth = new TokenAuthMethod (API_KEY, API_SECRET);
NexmoClient client = new NexmoClient (auth);
SmsSubmissionResult [] responses = client.getSmsClient ().submitMessage (message);
for (SmsSubmissionResult response : responses) {
System.out.println (response);
}
}

}