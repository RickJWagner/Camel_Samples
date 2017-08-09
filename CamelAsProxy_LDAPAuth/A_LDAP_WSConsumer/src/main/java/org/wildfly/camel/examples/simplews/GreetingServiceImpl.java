package org.wildfly.camel.examples.simplews;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.ProxyBuilder;

@WebService(serviceName="simplegreeting", endpointInterface = "org.wildfly.camel.examples.simplews.GreetingService")
public class GreetingServiceImpl {

    @Inject
    private CamelContext context;

    private GreetingService greetingService;

    @PostConstruct
    public void initServiceProxy() throws Exception {
        greetingService = new ProxyBuilder(context).endpoint("direct:simplews").binding(false).build(GreetingService.class);
    }

    @WebMethod(operationName = "simplegreet")
    public String simplegreet(@WebParam(name = "name") String name) {
        /**
         * Invoke the proxied greet method and pass on the arguments we received
         */
        String ret = greetingService.simplegreet(name);
        System.out.println("### simplegreet returns:" + ret +"###"); 
        return ret;
    }

}
