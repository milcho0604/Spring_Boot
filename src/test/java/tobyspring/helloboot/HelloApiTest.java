package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HelloApiTest {
    @Test
    void helloApi(){
        // http localhost:8080/hello?name=milcho
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res
                = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class, "milcho");

        // status code 200
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header(content type) text/plain
        Assertions.assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello milcho
        Assertions.assertThat(res.getBody()).isEqualTo("Hello milcho");
    }

    @Test
    void failHelloApi(){
        // http localhost:8080/hello?name=milcho
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res
                = rest.getForEntity("http://localhost:8080/hello?name=", String.class);

        // status code 200
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR); // 500
    }
}
