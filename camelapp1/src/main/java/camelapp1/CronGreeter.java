package camelapp1;

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




public class CronGreeter {

    public static void main(String args[]) throws Exception {
    	
        // create CamelContext
        CamelContext context = new DefaultCamelContext();

        // add our route to the CamelContext
        context.addRoutes(new RouteBuilder() {
            public void configure() {
            	
                from("timer://foo2?period=2s")
                .log("### Hey! The Camel route runs!  ###");

            
            }
        });

        // start the route and let it do its work
        context.start();
        Thread.sleep(10000);

        // stop the CamelContext
        context.stop();
    }
}