public class Clone399 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3320400
*  Stack Overflow answer #:15816247
*  And Stack Overflow answer#:7820092
*/
public void contextDestroyed (ServletContextEvent servletContextEvent) {
if (this.driver != null) {
{
}{
}
} else {
LOG.warn ("No driver to deregister");
}
}

public void contextDestroyed (ServletContextEvent sce) {
Context initContext = new InitialContext ();
Context envContext = (Context) initContext.lookup ("java:/comp/env");
DataSource datasource = (DataSource) envContext.lookup ("jdbc/database");
{
}{
}
}

}