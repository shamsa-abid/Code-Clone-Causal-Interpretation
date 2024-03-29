public class Clone198 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5800433
*  Stack Overflow answer #:6275079
*  And Stack Overflow answer#:33287093
*/
public Command deserialize (JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
try {
Class < ? extends Command > commandInstanceClass = commandRegistry.get ();
Command command = gson.fromJson (json, commandInstanceClass);
return command;
} catch (Exception e) {
throw new RuntimeException (e);
}
}

public IAnimal deserialize (JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
Class < ? > klass = null;
try {
klass = Class.forName (className);
} catch (ClassNotFoundException e) {
e.printStackTrace ();
throw new JsonParseException (e.getMessage ());
}
return context.deserialize (jsonObject.get (INSTANCE), klass);
}

}