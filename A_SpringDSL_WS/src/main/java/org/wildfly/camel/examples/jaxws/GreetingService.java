package org.wildfly.camel.examples.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "greeting")
public interface GreetingService {

    @WebMethod(operationName = "greetWithMessage", action = "urn:greetWithMessage")
    String greetWithMessage(@WebParam(name = "message") String message, @WebParam(name = "name") String name);
}
