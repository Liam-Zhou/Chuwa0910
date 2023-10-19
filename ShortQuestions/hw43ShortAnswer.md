### 3.
Spring is a java web development framework. It provides built in beans or annotations to let you do database access, api design, or http request to build web applications. 
Springboot is the project built on top of the spring framework. Springboot provides 'Spring Initializr' to let you include some starter dependency.

### 4. IoC container and DI
IoC container is a component responsibile for creating and managing objects. Instead of explicitly calling the dependencies, the framework calls the application or manages its components.
Dependency Injection would inject dependencies into beans at runtime. Instead of benas creating their dependencies, they're "injected" into them. The annotation @Autowire defines where the dependency should be injected.

### 5. 
In a class file annotation, you can use @ComponentScan to specify the scope.
In the xml file, you use the <base-package="com.package'>. 

### 6. @ComponentScan
When specified in a class by @ComponentScan, spring would scan it's how package and register any class with '@Component', '@Service', '@Repository', '@Controller'.

### 7. How many ways to define a bean?
Class level: annotations like @Component, @Service, @Repository, @Controller, or @ControllerAdvice.
Method level: use @Bean in front of the method.
xml: <bean id="dataComponent" class="com.chuwa.springbasic.compoenets.impl.DataNucleus"></bean>

### 8.
Default Component name would be the class name but with the initial character changed to lower case.
Default bean name would just be the name of the method that declaares bean.

### 9. 

### 11. 3 Types of Beans Injection.
Constructor Injection: Inject the object dependencies within the object's constructor. This alwasy gets the dependencies before it's used and once the dependencies are set, they cannot be changed.
Setter injection: Inject through setter method.
Field Injection: Inject dependency explicitly by creating a new field.


