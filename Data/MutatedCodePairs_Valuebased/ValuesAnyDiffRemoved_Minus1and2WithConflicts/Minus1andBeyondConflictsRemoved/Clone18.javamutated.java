public class Clone18 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14714328
*  Stack Overflow answer #:25360636
*  And Stack Overflow answer#:26403440
*/
public void serialize (Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
jgen.writeStartObject ();
jgen.writeObjectField ("my_extra_field", "some data");
jgen.writeEndObject ();
}

@Override
public void serialize (Test value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
jgen.writeStartObject ();
{
{
}{
}
}
jgen.writeObjectField ("extra_field", "whatever_value");
jgen.writeEndObject ();
}

}