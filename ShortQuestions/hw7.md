# hw7 - Ke Chen

## 1.create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
1.  File name: annotations.md
2.  you'd better also list a code example under the annotations.

see files: annotations.md

## 2. explain how the below annotaitons specify the table in database?
The annotations @Column typically used in Java Persistence API (JPA) or Hibernate <u>to specify how a Java class field maps to a database table column</u>. These annotations help define the database schema and provide additional information about how the data should be stored and retrieved(<u>it will generate the appropriate SQL schema for your database table</u>).

```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```
- This annotation is used to specify the column-level details for the name field.
- It defines a VARCHAR column with a maximum length of 255 characters and a default value of 'John Snow'.

```
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
- This annotation is used to specify the column-level details for the studentName field.
- The column will be named "STUDENT_NAME" in the database table.
- length=50 specifies that the maximum length of the VARCHAR column is 50 characters.
- nullable=false indicates that this column cannot contain null values
- unique=false specifies that the values in this column do not have to be unique.

## 3. What is the default column names of the table in database for  @Column ?
When you use the @Column annotation without specifying the name attribute, it will use the default column names based on the field names in your Java class. 

```
@Column
private String firstName;
```
The default column name in the database would be "firstName".

```
@Column
private String operatingSystem;
```
The default column name in the database would be "operatingSystem".

## 4. What are the layers in springboot application? what is the role of each layer?
see answer in Q5.

## 5. Describe the flow in all of the layers if an API is called by Postman.
### Presentation Layer (Controller): 表示层 Controller层
Postman sends an HTTP request to the API endpoint, which is handled by a specific controller method. (把http request交给controller处理).
(Controllers are responsible for processing user input, invoking service layer methods, and returning appropriate responses (usually in the form of JSON, HTML, or other data formats).)

The controller method <u>receives the HTTP request, extracts any parameters or data from the request, and may perform basic validation</u>.(接收http request，抽取parameters并且进行简单的验证)

It then <u>invokes the appropriate service method</u>(唤醒service层，进行核心业务逻辑处理) to handle the request, passing along any necessary data.

### Service Layer (Service): 业务逻辑层
The service method, invoked by the controller, contains the application's core business logic.
It may <u>involve complex processing, data manipulation, validation, or coordination between multiple data access methods</u>（处理核心业务逻辑，数据操作，验证，并且和DAO层交互）.

The service layer communicates with the data access layer to retrieve or update data as needed(和DAO层交互，进行数据的读取和更新) .

### Data Access Layer (Repository or DAO): 数据层，DAO层
The service layer interacts with the data access layer to <u>perform CRUD operations on the database or other data sources.</u>（对数据库或者其他数据资源进行CRUD操作）
Data access methods defined in the repository or DAO are used to query, insert, update, or delete records in the database.

The data access layer converts database-specific exceptions into more generic exceptions that can be handled by the service layer.

Repositories or DAOs typically use technologies like JPA, Hibernate, JDBC, or other data access frameworks to communicate with the database.'

### Domain/Business Layer (Entity):
Role: The domain or business layer defines the core business objects and their relationships. It represents the application's data model.

Components: Entities are typically Java classes annotated with JPA annotations that describe the structure of the database tables.

The domain objects, which represent the structure of the database tables (entities), may be used by the data access layer and service layer. （保存数据库中的table(实例)，供DAO层和service层使用）
These objects hold the data retrieved from or sent to the database.

### Integration Layer (Optional):
It <u>manage the communication with external services or APIs</u>.(和其他external services和APIs的交互)
It may include REST client components or other connectors to interact with external systems.

Data from external services can be processed and integrated into the application's workflow.

### Configuration Layer (Configuration and Properties):
Application-specific configurations and properties are used throughout the application.
This layer <u>manages the configuration settings that determine how various components behave</u>.（管理configuration设定）
Configuration can be defined in configuration classes, property files, or environment variables.

### Security Layer (Security):
If the API requires authentication and authorization, the security layer <u>handles user authentication and access control.</u>（处理验证和访问权限）
Spring Security, for example, can authenticate users, check their roles and permissions, and enforce security policies.

### Presentation Layer (Controller - Response):
After the service layer has processed the request and obtained any necessary data, <u>the controller method prepares an HTTP response</u>.
<u>The response typically includes data (often in JSON format), status codes, and headers.
The response is sent back to the Postman client that made the API request.</u>

Postman (Client):
Postman receives the HTTP response from the Spring Boot application.
It displays the response data, status codes, and headers to the user, allowing them to inspect and analyze the API's behavior.

## 6. What is the application.properties? do you know application.yml?
- application.properties:
application.properties is <u>a text-based configuration file in key-value format</u>. 

It's a traditional way of configuring Spring Boot applications.
Properties are <u>defined using the key = value syntax</u>.

Example application.properties file:
```
# Database configuration
spring.datasource.url = jdbc:mysql://localhost:3306/mydb
spring.datasource.username = myuser
spring.datasource.password = mypassword

# Server configuration
server.port = 8080
```

- application.yml:
application.yml is <u>a YAML (YAML Ain't Markup Language) configuration file that provides a more human-readable format for configuration.</u>

Properties are <u>defined using indentation and a colon (:) to separate keys and values</u>.
It's often preferred for its readability and conciseness, especially for complex configurations.

Example application.yml file:
```
# Database configuration
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: myuser
    password: mypassword

# Server configuration
server:
  port: 8080
```

## 7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB

https://www.mongodb.com/compatibility/spring-boot]

see files: HW7-Q7 in Coding

Steps:
1. create a Maven project;
2. add dependencies to project's pom.xml file;
3. Create a configuration class: MongoConfig that specifies the MongoDB connection details;
4. Create a model class:  to represent your data model;
5. Create a Controller class: BlogPostController with a POST API endpoint to handle incoming blog post data and save it to MongoDB;
6. Create a repository interface that extends MongoRepository to perform MongoDB operations;
7. Run Application;
8. Test POST API;
Use a tool like Postman to send POST requests to your API endpoint (/api/posts) with JSON data representing a blog post

## 8. Help From Chatgpt
```
https://chat.openai.com/c/f27b2584-4ce5-4781-9963-8db043957f9c
```