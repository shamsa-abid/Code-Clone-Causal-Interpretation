public class Clone19 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14714328
*  Stack Overflow answer #:25360636
*  And Stack Overflow answer#:33248328
*/
public void serialize (Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
jgen.writeObjectField ("my_extra_field", "some data");
}

public void serialize (final Object bean, final JsonGenerator jgen, final SerializerProvider provider) throws IOException, JsonGenerationException {
{
}{
}
serializerListener.postSerialization (bean, jgen);
}

}