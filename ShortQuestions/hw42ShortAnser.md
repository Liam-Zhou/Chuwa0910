### 2. @Configuration & @Bean
@Configuration means a class can be used by the Spring IoC container as a source of bean definitions. Methods in @Configuration are marked with '@Bean'. Example: 
```java
@Configuration
@PropertySource("classpath:database.properties")
public class AppConfig {

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getProperty("db.driver"));
        ds.setUrl(env.getProperty("db.url"));
        ds.setUsername(env.getProperty("db.username"));
        ds.setPassword(env.getProperty("db.password"));
        return ds;
    }
}
```

### 3. Exception handling.

@ExceptionHandler. Method level, used to handle the specific exceptions and sending the custom responses to the client. 
@ControllerAdvice. Class level, it's itself a bean.
Create ErrorDetails Class, then create GlobalExceptionHandler Class, then test it using the postman clinet.


### 4. Valiation.
Validation allows developers to ensure the the request body an application receives meets certain criteria before processing.
You can just include validation in the dependency. Add the @Validation annotation before the @requestBody. And then you can check it in postman.

### 5. Actuator
It monitor and manage application health, metrics, info, etc.
