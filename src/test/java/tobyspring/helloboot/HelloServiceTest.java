package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
//@Test
//@interface FastUnitTest{
//
//}
//
// @Test를 통해 단위 테스트가 가능
//@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
//@Test
//@interface UnitTest{
//
//}


public class HelloServiceTest {
    @Test
    void hellService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();

        String ret = simpleHelloService.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator(){
        HelloDecorator decorator = new HelloDecorator(name -> name);
        String ret = decorator.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("*Test*");
    }
}
