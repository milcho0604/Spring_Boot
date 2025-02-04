package tobyspring.helloboot;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.io.IOException;

public class HellobootApplication {

    public static void main(String[] args) {
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        genericApplicationContext.registerBean(HelloController.class); // class 정보만 넘김
        genericApplicationContext.refresh();

        ServletWebServerFactory servletWebServerFactory = new TomcatServletWebServerFactory();
        WebServer webServer = servletWebServerFactory.getWebServer(servletContext -> {

//            HelloController helloController = new HelloController();
            servletContext.addServlet("frontController", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    // 인증, 보안, 다국어, 공통 기능 등을 frontController에서 처리
                    // -> ServletContainer의 기능을 frontController에게 위임
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())){
                        String name = req.getParameter("name"); // name 추출은 frontController의 역할

                        HelloController helloController = genericApplicationContext.getBean(HelloController.class);
                        String ret = helloController.hello(name); // return 값

//                        resp.setStatus(HttpStatus.OK.value()); // 상태 코드
                        resp.setContentType(MediaType.TEXT_PLAIN_VALUE); // Header
                        resp.getWriter().println(ret); // Body
                    } else if (req.getRequestURI().equals("/user")) {
                        //
                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value()); // 404 던짐
                    }

                }
            }).addMapping("/*"); // 모든 요청을 여기서 처리

        });
        webServer.start();

    }

}
