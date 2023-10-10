2. Explain how the below annotations specify the table in database?
```text
it will initial a name column in the table, and set type to varchar with default value John snow
it will map to the STUDENT_NAME column, and set it the length to 50, nonnullable
```
3:What is the default column names of the table in database for  @Column
```text


use spring default name strategy, it will convert to the snake case
```

4:What are the layers in springboot application? what is the role of each layer?
```text
View Layer: JSP
Controller: handling request
Business Service Layer: Business Logic
Data Repository Layer: Storage Logic
Domain Layer: Model
```

5: Describe the flow in all of the layers if an API is called by Postman.
```text


Embeded Tomcat will listen to a port and when request come in, it will start a servlet, 
and go through a chain of filters, and invoke the controller bean, the controller bean will call the service bean
to prepare the response, the service layer might call dependency like mysql and use persistent layer to 
do the database work, other tools like hibernate and mybatis or redis will do the database work
```
6: What is the application.properties? do you know application.yml
```text


the spring will use it as configuration file, application yml use yml format, which supports extra functionality like prefix

```

7: 
