1. Create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. You need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
   
   1. File name: annotations.md
   2. You'd better also list a code example under the annotations.
 
2. Explain how the below annotations specify the table in database?
    ```
    @Column(columnDefinition = "varchar(255) default 'John Snow'")
    private String name;

    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String studentName; 
    ```
    
    1. ```@Column(columnDefinition = "varchar(255) default 'John Snow’”)```
       - Attribute: name
       - Column Type: varchar(255) - Specifies that the column will store string values with a maximum length of 255 characters.
       - Default Value: 'John Snow' - If a value for this column is not provided during the insertion of a new record, 'John Snow' will be set as the default value.
       - Column Name: It will use the attribute name name as the default column name.

    2. ```@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)```
       - Attribute: studentName
       - Column Name: STUDENT_NAME - The column in the database table will be named STUDENT_NAME.
       - Length: 50 - The maximum length of the string values that can be stored in this column.
       - Nullable: false - Indicates that the column cannot have NULL values; every record must have a value for this column.
       - Unique: false - Indicates that duplicate values can be stored in this column; there’s no uniqueness constraint on the values.
 
3. What is the default column names of the table in database for ```@Column```?
    ```
    @Column
    private String firstName;
 
    @Column
    private String operatingSystem;
    ```
    
    In the absence of the name attribute in the @Column annotation, the default column names in the database table are derived from the field names of the entity class. The field names are used as they are, without any modification. So the first default name is firstName, and the second is operatingSystem.
    
4. What are the layers in springboot application? What is the role of each layer?

    1. Controller Layer:

       - Role: Handles HTTP requests, and returns responses. It acts as an interface between the user and the application.
       - Key Elements:
         - Annotations: @Controller, @RestController
         - Functions: Mapping requests, sending responses.

    2. Service Layer:
      
       - Role: Contains business logic and service classes. It acts as a transaction boundary and handles business use cases.
       - Key Elements:
         - Annotations: @Service
         - Functions: Business logic execution, transaction management.
        
    3. Repository/DAO (Data Access Object) Layer:

       - Role: Communicates with the database, performs CRUD operations. It abstracts and encapsulates all access to the data source.
       - Key Elements:
         - Annotations: @Repository
         - Functions: Database queries, CRUD operations.

    4. Model/Entity Layer:

       - Role: Represents data structures, typically tables in a database. It contains fields, their relationships, and constraints.
       - Key Elements:
         - Annotations: @Entity
         - Functions: Mapping fields to database columns, relationships.

    5. DTO (Data Transfer Object):
       
       - Role: Transfers data between processes or between layers of an application. It is used to encapsulate data and transport it efficiently.
       - Functions: Holds data, data transformation, and transportation.

    6. Security Layer (optional but often essential):

       - Role: Handles security mechanisms, including authentication and authorization.
       - Key Elements:
         - Annotations/Classes: Various depending on the security implementation.
         - Functions: User verification, permission handling, security checks.

    7. Utility Classes/Beans:

       - Role: Provides supporting features like configuration, utilities, and common functions.
       - Key Elements:
         - Annotations: @Component, @Configuration, @Bean
         - Functions: Various utility and common features that support other layers.

    8. Testing Layer:
       
       - Role: Handles testing of the application, including unit testing, integration testing, etc.
       - Key Elements:
         - Annotations: @Test, @SpringBootTest, etc.
         - Functions: Testing application components, functionality, and features.

5. Describe the flow in all of the layers if an API is called by Postman?

    1. Request from Postman:
       
       A user sends an HTTP request using Postman to a specific endpoint URL.

    2. Controller Layer:
       
       - Request Handling: The controller layer receives the HTTP request. It has handler methods mapped to the endpoint URLs, so it picks the appropriate method to process the incoming request.
       - Input Validation: The request data (like path variables, request parameters, and request body) may be validated at this stage.
       - Method Invocation: The controller then invokes the corresponding service method, passing any required parameters.

    3. Service Layer:
       
       - Business Logic Execution: The service layer is responsible for executing the business logic associated with the request. It processes the input, executes algorithms, and performs calculations as needed.
       - Transaction Management: If the operation involves database transactions, the service ensures they are handled correctly, committing or rolling them back as necessary.

    4. Repository/DAO Layer:
       
       - Database Interaction: The DAO layer interacts with the database to execute CRUD operations. It uses prepared statements, queries, and updates to manipulate the data.
       - Data Retrieval: It retrieves the data from the database and converts it into the model/entity objects.

    5. Model/Entity Layer:
       
       Data Representation: This layer represents the data structures, and the retrieved data is populated into entity objects.

    6. Response Back to Controller:
       
       Data Transformation: If needed, data is transformed into DTOs (Data Transfer Objects) to send back as the response. DTOs may exclude sensitive or unnecessary information.

    7. Controller Layer Again:
       
       Setting Response: The controller prepares the HTTP response, including the status code, headers, and body (usually the DTOs).

    8. Response to Postman:
       
       - Send Response: The prepared response is sent back to Postman, where the user can view the results, including the status, headers, and response body.
       - Additional Steps (if applicable):
         - Error Handling: In case of an error at any layer, an exception is thrown and propagated up to the controller, which then prepares an error response.
         - Logging and Auditing: All the requests and responses can be logged at each step for auditing, debugging, and monitoring purposes.

    9. Security Layer (if applicable):
       
       - Request: The security layer intercepts the request to perform authentication and authorization before it reaches the controller.
       - Response: It can also modify or monitor the response being sent back to ensure security protocols are adhered to.

6. What is the application.properties? Do you know application.yml?

    1. application.properties
       
       application.properties is a file in Spring Boot applications used for configuring application settings, including database connection strings, server port, context path, and other application-level settings. It uses the key-value pair format for configuring properties.

       Example of application.properties:
       ```
       server.port=8080
       spring.datasource.url=jdbc:mysql://localhost:3306/mydb
       spring.datasource.username=root
       spring.datasource.password=root
       ```
       Here, server.port configures the port on which the application will run, and spring.datasource.* properties are used to configure the database connection details.

    2. application.yml
        
       application.yml serves the same purpose as application.properties but uses the YAML (Yet Another Markup Language) format, which can be more human-readable and supports hierarchical configurations.

       Example of application.yml:
       ```
       server:
         port: 8080

       spring:
         datasource:
           url: jdbc:mysql://localhost:3306/mydb
           username: root
           password: root
       ```

7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB. https://www.mongodb.com/compatibility/spring-boot