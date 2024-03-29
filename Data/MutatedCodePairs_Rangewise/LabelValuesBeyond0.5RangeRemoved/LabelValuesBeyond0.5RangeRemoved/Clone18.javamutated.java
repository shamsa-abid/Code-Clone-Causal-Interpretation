public class Clone18 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14714328
*  Stack Overflow answer #:25360636
*  And Stack Overflow answer#:26403440
*/
public void serialize (Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
JavaType javaType = provider.constructType (CustomClass.class);
BeanDescription beanDesc = provider.getConfig ().introspect (javaType);
JsonSerializer < Object > serializer = BeanSerializerFactory.instance.findBeanSerializer (provider, javaType, beanDesc);
serializer.unwrappingSerializer (null).serialize (value, jgen, provider);
}

@Override
public void serialize (Test value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
Field [] fields = value.getClass ().getDeclaredFields ();
for (Field field : fields) {
try {
jgen.writeObjectField (field.getName (), field.get (value));
} catch (IllegalArgumentException | IllegalAccessException e) {
e.printStackTrace ();
}
}
}

}