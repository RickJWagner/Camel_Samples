package org.wildfly.camel.examples.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "fetchdate")
public interface DateService {
    @WebMethod(operationName = "fetchdate", action = "urn:fetchdate")
     String fetchdate(@WebParam(name = "causetrouble") String causetrouble);
}
