public class Clone20 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14714328
*  Stack Overflow answer #:26403440
*  And Stack Overflow answer#:33248328
*/
@Override
public void serialize (Test value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
jgen.writeStartObject ();
{
{
}{
}
}
jgen.writeEndObject ();
}

public void serialize (final Object bean, final JsonGenerator jgen, final SerializerProvider provider) throws IOException, JsonGenerationException {
jgen.writeStartObject ();
{
}{
}
jgen.writeEndObject ();
}

}