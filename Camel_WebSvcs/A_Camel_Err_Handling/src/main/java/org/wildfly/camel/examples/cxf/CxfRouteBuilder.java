package org.wildfly.camel.examples.cxf;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.Processor;
import org.apache.camel.Exchange;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

@Startup
@ApplicationScoped
@ContextName("cxf-camel-context")
public class CxfRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        /**
         * This route defines a CXF producer endpoint which invokes a greeting web service.
         *
         * The {@link CamelCxfServlet} sends the required message and name parameters to the
         * service by populating them within the message exchange body.
         */
        from("direct:start").to("cxf://http://localhost:8080/example-camel-cxf/greeting?serviceClass=" + GreetingService.class.getName());

       // A second route, for a second web service

        from("direct:fetchdate")
            .doTry()
                .to("cxf://http://localhost:8080/example-camel-cxf/fetchdate?serviceClass=" + DateService.class.getName())
            .doCatch(Exception.class)
                   .process(new Processor() {
                        @Override
                        public void process(Exchange exchange) throws Exception {
                            exchange.getOut().setBody("Tuesday");
                        }
                   })
            .doFinally()
                .log("Done")
            .end();
    }
}
