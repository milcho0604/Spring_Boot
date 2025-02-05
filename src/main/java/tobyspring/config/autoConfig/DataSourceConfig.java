package tobyspring.config.autoConfig;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tobyspring.config.ConditionalMyOnClass;
import tobyspring.config.EnableMyConfigurationProperties;
import tobyspring.config.MyAutoConfiguration;

import javax.sql.DataSource;
import java.sql.Driver;


@MyAutoConfiguration
@EnableTransactionManagement
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties.class)
public class DataSourceConfig {

    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    DataSource hikariDataSource(MyDataSourceProperties properties){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setPassword(properties.getPassword());
        dataSource.setUsername(properties.getUsername());

        return dataSource;
    }
    @Bean
    @ConditionalOnMissingBean // 위 hikari가 없으면 아래 DB에 연결
    DataSource dataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
        dataSource.setUrl(properties.getUrl());
        dataSource.setPassword(properties.getPassword());
        dataSource.setUsername(properties.getUsername());

        return dataSource;
    }

    @Bean
    @ConditionalOnMissingBean // 위 hikari가 없으면 아래 DB에 연결
    @ConditionalOnSingleCandidate(DataSource.class)
    JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean
    @ConditionalOnMissingBean // 위 hikari가 없으면 아래 DB에 연결
    @ConditionalOnSingleCandidate(DataSource.class)
    JdbcTransactionManager jdbcTransactionManager(DataSource dataSource){
        return new JdbcTransactionManager(dataSource);
    }
}
