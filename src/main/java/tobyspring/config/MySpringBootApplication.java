package tobyspring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Default 값은 class 컴파일된 class까지는 살아있지만, RunTime에는 사라짐 그래서 RunTime에도 유지되도록 RumTime으로 설정
@Target(ElementType.TYPE) // Type은 class, Enum 등이 들어감
@Configuration
@ComponentScan
@EnableMyAutoConfiguration
public @interface MySpringBootApplication {
}