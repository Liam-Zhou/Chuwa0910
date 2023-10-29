# Annotations

## Configuration

* `@Configuration`
* `@Bean`


## Database

* `@Entity` show it is entity class, an annotation to represent a POJO. Meanwhile `@Entity` will require a primary key
  * `@Id` in front of the id in the entity. 
  * `@GeneratedValue` will generate id by project-self, it it is `GenerationType.IDENTITY` will generate key by databse. 
* `@Table({name})` it is to be added for MySQL database `{name}`
  * `@UniqueConstraints` signals different unique constraints other than primary key
  * `@Column` shows the attribute in table and mapping variables. 
* `@Document({name})` it is to be added for MongoDB database, to map to specific database `{name}`

* `OneToMany`
* `ManyToOne`
* `ManyToMany`
* `JoinCoulmn`

* Validation: `@Min(),@Max(),` and in Controller `@Valid` for parameter 
## DAO 

* `@Repository` used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.

* `@Transactional`

## Service 

* `@Service` The Spring @Service annotation is a stereotype annotation that marks a class as a service provider. Service providers are classes that implement business logic and may or may not access external resources, such as databases or web services. The @Service annotation tells Spring to automatically detect and configure the service provider class. 

## Controller 

* `@RestContoller` includes `@Contoller` and`@ResponseBody`, 
* `@RequestMapping` the annotation is used to map web requests to Spring Controller methods.

## Exception 

* `@ExceptionHandler`
* `@ControllerAdvice`