public class Clone732 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19825946
*  Stack Overflow answer #:43744163
*  And Stack Overflow answer#:45833337
*/
public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
HttpServletRequest req = (HttpServletRequest) request;
{
}
chain.doFilter (request, response);
}

public void doFilter (ServletRequest arg0, ServletResponse response, FilterChain chain) throws IOException, ServletException {
logger.info ("checking client id in filter");
HttpServletRequest request = (HttpServletRequest) arg0;
{
chain.doFilter (request, response);
}{
}
}

}