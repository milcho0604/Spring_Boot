package tobyspring.config.autoConfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import tobyspring.config.MyAutoConfiguration;

//@Configuration // MetaAnnotation으로 class를 가지고 있음
@MyAutoConfiguration
@Conditional(JettyWebServerConfig.JettyCondition.class)
public class JettyWebServerConfig {
    // Tomcat 구성 Bean
    @Bean("jettyWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory(){
        return new JettyServletWebServerFactory();
    }
    static class JettyCondition implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }
}