
package org.wildfly.camel.examples.simplews;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "simplegreeting")
public interface GreetingService {
    @WebMethod(operationName = "simplegreet", action = "urn:greet")
    String simplegreet(@WebParam(name = "name") String name);
}
