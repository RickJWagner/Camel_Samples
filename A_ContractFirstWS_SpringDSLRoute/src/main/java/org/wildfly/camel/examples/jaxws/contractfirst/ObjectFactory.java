
package org.wildfly.camel.examples.jaxws.contractfirst;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.wildfly.camel.examples.jaxws.contractfirst package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GreetWithMessage_QNAME = new QName("http://contractfirst.jaxws.examples.camel.wildfly.org/", "greetWithMessage");
    private final static QName _GreetWithMessageResponse_QNAME = new QName("http://contractfirst.jaxws.examples.camel.wildfly.org/", "greetWithMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.wildfly.camel.examples.jaxws.contractfirst
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GreetWithMessage }
     * 
     */
    public GreetWithMessage createGreetWithMessage() {
        return new GreetWithMessage();
    }

    /**
     * Create an instance of {@link GreetWithMessageResponse }
     * 
     */
    public GreetWithMessageResponse createGreetWithMessageResponse() {
        return new GreetWithMessageResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreetWithMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contractfirst.jaxws.examples.camel.wildfly.org/", name = "greetWithMessage")
    public JAXBElement<GreetWithMessage> createGreetWithMessage(GreetWithMessage value) {
        return new JAXBElement<GreetWithMessage>(_GreetWithMessage_QNAME, GreetWithMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreetWithMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contractfirst.jaxws.examples.camel.wildfly.org/", name = "greetWithMessageResponse")
    public JAXBElement<GreetWithMessageResponse> createGreetWithMessageResponse(GreetWithMessageResponse value) {
        return new JAXBElement<GreetWithMessageResponse>(_GreetWithMessageResponse_QNAME, GreetWithMessageResponse.class, null, value);
    }

}
