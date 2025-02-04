package tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class HelloController {
    // http://localhost:8080/hello?name=milcho
    // http -v ":8080/hello?name=micho" (terminal)
    // http -v GET ":8080/hello?name=micho"

    public String hello(String name){
        return "Hello " + name;
    }


}
