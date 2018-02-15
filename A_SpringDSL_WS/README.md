
Spring DSL Web Service example


--------------------

This example demonstrates using the [CamelProxy](http://camel.apache.org/using-camelproxy.html) to mimic the behaviour
of a Camel JAX-WS consumer. This is an alternative to using CXF consumers **which are not currently supported by JBoss Fuse on EAP**.


Running the example
-------------------

To run the example.

1. Start the application server in standalone mode `${JBOSS_HOME}/bin/standalone.sh -c standalone-full.xml`
2. Build and deploy the project `mvn install -Pdeploy`
3. Browse to http://localhost:8080/spring_dsl_ws/jaxws

You should see a page titled 'Send A Greeting'. This UI enables us to interact with the test 'greeting' web service which will have also been
started. The service WSDL is available at http://localhost:8080/example-camel-jaxws/greeting?wsdl.


Web UI
------

Browse to http://localhost:8080/spring_dsl_ws/jaxws

From the 'Send A Greeting' web form, enter a 'message' and 'name' into the text fields and press the 'send' button. You'll then
see the information you entered combined to display a greeting on the UI.

So what just happened there?

`JaxwsServlet` handles the POST request from the web UI. It retrieves the message and name form parameter values and sends them to the
greeting web service. If both 'message' and 'name' values are present then the `greetWithMessage` method is invoked. 

When the service method is invoked the `CamelProxy` results in the `direct-vm:start` route within the Spring DSL Camel route running.

