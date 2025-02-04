package tobyspring.helloboot;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

public class HellobootApplication {

    public static void main(String[] args) {
        GenericWebApplicationContext genericApplicationContext = new GenericWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();
                ServletWebServerFactory servletWebServerFactory = new TomcatServletWebServerFactory();
                WebServer webServer = servletWebServerFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet",
                                    new DispatcherServlet(this)) // this로 하는 이유: 확장하고자 하는 클래스 내부에서 참조하니 자기 자신을 참조
                            .addMapping("/*");
                });
                webServer.start();
            }
        };

        genericApplicationContext.registerBean(HelloController.class); // class 정보만 넘김
        genericApplicationContext.registerBean(SimpleHelloService.class); // class 정보만 넘김
        genericApplicationContext.refresh();



    }

}
