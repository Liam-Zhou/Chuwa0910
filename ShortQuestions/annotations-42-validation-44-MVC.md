@ExceptionHandler:is an annotation in the Spring Framework used to define methods that handle exceptions in a Spring application. When an exception occurs during the execution of a controller method, the method annotated with @ExceptionHandler is called to handle that specific type of exception. It allows you to centralize your exception handling logic in one place, improving code organization and reducing redundancy.

@ControllerAdvice:is an annotation in Spring MVC that allows you to define global exception handlers for your controllers. It is typically used in combination with @ExceptionHandler methods. When you annotate a class with @ControllerAdvice, it becomes a global controller advice that can be used to define exception handling methods for multiple controllers.<br>

@valid:is a Java Bean Validation (JSR-380) annotation that is often used in Spring applications. It is applied to method parameters in Spring MVC controllers to indicate that the framework should perform validation on those parameters.

@NotEmpty:is a validation constraint annotation used for indicating that a field or parameter's value must not be empty. It is often used in conjunction with @Valid for form validation in Spring applications.

@Email: is a validation constraint annotation used to ensure that a field or parameter's value is a valid email address format. It is commonly used in Spring applications for validating email addresses entered in forms or as method parameters.

@Min and @Max: Specifies minimum and maximum values for numeric fields.

@Size: is a validation constraint annotation that is used to specify the size or length constraints for a field or parameter. You can use it to ensure that a value's length falls within a specified range, whether for strings, collections, or arrays. In Spring applications, it can be applied along with @Valid for validating the size of input data.

@RestController: annotation in Spring is a specialized version of the @Controller annotation. It is used to indicate that a class is a RESTful controller, which means that the methods within the class handle HTTP requests and directly return the response data, typically in JSON format, to the client. In other words, it's commonly used for building RESTful web services in Spring.