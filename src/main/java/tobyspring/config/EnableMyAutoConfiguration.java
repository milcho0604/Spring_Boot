package tobyspring.config;

import org.springframework.context.annotation.Import;
import tobyspring.config.autoConfig.DispatcherServletConfig;
import tobyspring.config.autoConfig.TomcatWebServerConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DispatcherServletConfig.class, TomcatWebServerConfig.class}) // 구성 정보에 직접 추가하는 방식 Scan 대상은 아니지만, class 정보를 넘기면 ok
public @interface EnableMyAutoConfiguration {
}
