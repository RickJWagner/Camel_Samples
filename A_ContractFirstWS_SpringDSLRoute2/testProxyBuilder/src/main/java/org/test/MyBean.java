package org.test;

import com.test.webservices.test.TestResponse;

public class MyBean {

    public TestResponse makeResponse(){
        TestResponse ret = new TestResponse();
	ret.setOutputMessage("Output from the TestResponse maker!");
        System.out.println("### Bean returns: " + ret.toString() + " " + ret.getOutputMessage() + " ###");
	return ret;
   }

}
