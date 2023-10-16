# Homework 7 (HW 40 - SpringBoot-Post)

## 1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.

    1. File name: annotations.md

    2. you'd better also list a code example under the annotations.

## 2. explain how the below annotaitons specify the table in database?

```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```

The column of "NAME" is by the type of varchar(255) and default value is 'John Snow'

```
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

The column name in database would be "STUDENT_NAME". And its length is 50 characters and it cannot be null but is duplicable.

## 3. What is the default column names of the table in database for @Column ?

Tips: By default Spring uses org.springframework.boot.orm.jpa.SpringNamingStrategy to generate table names. This is a very thin extension of org.hibernate.cfg.ImprovedNamingStrategy. The ImprovedNamingStrategy will convert CamelCase to SNAKE_CASE where as the EJB3NamingStrategy just uses the table name unchanged.
[By Source: https://stackoverflow.com/questions/25283198/spring-boot-jpa-column-name-annotation-ignored]

```
@Column
private String firstName;
```

first_name

```
@Column
private String operatingSystem;
```

operating_system

## 4. What are the layers in springboot application? what is the role of each layer?

- Presontation Layer
  - Authentication
  - JSON Translation
- Business Layer
  - Business Logic
  - Validation
  - Authorisation
- Persistence Layer
  - Storage Logic
- Database
  - Actual Database

## 5. Describe the flow in all of the layers if an API is called by Postman.

- Presentation Layer: Client <-- HTTPS request --> Controller
- Business Layer: Service <-- Dependency Injection --> Repository Class Extending CRUD Services
- Persistence Layer: JPA/Spring Data --> Database

## 6. What is the application.properties? do you know application.yml?

#### `application.properties`

Application Properties support us to work in different environments. Properties files are used to keep ‘N’ number of properties in a single file to run the application in a different environment. In Spring Boot, properties are kept in the application.properties file under the classpath.

#### `application.yml`

As well as Java properties files, we can also use YAML-based configuration files in our Spring Boot application. YAML is a convenient format for specifying hierarchical configuration data.

```
spring:
    datasource:
        password: password
        url: jdbc:h2:dev
        username: SA
```

## 7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;

1.  https://www.mongodb.com/compatibility/spring-boot
