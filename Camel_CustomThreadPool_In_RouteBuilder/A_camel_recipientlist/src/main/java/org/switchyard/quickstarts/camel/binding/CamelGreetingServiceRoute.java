package org.switchyard.quickstarts.camel.binding;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.camel.builder.RouteBuilder;

public class CamelGreetingServiceRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	
	ThreadPoolExecutor tpExecutor = new ThreadPoolExecutor(100, 100, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(2048));
	
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://GreetingService")
		.log("starting processing of file")
		.split().tokenize("\n", 1)
		  .setHeader("endpointsToBeTriggered",simple("direct:one,direct:two,direct:three,direct:four,direct:five,direct:six"))
		 .recipientList(header("endpointsToBeTriggered")).executorService(tpExecutor)
    	 .parallelProcessing()
    	.streaming()
		.log("Done with file");
		
		
		
		from("direct:one")
		.log("DIRECT ONE ");
		
		from("direct:two")
		.log("DIRECT TWO ");
		
		from("direct:three")
		.log("DIRECT THREE ");
		
		from("direct:four")
		.log("DIRECT FOUR ");
		
		from("direct:five")
		.log("DIRECT FIVE ");
		
		from("direct:six")
		.log("DIRECT SIX }");





		
	}

}
