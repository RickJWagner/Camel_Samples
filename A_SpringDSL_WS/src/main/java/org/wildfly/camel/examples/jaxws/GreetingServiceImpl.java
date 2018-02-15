package org.wildfly.camel.examples.jaxws;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.ProxyBuilder;

@WebService(serviceName="greeting", endpointInterface = "org.wildfly.camel.examples.jaxws.GreetingService")
public class GreetingServiceImpl {

    @Inject
    private CamelContext context;

    private GreetingService greetingService;

    /**
     * Configures a proxy for the direct:start endpoint
     */
    @PostConstruct
    public void initServiceProxy() throws Exception {
        greetingService = new ProxyBuilder(context).endpoint("direct-vm:start").binding(false).build(GreetingService.class);
    }


    @WebMethod(operationName = "greetWithMessage")
    public String greetWithMessage(@WebParam(name = "message") String message, @WebParam(name = "name") String name) {
        /**
         * Invoke the proxied greetWithMessage method and pass on the arguments we received
         */
        return greetingService.greetWithMessage(message, name);
    }
}
