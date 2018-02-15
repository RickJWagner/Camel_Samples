
Spring DSL Web Service example


--------------------

This example demonstrates using the [CamelProxy](http://camel.apache.org/using-camelproxy.html) to mimic the behaviour
of a Camel JAX-WS consumer. This is an alternative to using CXF consumers **which are not currently supported by JBoss Fuse on EAP**.


Running the example
-------------------

To run the example.

1. Start the application server in standalone mode `${JBOSS_HOME}/bin/standalone.sh -c standalone-full.xml`
2. Build and deploy the project.  
   - un-comment the line in pom.xml that controls the source generation plug-in, run 'mvn clean package' once to genearate source
   - you can now copy the generated source to the /src directory for manipulation of the contract-first web service
3. Deploy the project and browse to localhost:8080/spring_dsl_ws/

You should see a page titled 'Send A Greeting'. This UI enables us to interact with the test 'greeting' web service which will have also been
started. 



Web UI
------

Browse to localhost:8080/spring_dsl_ws/

From the 'Send A Greeting' web form, enter a 'message' and 'name' into the text fields and press the 'send' button. You'll then
see the information you entered combined to display a greeting on the UI.

So what just happened there?

`JaxwsServlet` handles the POST request from the web UI. It retrieves the message and name form parameter values and sends them to the
greeting web service. If both 'message' and 'name' values are present then the `greetWithMessage` method is invoked. Otherwise the `greet` method is invoked.

When the service method is invoked the `CamelProxy` results in the `direct-vm:start` route as defined in the Spring DSL Camel definition. 
