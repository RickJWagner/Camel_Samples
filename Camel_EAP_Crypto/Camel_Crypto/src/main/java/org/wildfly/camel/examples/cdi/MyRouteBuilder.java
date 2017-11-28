package org.wildfly.camel.examples.cdi;

import java.security.Key;
import java.security.KeyStore;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.PropertyPlaceholderDelegateRegistry;
import org.apache.camel.model.dataformat.CryptoDataFormat;
import org.apache.camel.util.jsse.KeyStoreParameters;
import org.wildfly.extension.camel.CamelAware;

@Startup
@CamelAware
@ApplicationScoped
public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
    	
    	CryptoDataFormat crypto = new CryptoDataFormat();
    	crypto.setAlgorithm("DES");
    	crypto.setKeyRef("secretKey");
    	
    	from("direct:start")
    	.beanRef("helloBean","someMethod")
    	.log("After helloBean: ${body}")
    	.marshal(crypto)
    	.log("After marshal: ${body}")
    	.unmarshal(crypto)
    	.log("After unmarshal: ${body}")
    	.log("Done!");
    	
    }
}
