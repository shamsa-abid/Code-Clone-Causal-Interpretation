public class Clone400 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3320400
*  Stack Overflow answer #:15816247
*  And Stack Overflow answer#:23912257
*/
public void contextDestroyed (ServletContextEvent servletContextEvent) {
if (this.driver != null) {
{
}{
}
this.driver = null;
} else {
LOG.warn ("No driver to deregister");
}
}

public final void contextDestroyed (ServletContextEvent sce) {
ClassLoader cl = Thread.currentThread ().getContextClassLoader ();
Enumeration < Driver > drivers = DriverManager.getDrivers ();
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