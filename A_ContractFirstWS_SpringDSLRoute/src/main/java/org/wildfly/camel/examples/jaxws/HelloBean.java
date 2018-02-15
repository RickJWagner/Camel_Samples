package org.wildfly.camel.examples.jaxws;

public class HelloBean{


// Since HelloBean is called by a Camel Proxy, it's going to be passed an argument of type 'BeanInvocation'

    public String greetWithMessage(org.apache.camel.component.bean.BeanInvocation beanInvocation){
        String message = (String) beanInvocation.getArgs()[0];
        String name = (String) beanInvocation.getArgs()[1];
        return message + " " + name;
    }



}