package tobyspring.config.autoConfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration // MetaAnnotation으로 class를 가지고 있음
public class DispatcherServletConfig {
    // DispatcherServlet Bean
    @Bean
    public DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    }
}
