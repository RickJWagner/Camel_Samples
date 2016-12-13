package camelapp2;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * 
 * README
 * This is a plain Java 'main' program that will start the Camel 'context' (that's like a container for Camel applications)
 * It adds a 'route', which tells Camel what we want to do.
 * It says 'Poll this directory, whatever you find there '.
 * The context dies out after 25 seconds because of the Maven argument.  You'll probably have to use 'Control-C' to kill the program after running it.
 *
 */




public class FilePoller {

    public static void main(String args[]) throws Exception {
    	
        // create CamelContext
        CamelContext context = new DefaultCamelContext();

        // add our route to the CamelContext
        context.addRoutes(new RouteBuilder() {
            public void configure() {
            	
            	// README  Change this directory to one on your computer
            	// README  After you start this program, drop a small file in that directory.
            	from("file:/home/rick/Junk/Camel/In")
                .log("### Here's what we start with:${body}  ###")
        		.marshal().base64()
                .log("### After transforming:${body}  ###");
                

            
            }
        });

        // start the route and let it do its work
        context.start();

    }
}