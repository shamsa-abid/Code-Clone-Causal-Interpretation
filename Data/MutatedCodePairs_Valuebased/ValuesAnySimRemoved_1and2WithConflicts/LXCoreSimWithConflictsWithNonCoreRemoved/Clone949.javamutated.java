public class Clone949 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:24183246
*  Stack Overflow answer #:24186069
*  And Stack Overflow answer#:38525506
*/
public static void main (String [] args) throws InterruptedException, ExecutionException {
CompletableFuture < List < String > > linksCF = contentsCF.thenApply (CompletableFutureTest :: getLinks);
{(
})
List < String > result = linksCF.get ();
System.out.println ("Got " + result);
try {
completionStage.get ();
} catch (ExecutionException e) {
System.out.println ("Caught " + e);
Throwable cause = e.getCause ();
System.out.println ("cause: " + cause);
}
{(
})
try {
completionStage.get ();
} catch (Throwable t) {
System.out.println ("Already handled by the future " + t);
}
}

public static void main (String [] args) throws InterruptedException, ExecutionException {
{(
})
{(
})
}

}