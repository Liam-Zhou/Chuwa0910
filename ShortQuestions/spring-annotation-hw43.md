## SpringBoot Annotations

- Define Beans

  - Class Level:
    - `@Component`: a class that is a Spring-managed component or a Spring bean
    - `@Service`
    - `@Repository`
    - `@Controller`
    - `@ControllerAdvice`: used to define a global exception handler for your Spring MVC application.
  - Method Level:
    - `@Bean`: declare a method as a producer of a bean managed by the Spring container.
    - `@Configuration`: used to indicate that a class is a configuration class, which defines bean definitions and their relationships.
    ```
    @Configuration
    public class AppConfig {
        @Bean
        public MyBean myBean() {
            return new MyBean();
        }
    }
    ```

- Configuration:

  - `@ComponentScan`: `@ComponentScan` is an annotation in the Spring Framework that specifies the base packages to scan for Spring-managed components, such as classes annotated with `@Component`, `@Service`, `@Repository`, and `@Controller`. It is often used in conjunction with the `@Configuration` annotation to enable component scanning in a Spring application.

  ```
  @ComponentScan(basePackages = "com.example")
  ```

  - `@EnableAutoConfiguration`: allow the application to add beans using classpath definitions
  - `@SpringBootApplication`: == `@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`

- Dependency Injection
  - `@Qualifier`: specify which specific bean should be injected into a particular field or method parameter.
  ```
  @Autowired
    @Qualifier("specificBean")
    private MyBean myBean;
  ```
  - `@Primary`: indicate a primary bean when there are multiple candidate beans of the same type that can be injected.
