package org.wildfly.camel.examples.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebService(serviceName="fetchdate", endpointInterface = "org.wildfly.camel.examples.cxf.DateService")
public class DateServiceImpl {

    @WebMethod(operationName = "fetchdate")
    public String fetchdate(@WebParam(name = "causetrouble") String causetrouble){

            if ("Y".equals(causetrouble)){
                int x = 0;
                int y = 0;
                int blowup = x / y;
            }
            
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            return dateFormat.format(date);
    }
}
