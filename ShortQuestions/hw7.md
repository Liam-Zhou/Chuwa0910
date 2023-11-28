# hw7 - Ke Chen - Springboot_Post

## 1.create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
1.  File name: annotations.md
2.  you'd better also list a code example under the annotations.

**find in file: annotations.md**




## 2. explain how the below annotaitons specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```
define the name field mapping to column in database, and also set it as a varchar type with a length of 255 characters and a default value of 'John Snow'

```java
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

define the studentName field mappint to column named : STUDENT_NAME in database, limiting its length to 50 characters, making it non-nullable(this column cannot contain null values), and allowing non-unique values(values in this column do not have to be unique).




## 3. What is the default column names of the table in database for @Column ?

The default column name will apply a <u>camelCase to snake_case</u> conversion.

The specific naming convention or strategy for default column names can vary depending on the ORM framework configuration or the database system being used, but the default behavior often involves transforming the field names from camelCase to snake_case.

```
@Column
private String firstName;
```
The default column name in the database would be "firstName" or "first_name".

```
@Column
private String operatingSystem;
```
The default column name in the database would be "operatingSystem" or "operating_system".




## 4. What are the layers in springboot application? what is the role of each layer?

![springboot layers](../images/hw7/springboot%20layers.png)

1. Presentation Layer: Authentication, JSON Translation
2. Business Layer: Business Logic, Validation and Authorization
3. Persistence Layer: Storage Logic
4. Database: Actual Database





## 5. Describe the flow in all of the layers if an API is called by Postman.

![spring boot flow architecture](../images/hw7/spring%20boot%20flow%20architecture.png)
![spring boot flow2](../images/hw7/spring%20boot%20flow2.png)

1. postman sends an HTTP request to the controller(presentation) layer do authentication and JSON transfomation
2. the service method in bussiness layer was invoked by controller to do bussiness logic, validation and authorization
3. the service layer interacts with the persistence layer to perform CRUD operations
3. the database execute operations based on the queries or commands received from the persistence layer.
4. generated response moves through the layers in the reverse order of the request flow to client.




## 6. What is the application.properties? do you know application.yml?

**What is the application.properties?**

application.properties is <u>a text-based configuration file in key-value format</u>. 

  ```java
  # Database configuration
  spring.datasource.url = jdbc:mysql://localhost:3306/mydb
  spring.datasource.username = myuser
  spring.datasource.password = mypassword

  # Server configuration
  server.port = 8080
  ```

**What is the application.yml:**

application.yml is <u>a YAML (YAML Ain't Markup Language) configuration file that indentation and a colon (:) to separate keys and values</u>.


  ```java
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

**find in Coding files: hw7-mongo-blog**

https://www.mongodb.com/compatibility/spring-boot]


1. get started with spring initialize(spring web, spring data mongoDB):
![mongodb initialize](../images/hw7/mongodb%20initialize.png)

2. use the annotation @Document to specify the collection name that will be used by the model:
![@Document](../images/hw7/%40Document.png)

3. spring boot mongoDB API implementation(repository extends MongoRepositoy):
![repository extends MongoRepositoy](../images/hw7/repository%20extends%20MongoRepositoy.png)

4. write bussiness logic in controller:
![business logic](../images/hw7/business%20logic.png)

5. Configure MongoDB Connection Properties:
![Configure MongoDB Connection Properties](../images/hw7/Configure%20MongoDB%20Connection%20Properties.png)

6. connect to the mongodb and set the database: demo
![connect to the mongodb](../images/hw7/connect%20to%20the%20mongodb.png)

7. 运行项目前exclude jdbc dataSource
![运行项目前exclude jdbc dataSource](../images/hw7/%E8%BF%90%E8%A1%8C%E9%A1%B9%E7%9B%AE%E5%89%8Dexclude%20jdbc%20dataSource.png)

8. run the application
![run the application](../images/hw7/run%20the%20application.png)