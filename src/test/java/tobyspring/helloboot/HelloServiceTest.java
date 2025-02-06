package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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

//    HelloRepository helloRepository;

    @Test
    void hellService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService(new HelloRepository() {
            @Override
            public Hello findHello(String name) {
                return null;
            }

            @Override
            public void increaseCount(String name) {

            }
        });

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
