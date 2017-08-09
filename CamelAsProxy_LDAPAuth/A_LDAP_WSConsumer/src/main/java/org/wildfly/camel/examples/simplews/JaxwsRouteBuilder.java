package org.wildfly.camel.examples.simplews;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.bean.BeanInvocation;
import org.wildfly.extension.camel.CamelAware;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.camel.component.cxf.CxfEndpoint;


/**
 * This Route is offered as a web service (via Camel Proxy) to SOAP callers.
 * It uses the CXF component to act as a web service producer, so it acts as an intermediary proxy.
 */

@Startup
@CamelAware
@ApplicationScoped
public class JaxwsRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:simplews")
        .log("### The web service proxy runs! ###")

        // Set up the message body for the called web service

        .process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {


                String name = exchange.getIn().getBody(String.class);
                Object[] serviceParams = new Object[] {name};
                exchange.getOut().setBody(serviceParams);

            }
        })
        // Notice we pass the authentication information for the proxied web service here.
        .to("cxf://http://localhost:8080/example-camel-jaxws/greeting?username=admin&password=admin&serviceClass=" + org.wildfly.camel.examples.jaxws.GreetingService.class.getName());
    }
}
