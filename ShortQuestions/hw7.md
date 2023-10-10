# hw7

1. find in `ShortQuestion/annotations.md`
2. First `@Column` defines a column with name of "name", type of "varchar(255)", and default to be "John Snow".  
    Second `@Column` defines a column with name of "STUDENT_NAME", type of "varchar(50)", cannot be null and can be identity
3. `firstName` -> `first_name`  
    `operatingSystem` -> `operating_system`
4. What are the layers in springboot application? what is the role of each layer?  
    - Presentation Layer (Controller): handles HTTP requests, interacts with clients, and manages the flow of control in the application.
    - Service Layer (Service, also called Business Layer): contains the business logic and acts as an intermediary between the controller and the data access layer.
    - Data Access Layer (Repository/DAO): responsible for interacting with the database or storage.
    
5. Describe the flow in all the layers if an API is called by Postman.  
    Controller handle the http requests and send the content to Service; Service receive the data and do business logic, and then send the command to DAO; DAO interact with database and finish the whole process.
6. What is the application.properties? do you know application.yml?  
   application.properties is a configuration file, that might contain the information about port, database, hibernate properties, etc.  
   application.yml is also the configuration file in YAML. Both can be used.
7. Create a Project, name it with mongo-blog.  
    Done. See `Coding/mongo-blog`.