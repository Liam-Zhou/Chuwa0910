### 2.
```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
the first example maps the name variable(entity attribute) to a varchar(255) column in the database.
If no name is presented, it'll be John Snow mapped to the DB.

the second example maps the field to a column named "STUDENT_NAME" of length 50, can't be null and could
contains duplicate values.

### 3.
When the column name is not provided in the annotations, the database would just create a column
named as the provided field name.

### 4. Springboot layer
Model: This layer deals with the database. It contains business logic of entity variables. And We use this to map 
the entity to data from the database.

Controller: This is where the database connect to the front end. We wrote API to let the backend and front end
communicate with each other.

View: the front end part, usually the html web page.

### 5. when api is called by postman.
1. configure http request in Postman(get, post, put, delete, etc) with url endpoint.
   Postman will then send the request to the website.
2. The website will process the request and send a response and status code(200 for success, 404 for not found, etc)
   to the front end view layer.
3. the front end will then process the response json format and controller will convert it to entity using rest API.
4. Finally, the converted entity will be sent directly to the model layer database.

### 6.
For what i've done so far, application.properties is where you specified the database service connection.
you can connect your spring boot project to your local sql server. Username and passcode will be specified here.
