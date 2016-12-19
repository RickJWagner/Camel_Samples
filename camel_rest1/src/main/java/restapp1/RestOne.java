package restapp1;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * 
 * README
 * This is a plain Java 'main' program that will start the Camel 'context' (that's like a container for Caeml applications)
 * It adds a 'route', which tells Camel what we want to do.
 * It says 'make a timer, have it run every 2 seconds.  Make a log entry every 2 seconds'.
 * The context dies out after 10 seconds.  You'll probably have to use 'Control-C' to kill the program after running it.
 *
 */




public class RestOne {

    public static void main(String args[]) throws Exception {
    	
        // create CamelContext
        CamelContext context = new DefaultCamelContext();


        // add our route to the CamelContext
        context.addRoutes(new RouteBuilder() {
            public void configure() {
            	

        rest("/api")
            .get("/customer/{id}").to("log:restapp1?level=INFO");        

        /**
        rest("/api")
            .get("/customer/{id}")
            .description("Retrieve an existing customer")
            .outType(Customer.class)
            .param()
            .name("id")
            .type(path).dataType("int").endParam()
            .to("direct:getCustomer");
            **/

            restConfiguration().component("netty4-http")
                .host("localhost").port(8080);
                
            }
        });

        // start the route and let it do its work
        context.start();
        Thread.sleep(60000);

        // stop the CamelContext
        context.stop();
    }
}
