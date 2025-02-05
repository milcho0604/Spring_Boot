package tobyspring.config.autoConfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.config.MyAutoConfiguration;

//@Configuration // MetaAnnotation으로 class를 가지고 있음
@MyAutoConfiguration
public class TomcatWebServerConfig {
    // Tomcat 구성 Bean
    @Bean
    public ServletWebServerFactory servletWebServerFactory(){
        return new TomcatServletWebServerFactory();
    }
}