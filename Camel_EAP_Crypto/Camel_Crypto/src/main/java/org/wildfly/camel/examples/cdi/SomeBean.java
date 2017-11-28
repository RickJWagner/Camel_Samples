package org.wildfly.camel.examples.cdi;

import javax.inject.Named;

@Named("helloBean")
public class SomeBean {

    public String someMethod(String message) {
        return "Hello " + message;
    }
    
    public void printPayload(Object obj) {
    	System.out.println("Payload:" + obj.toString());
    }
}
