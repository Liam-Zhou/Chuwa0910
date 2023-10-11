## Entity Annotations
- @Entity: defines that the class can be mapped to a database table.
- @Table: allows you to specify the details of the table that will be used to persist the entity in the database. The @Table annotation provides four attributes, allowing you to override the name of the table, its catalogue, and its schema, and enforce unique constraints on columns in the table.
- @Id: indicates that the member field corresponds to the primary key in the table.
- @GeneratedValue: automatically generates unique value for the field.
- @Column: associate the field member with the specified column in the table.
- @CreateTimestamp: sets the field value to the current timestamp when the entity is first saved.
- @UpdateTimestamp: sets the field value to the current timestamp whenever the entity is updated.

## Service Annotations
- @Service: it marks the class as a service that is responsible for some business logic. It allows the annotated class to be autodetected through classpath scanning which is performed by Spring framework upon application’s startup. That means Spring framework will find and create an instance of the service class, and put the object as a managed bean in the application context. Then the managed bean will be available for dependency injection in other components, such as via @Autowired field.

## Controller Annotations:
- @Controller: It’s used to mark a class as a web request handler. Spring framework scans such annotated classes for mapped methods and detects @RequestMapping annotations. 
- @RestController: It’s used to mark a class as a request handler for RESTful web application. It's a combination of @Controller and @ResponseBody, which tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
- @RequestMapping: The @RequestMapping annotation can be applied to class-level and/or method-level in a controller. The class-level annotation maps a specific request path or pattern onto a controller. You can then apply additional method-level annotations to make mappings more specific to handler methods.
- @GetMapping: It maps HTTP GET requests to a specific handler method in Spring controllers.
- @PostMapping: It maps specific URLs to handler methods allowing you to receive and process data submitted through POST requests.
- @PutMapping: It maps HTTP PUT requests to a specific handler method in Spring controllers.
- @DeleteMapping: It maps HTTP DELTE requests to a specific handler method in Spring controllers.
- @PathVariable: It maps path variables in the url to the method parameters.
- @RequestBody: It maps and deserializes a request body (e.g. JSON) into a java object.
