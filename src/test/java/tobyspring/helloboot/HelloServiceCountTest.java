package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class HelloServiceCountTest {

    @Autowired
    HelloService helloService;
    @Autowired
    HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount(){

        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.sayHello("milcho");
            Assertions.assertThat(helloRepository.countOf("milcho")).isEqualTo(count);
        });
    }
}
