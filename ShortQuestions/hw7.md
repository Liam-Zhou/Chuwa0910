### 1.Explain how the below annotations specify the table in database?

```
@Column(columnDefinition = "varchar(255) default 'John Snow' ")
private String name ;

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```


The @Column annotation can be used to specify the table in database by using the name property. If the name property is not specified, the column name will be inferred from the property name.

In the first example, the columnDefinition property is used to specify the column definition in the database. The columnDefinition property can be used to specify the data type, length, and other constraints for the column. In this case, the columnDefinition property specifies that the name column is a varchar(255) column with a default value of John Snow.

In the second example, the name property is used to specify the column name in the database. The length property is used to specify the maximum length of the column. The nullable property is used to specify whether the column can be null. The unique property is used to specify whether the column must be unique. In this case, the STUDENT_NAME column is a varchar(50) column
that cannot be null and must be unique.

### 2. What is the default column names of the table in database for @Column?
```
@Column
private String firstName;
@Column
private String operatingSystem;
```
If you use the @Column annotation without specifying a name attribute, the default column name is derived from the field name. So, the default column names in the database table would be firstName and operatingSystem, respectively.

### 3. What are the layers in the springboot application ? what is the role of each layer?


Spring Boot applications typically follow a layered architecture, with each layer responsible for a specific task. The four layers in a Spring Boot application are:

* Presentation Layer: This layer is responsible for handling user interactions and displaying data. It typically consists of controllers, views, and templates.
* Business Layer: This layer contains the core business logic of the application. It is responsible for validating and processing data, and performing business operations.
* Persistence Layer: This layer is responsible for storing and retrieving data from a database. It typically consists of repositories and data access objects (DAOs).
* Database Layer: This layer contains the actual database, such as MySQL, PostgreSQL, or Oracle.
  
The layers are typically arranged in a hierarchy, with the presentation layer at the top and the database layer at the bottom. Each layer communicates with the layer below it, but not the layers above it.

Here is a brief overview of the role of each layer in a Spring Boot application:

Presentation Layer:

* Handles user interactions, such as HTTP requests and form submissions
Validates user input
* Displays data to the user, such as HTML pages and JSON responses

Business Layer:

* Contains the core business logic of the application
* Validates and processes data
* Performs business operations, such as creating, reading, updating, and deleting data

Persistence Layer:

* Stores and retrieves data from a database
* Maps database tables to Java objects


Database Layer:

* The actual database, such as MySQL, PostgreSQL, or Oracle

### 4. Describe the flow in all of the layers if an API is called by Postman

Here is a high-level overview of the flow in all of the layers if an API is called by Postman:

<ol>
<li>Postman: The user sends an HTTP request to the API endpoint using Postman. The request can include a request body with data to be processed by the API. </li>
<li>Presentation Layer: The Spring Boot application receives the request and routes it to the appropriate controller.</li>
<li>Controller: The controller validates the request and converts the request body to Java objects.</li>
<li>Business Layer: The controller calls on the business layer to process the request and perform the desired operation.</li>
<li>Business Layer: The business layer validates the data and performs the desired operation, such as creating, reading, updating, or deleting data.</li>
<li>Persistence Layer: The business layer interacts with the persistence layer to store or retrieve data from the database.</li>
<li>Persistence Layer: The persistence layer stores or retrieves the data from the database.</li>
<li>Business Layer: The business layer returns the results of the operation to the controller.</li>
<li>Controller: The controller converts the results to a response body and returns the response to the client.</li>
<li>Postman: Postman receives the response and displays it to the user.</li>
</ol>

### 5. What is the application.properties ? do you know application.yml?

application.properties is a configuration file used by Spring Boot applications. It contains key-value pairs of properties that can be used to configure the application. For example, the application.properties file can be used to configure the database connection, logging settings, and application-specific properties.

application.yml is a YAML configuration file used by Spring Boot applications. It is a more modern and expressive alternative to the application.properties file. YAML is a human-readable data serialization language that is based on indentation and nesting. This makes YAML configuration files easier to read and maintain.
