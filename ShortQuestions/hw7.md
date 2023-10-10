**********************************
Q1. See ShortQuestions/annotations.md
**********************************
Q2. Explain how the below annotations specify the table in database?

        @Column(columnDefinition = "varchar(255) default 'John Snow'")
        private String name;
        @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
        private String studentName;

@Column(columnDefinition = "varchar(255) default 'John Snow'"): 
This annotation specifies that `name` column would accept 255 length char and its default value would be "John Snow". (Winter's comming)

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false):
This annotation specifies that studentName is mapped to a database column STUDENT_NAME accept an input length maximum of 50 and cannot be null, can be duplicated. 
**********************************
Q3. What is the default column names of the table in database for  @Column ?

        @Column
        private String firstName;
        @Column
        private String operatingSystem;
The default column name in the database would be assumed to be "firstName" and "operatingSystem" because it matches the name of the field.
**********************************
Q4. What are the layers in springboot application? what is the role of each layer?
Presentation Layer <-> Business Layer <-> Persistence Layer <-> Database

1. Presentation Layer: This layer handles HTTP requests and serves as the entry point to your application. 
Controllers receive incoming requests, process them, and return appropriate responses. Controllers are responsible for handling user interactions, validation, and controlling the flow of the application.
2. Business Layer: The service layer contains the business logic of your application. Services are responsible for processing data, applying business rules, and interacting with the data access layer.
3. Persistence Layer: This layer is responsible for interacting with the database or other data sources. It provides methods for creating, reading, updating, and deleting data from the underlying data store.
4. Database: This layer defines the data structure and represents the domain model.
   Entities or domain objects are typically POJOs (Plain Old Java Objects) that map to database tables.
   These objects encapsulate the data and may include business logic related to the data.
**********************************
Q5. Describe the flow in all of layers if an API is called by Postman.

1. Presentation Layer (Controller): 
   1. Postman sends an HTTP request (e.g., POST, GET, PUT, DELETE) to a specific endpoint of your Spring Boot application.
   2. The Spring Boot application's controller, which is responsible for handling HTTP requests, receives and processes the incoming request.
   3. The controller method (annotated with @RequestMapping, @GetMapping, @PostMapping, etc.) extracts data from the HTTP request (e.g., path variables, query parameters, request body) and forwards it to the service layer.


      {
      "title":"h",
      "content":"h1",
      "description":"h2"
      }
2. Service Layer (Business Layer): The service method, which is invoked by the controller, processes the data received from the controller. The service layer prepares data for persistence (if necessary) or performs any other required operations.
3. DAO: The data access layer contains repository or DAO (Data Access Object) interfaces or classes responsible for database operations.
   The service layer calls methods on these repository interfaces to perform CRUD (Create, Read, Update, Delete) operations or custom database queries.
4. Data Layer (Entity/Model): The data layer defines the structure of data entities (also known as domain objects) used in the application.
   Data objects may be transformed between entity objects and DTOs (Data Transfer Objects) for data exchange between layers.
5. HTTP Response: Receive a response. Postman receives the HTTP response from the Spring Boot application and displays the response body and other information.
**********************************
Q6. What is the application.properties? do you know application.yml?

application.properties : It contains key-value pairs, 
where keys represent configuration properties and values represent their corresponding values. 
These properties are used to configure various aspects of your Spring Boot application, 
such as database connections, server port, logging levels, and more.

        # Database Configuration
        spring.datasource.url=jdbc:mysql://localhost:3306/mydb
        spring.datasource.username=myuser
        spring.datasource.password=mypassword
        
        # Server Configuration
        server.port=8080
        
        # Logging Configuration
        logging.level.root=INFO
        logging.file=myapp.log

application.yml: yml, another format. Considered more human-readable and less verbose than properties files.

        # Database Configuration
        spring:
        datasource:
        url: jdbc:mysql://localhost:3306/mydb
        username: myuser
        password: mypassword
        
        # Server Configuration
        server:
        port: 8080
        
        # Logging Configuration
        logging:
        level:
        root: INFO
        file: myapp.log
**********************************
Q7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to
MongoDB. 
See Coding/hw7/mongo-blog
**********************************


