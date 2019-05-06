package org.test;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jws.WebService;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.ProxyBuilder;
import com.test.webservices.test.TestPortType;
import com.test.webservices.test.TestRequest;
import com.test.webservices.test.TestResponse;
import javax.annotation.Resource;
import org.apache.camel.ProducerTemplate;

@WebService(endpointInterface = "com.test.webservices.test.TestPortType", serviceName = "test")
public class ImplPortType implements TestPortType {

    //@Inject
    //private CamelContext context;

     @Resource(name = "java:jboss/camel/context/the-context")
    private CamelContext context;

    private TestPortType portType;

    @Override
    public TestResponse test(TestRequest testRequest) {

        ProducerTemplate producer = context.createProducerTemplate();
        TestResponse fromCamel = producer.requestBody("direct-vm:startTest", testRequest, TestResponse.class);
        System.out.println("### ImplPortType got a return Object from route! ###");
        return fromCamel;
    }

}
