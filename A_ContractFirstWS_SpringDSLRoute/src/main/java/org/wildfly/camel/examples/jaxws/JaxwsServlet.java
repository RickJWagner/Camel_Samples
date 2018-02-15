package org.wildfly.camel.examples.jaxws;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.URL;

import org.wildfly.camel.examples.jaxws.contractfirst.Greeting;

@SuppressWarnings("serial")
@WebServlet(name = "HttpServiceServlet", urlPatterns = { "/jaxws/*" }, loadOnStartup = 1)
public class JaxwsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        /**
         * Get message and name parameters sent on the POST request
         */
        String message = request.getParameter("message");
        String name = request.getParameter("name");

        /**
         * Create a JAX-WS client to invoke the greeting web service
         */
        URL wsdlLocation = new URL("http://localhost:8080/spring_dsl_ws/greeting?wsdl");
        QName serviceName = new QName("http://contractfirst.jaxws.examples.camel.wildfly.org/", "greeting");
        Service service = Service.create(wsdlLocation, serviceName);
        Greeting greetingService = service.getPort(Greeting.class);

        /**
         * Invoke the web service methods
         */
        String greeting;
        if(message != null && !message.isEmpty() && name != null && !name.isEmpty()) {
            greeting = greetingService.greetWithMessage(message, name);
        } else {
            greeting = "Hello, please use two arguments";
        }

        request.setAttribute("greeting", greeting);
        request.getRequestDispatcher("/greeting.jsp").forward(request, response);
    }
}
