@override: 
重写

@overload: 
重载

@Autowired：
标记构造函数、字段或设置方法，以便通过Spring的依赖注入工具进行自动装配

@Controller：
表示一个类是一个“控制器”（例如，Web控制器）

@Entity：
标记一个类为JPA实体

@Component: Basic annotation to mark a Java class as a Spring component.

@Service: Specialized @Component for service classes.

@Repository: Specialized @Component for data access classes (e.g., DAOs).

@Controller: Specialized @Component for Spring MVC controller classes.

@Configuration: Indicates that the class has 

@Bean: Used inside @Configuration classes to instantiate, configure, and initialize a new object to be managed by the Spring IoC container.

@Component: Basic annotation to mark a Java class as a Spring component.

@Service: Specialized @Component for service classes.

@Repository: Specialized @Component for data access classes (e.g., DAOs).

@Controller: Specialized @Component for Spring MVC controller classes.

@Qualifier: Used in conjunction with @Autowired to specify which of multiple beans should be autowired.

@Value: Indicates a default value expression for the field or parameter.

@RequestMapping: Used to map web requests to Spring Controller methods.

@GetMapping, @PostMapping, @PutMapping, @DeleteMapping: Shortcut annotations for @RequestMapping with specific HTTP methods.

@ResponseBody: Indicates that the return value of a method should be used as the body of the response.

@PathVariable: Indicates that a method parameter should be bound to a URI template variable.

@RequestParam: Binds method parameters to query parameters.

@RestController: A specialized version of @Controller that assumes @ResponseBody semantics for every method.