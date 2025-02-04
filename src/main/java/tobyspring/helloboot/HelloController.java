package tobyspring.helloboot;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@MyComponent
@RequestMapping("/hello")
public class HelloController {
    // http://localhost:8080/hello?name=milcho
    // http -v ":8080/hello?name=micho" (terminal)
    // http -v GET ":8080/hello?name=micho"

    private final HelloService helloService;
    private final ApplicationContext applicationContext;

    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService = helloService;
        this.applicationContext = applicationContext;

        System.out.println(applicationContext);
    }

    @GetMapping
    @ResponseBody
    public String hello(String name){
        return helloService.sayHello(Objects.requireNonNull(name)); // null이라면 예외 아니라면 값을 그대로 return
    }
}
