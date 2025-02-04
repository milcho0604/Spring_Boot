package tobyspring.helloboot;

import java.util.Objects;

public class HelloController {
    // http://localhost:8080/hello?name=milcho
    // http -v ":8080/hello?name=micho" (terminal)
    // http -v GET ":8080/hello?name=micho"

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name){
        return helloService.sayHello(Objects.requireNonNull(name)); // null이라면 예외 아니라면 값을 그대로 return
    }

}
