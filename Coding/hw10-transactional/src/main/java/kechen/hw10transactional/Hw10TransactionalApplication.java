package kechen.hw10transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Hw10TransactionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hw10TransactionalApplication.class, args);
    }
}
