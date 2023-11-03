2. explain how the below annotaitons specify the table in database?<br>
   @Column(columnDefinition = "varchar(255) default 'John Snow'")<br>
   private String name;<br>
   @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)<br>
   private String studentName;<br>
> @Column is used to specify the properties of thr column in the database table.<br>
> columnDefinition specifies the SQL definition of the column. In this case, it specifies that the name column should be of type varchar(255) and have a default value of 'John Snow'.<br>
> name attribute specifies the name of the database column. <br>
length attribute specifies the maximum length of the column.<br>
nullable attribute indicates whether the column can contain null values. <br>
unique attribute indicates whether the values in the column must be unique.<br>
3. What is the default column names of the table in database for @Column ?
> the default column name in the database is derived from the name of the field
4. What are the layers in springboot application? what is the role of each layer?
> Controller (Presentation Layer):<br>
Handles HTTP requests and manages user interactions.<br>
Service Layer:<br>
Contains business logic and orchestrates application functionality.<br>
Repository Layer (Data Access):<br>
Interacts with databases or data sources, performs CRUD operations.<br>
Entity Layer:<br>
Defines data models (Entities) and their relationships.<br>

5. Describe the flow in all of the layers if an API is called by Postman.
> User Interaction (Postman Client):<br>
User creates and sends an HTTP request in Postman, specifying method, URL, headers, and body.<br>
Request Processing (Server-Side):<br>
API request is received by the server, which routes it to the application layer.<br>
Business Logic (Server-Side):<br>
Application layer processes the request, interacts with databases or services, and generates a response.<br>
Response Handling (Postman Client):<br>
Postman receives and displays the API response to the user.<br>
> 
6. What is the application.properties? do you know application.yml?
> application.properties is a plain text file for configuring Spring Boot applications using key-value pairs.
<br>application.yml is an alternative configuration file using YAML syntax for the same purpose.
7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to
   MongoDB;
   https://www.mongodb.com/compatibility/spring-boot
