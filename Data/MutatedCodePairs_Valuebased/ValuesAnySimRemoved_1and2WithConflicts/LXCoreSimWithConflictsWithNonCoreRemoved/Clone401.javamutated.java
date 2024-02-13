public class Clone401 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3320400
*  Stack Overflow answer #:7820092
*  And Stack Overflow answer#:23912257
*/
public void contextDestroyed (ServletContextEvent sce) {
Context initContext = new InitialContext ();
Context envContext = (Context) initContext.lookup ("java:/comp/env");
DataSource datasource = (DataSource) envContext.lookup ("jdbc/database");
{
}{
}
dataSource = null;
}

public final void contextDestroyed (ServletContextEvent sce) {
ClassLoader cl = Thread.currentThread ().getContextClassLoader ();
while (drivers.hasMoreElements ()) {
Driver driver = drivers.nextElement ();
if (driver.getClass ().getClassLoader () == cl) {
{
}{
}
} else {
log.trace ("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader", driver);
}
}
}

}