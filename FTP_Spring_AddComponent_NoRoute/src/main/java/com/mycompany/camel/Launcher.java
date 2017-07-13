package com.mycompany.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.component.file.remote.FtpComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
	
	private static String URI_GOOD1 = "ftp://admin@127.0.0.1:2121?password=admin";
	private static String URI_GOOD2 = "ftp://admin@127.0.0.1:2121/OtherDir?password=admin";
	private static String URI_BAD1 = "ftp://admin@127.0.0.1:2121/NonExistingDir?password=admin";

    public static void main(String... args) throws Exception {
    	new Launcher().launch();
    }
    	
        private void launch() {
        	ApplicationContext context = new ClassPathXmlApplicationContext("acontext.xml");
        	CamelContext camelContext = (CamelContext) context.getBean("myCamelContext");         
        	ConsumerTemplate consumerTemplate = camelContext.createConsumerTemplate();
        	camelContext.addComponent("ftp", new FtpComponent(camelContext));
          	Exchange resultExchange = consumerTemplate.receive(URI_GOOD1, 5000);
          	System.out.println("Got from FTP:" + resultExchange.getIn().toString());
	}

}
