@Autowired: Used for automatic dependency injection. It injects a bean by matching the data type of a variable with one of the beans in the application context.<br>

@Component:Indicates that a class is a Spring component and should be managed by the Spring container.<br>

@Service:Indicates that a class is a service component in a Spring application, typically used for business logic.<br>

@Repository: Indicates that a class is a data access component in a Spring application, often used for working with databases.<br>

@Controller: Marks a class as a controller in a Spring MVC web application. Controllers handle incoming HTTP requests and return responses.<br>

@ContollerAdvice: Used to define a global exception handler and to provide common model attributes to multiple controllers.<br>

@Bean:Declares a method that produces a bean to be managed by the Spring container.<br>

@ComponentScan:Scans for Spring components and services within a specific package and its sub-packages.<br>

@Resource:Used for dependency injection, similar to @Autowired, but is a standard Java EE annotation.<br>

@Inject:Another annotation for dependency injection, primarily used in the context of Java EE and CDI (Contexts and Dependency Injection).<br>