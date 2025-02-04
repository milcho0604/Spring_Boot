package tobyspring.helloboot;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

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
        WebServer webServer = servletWebServerFactory.getWebServer();
        webServer.start();

    }

}
