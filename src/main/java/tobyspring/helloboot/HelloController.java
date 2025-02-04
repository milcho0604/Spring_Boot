package tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

public class HelloController {
    // http://localhost:8080/hello?name=milcho
    // http -v ":8080/hello?name=micho" (terminal)
    // http -v GET ":8080/hello?name=micho"

    public String hello(String name){
        SimpleHelloService helloService = new SimpleHelloService();

        return helloService.sayHello(Objects.requireNonNull(name)); // null이라면 예외 아니라면 값을 그대로 return
    }

//        if (name = null) throw

}
