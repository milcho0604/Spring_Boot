package tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name){
        return "Hello" + name;
    }
    // http://localhost:8080/hello?name=milcho
    // http -v ":8080/hello?name=micho" (terminal)

}
