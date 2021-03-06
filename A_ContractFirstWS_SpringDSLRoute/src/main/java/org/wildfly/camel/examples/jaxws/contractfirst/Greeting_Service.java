package org.wildfly.camel.examples.jaxws.contractfirst;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.5.redhat-630310
 * 2018-02-15T14:16:00.053-06:00
 * Generated source version: 3.1.5.redhat-630310
 * 
 */
@WebServiceClient(name = "greeting", 
                  wsdlLocation = "file:/home/rick/Tools/A/Fuse6.3/jboss-eap-6.4/quickstarts/camel/A_ContractFirstWS_SpringDSLRoute/src/main/resources/wsdl/greet.wsdl",
                  targetNamespace = "http://contractfirst.jaxws.examples.camel.wildfly.org/") 
public class Greeting_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://contractfirst.jaxws.examples.camel.wildfly.org/", "greeting");
    public final static QName GreetingServiceImplPort = new QName("http://contractfirst.jaxws.examples.camel.wildfly.org/", "GreetingServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/rick/Tools/A/Fuse6.3/jboss-eap-6.4/quickstarts/camel/A_ContractFirstWS_SpringDSLRoute/src/main/resources/wsdl/greet.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Greeting_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/home/rick/Tools/A/Fuse6.3/jboss-eap-6.4/quickstarts/camel/A_ContractFirstWS_SpringDSLRoute/src/main/resources/wsdl/greet.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public Greeting_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Greeting_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Greeting_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public Greeting_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public Greeting_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public Greeting_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns Greeting
     */
    @WebEndpoint(name = "GreetingServiceImplPort")
    public Greeting getGreetingServiceImplPort() {
        return super.getPort(GreetingServiceImplPort, Greeting.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Greeting
     */
    @WebEndpoint(name = "GreetingServiceImplPort")
    public Greeting getGreetingServiceImplPort(WebServiceFeature... features) {
        return super.getPort(GreetingServiceImplPort, Greeting.class, features);
    }

}
