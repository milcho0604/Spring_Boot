package tobyspring.helloboot;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import java.io.IOException;

//@SpringBootApplication
//public class HellobootApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(HellobootApplication.class, args);
//    }
//
//}

public class HellobootApplication {

    public static void main(String[] args) {
//        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
//        WebServer webServer = tomcatServletWebServerFactory.getWebServer();

        ServletWebServerFactory servletWebServerFactory = new TomcatServletWebServerFactory();
        WebServer webServer = servletWebServerFactory.getWebServer(servletContext -> {
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    resp.setStatus(200); // 상태 코드
                    resp.setHeader("Content Type", "text/plain"); // Header
                    resp.getWriter().println("Hello Servlet"); // Body
                }
            }).addMapping("/hello"); // "/hello"로 들어오는 요청을 여기서 처리함.

        });

        webServer.start();

    }

}
