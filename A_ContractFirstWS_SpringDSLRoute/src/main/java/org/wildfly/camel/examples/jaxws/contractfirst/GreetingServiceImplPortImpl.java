
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.wildfly.camel.examples.jaxws.contractfirst;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.ProxyBuilder;


/**
 * This class was generated by Apache CXF 3.1.5.redhat-630310
 * 2018-02-15T14:16:00.013-06:00
 * Generated source version: 3.1.5.redhat-630310
 * 
 */

@javax.jws.WebService(
                      serviceName = "greeting",
                      portName = "GreetingServiceImplPort",
                      targetNamespace = "http://contractfirst.jaxws.examples.camel.wildfly.org/",
                      wsdlLocation = "file:/home/rick/Tools/A/Fuse6.3/jboss-eap-6.4/quickstarts/camel/A_ContractFirstWS_SpringDSLRoute/src/main/resources/wsdl/greet.wsdl",
                      endpointInterface = "org.wildfly.camel.examples.jaxws.contractfirst.Greeting")
                      
public class GreetingServiceImplPortImpl implements Greeting {

    private static final Logger LOG = Logger.getLogger(GreetingServiceImplPortImpl.class.getName());

    @Inject
    private CamelContext context;

    private Greeting greeting;


    /**
     * Configures a proxy for the direct:start endpoint
     */
    @PostConstruct
    public void initServiceProxy() throws Exception {
        greeting = new ProxyBuilder(context).endpoint("direct-vm:start").binding(false).build(Greeting.class);
    }


    

    /* (non-Javadoc)
     * @see org.wildfly.camel.examples.jaxws.contractfirst.Greeting#greetWithMessage(java.lang.String  message ,)java.lang.String  name )*
     */
    public java.lang.String greetWithMessage(java.lang.String message,java.lang.String name) { 
        LOG.info("Executing operation greetWithMessage");
        System.out.println(message);
        System.out.println(name);
        try {
            return greeting.greetWithMessage(message, name);
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}