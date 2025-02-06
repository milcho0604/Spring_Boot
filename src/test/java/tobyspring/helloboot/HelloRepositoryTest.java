package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class HelloRepositoryTest {
    @Autowired
    HelloRepository helloRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate.update("DELETE FROM hello");
    }


    @Test
    void findHelloFailed(){
        Assertions.assertThat(helloRepository.findHello("milcho")).isNull();
    }

    @Test
    void increaseCount(){
        Assertions.assertThat(helloRepository.countOf("milcho")).isEqualTo(0);
        helloRepository.increaseCount("milcho");
        Assertions.assertThat(helloRepository.countOf("milcho")).isEqualTo(1);
        helloRepository.increaseCount("milcho");
        Assertions.assertThat(helloRepository.countOf("milcho")).isEqualTo(2);
    }


}
