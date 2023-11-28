package kechen.hw7mangoblog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 telling Spring Boot not to attempt auto-configuration related to JDBC DataSource,
 which is unnecessary when you're working with MongoDB.
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Hw7MangoBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hw7MangoBlogApplication.class, args);
    }

}
