public class Clone401 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3320400
*  Stack Overflow answer #:7820092
*  And Stack Overflow answer#:23912257
*/
public void contextDestroyed (ServletContextEvent sce) {
try {
java.sql.Driver mySqlDriver = DriverManager.getDriver ("jdbc:mysql://localhost:3306/");
DriverManager.deregisterDriver (mySqlDriver);
} catch (SQLException ex) {
logger.info ("Could not deregister driver:".concat (ex.getMessage ()));
}
}

public final void contextDestroyed (ServletContextEvent sce) {
Enumeration < Driver > drivers = DriverManager.getDrivers ();
{
{
try {
log.info ("Deregistering JDBC driver {}", driver);
DriverManager.deregisterDriver (driver);
} catch (SQLException ex) {
log.error ("Error deregistering JDBC driver {}", driver, ex);
}
}{
}
}
}

}