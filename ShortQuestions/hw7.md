2.
the @Column annotation is used to configure the mapping relationship between entity class attributes and columns in a database table.
2.1
columnDefinition attribute: This attribute allows us to specify the SQL definition of the column directly within the annotation. In this example, the columnDefinition attribute value is "varchar(255) default 'John Snow'", which implies that the corresponding column in the database is of VARCHAR type with a length of 255, and its default value is 'John Snow'.
2.2
name attribute: This attribute specifies the column name in the database table. If it's not specified, the entity class attribute name is used by default. In this example, the column name in the database table is "STUDENT_NAME".
length attribute: This attribute specifies the length of the column. For character type columns, the length attribute specifies the maximum character length of the column. In this example, the length attribute value is 50, implying that the corresponding column in the database can contain a maximum of 50 characters.
nullable attribute: This attribute specifies whether the column can be null. In this example, the nullable attribute value is false, implying that the corresponding column in the database cannot be null.
unique attribute: This attribute specifies whether the values of the column must be unique. In this example, the unique attribute value is false, implying that the values in the corresponding column in the database can be duplicated.

3.
3.1
The default column name in the database would typically be firstName.
3.2
The default column name in the database would typically be operatingSystem.

4.
Model Layer:
Domain Model: Represents the business objects of your application, which contain both data and behavior.
Data Access Object (DAO): The DAO or Repository layer is responsible for interacting with the database to save, update, delete, and query data.
Service Layer: Contains the business logic of your application. This layer interacts with the DAOs to access the data and apply the necessary business rules.

View Layer:
This is the user interface of your application. In Spring Boot, this could be a web interface using Thymeleaf, JSP, or other templates, or it could be a RESTful API that returns JSON or XML data.

Controller Layer:
The controller layer is responsible for handling user input, working with the model to process the input and prepare the data, and then returning the appropriate view to the user.

Data Transfer Object (DTO): Objects used for transferring data between layers and/or the outside world while keeping separation of concerns.

Security Layer: Provides authentication and authorization services to ensure that users are who they claim to be and that they have the appropriate access rights.

Exception Handling Layer: Handles exceptions in a centralized or decentralized manner, ensuring that proper error messages are returned to the user and logged for auditing purposes.

Logging and Auditing Layer: Logs messages and audit trails to keep track of what operations are being performed on the system.

5.
Request Reception:
Postman sends an HTTP request to the Spring Boot application.
Spring Boot's embedded Tomcat server receives the request and dispatches it to the appropriate Controller based on the URL, HTTP method, and other factors.

Controller Layer:
The appropriate Controller method is invoked with the data from the request.
The Controller might validate the request data, and if valid, it delegates the processing to a Service.

Service Layer:
The Service layer contains the business logic. It processes the request data, enforcing business rules and computations.
If necessary, the Service layer will interact with the Data Access Object (DAO) or Repository layer to retrieve or persist data.

Repository (DAO) Layer:
The Repository interacts with the database to retrieve, update, or store data.
It returns the data back to the Service layer, which may further process it or transform it into a Data Transfer Object (DTO).

Back to Service Layer:
Any additional processing needed on the data from the repository is done.
The service layer then returns the necessary data back to the Controller.

Back to Controller Layer:
The Controller transforms the data into the appropriate HTTP response format, often translating the domain objects or DTOs into JSON or XML.
It sets the necessary HTTP status code and headers on the response.

Response Dispatch:
Spring Boot sends the response back to Postman.
Postman receives the HTTP response and displays it to the user.

6.
application.properties and application.yml are configuration files in Spring Boot applications where you can define custom properties or override default properties. They allow you to externalize configuration so that you can work with the same application code in different environments.

application.yml (YAML - YAML Ain't Markup Language):
YAML is a more human-readable and writable format compared to properties files.
It allows for hierarchical configurations, which can be a significant advantage in complex applications.
It’s an alternative to application.properties.



