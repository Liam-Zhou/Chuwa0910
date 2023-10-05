# HW7

### 2.
The first one specifies the "name" column in the table to have type varchar(255) and default value of "John Snow"\
The second one specifies that the "STUDENT_NAME" column in the table has max length of 50, cannot be null and must have unique values.

### 3.
The same as the field name in java.

### 4.
- Presentation Layer: handle request, translate JSON into java objects, authentication
- Business Layer: contains all the business logic and services. Responsible for validation and authorization.
- Persistence Layer: contains the database storage logic. Translate business object to database model.
- Database Layer: the actual database that stores all the data.

### 5.
Once an api call is sent, it firstly reaches the presentation layer where the controller will parse path parameters and request body (if any) and then call the corresponding service. By calling the service we reach the business layer where all he computation and processing needed happends. During the process, if we need to query/update/save the database, we will go to the persistent layer and call the corresponding CRUD methods in the repository classes. Finally, the persistent layer will translate those CRUD methods call to actual database operations, where we reach the database layer.

### 6.
application.properties is where the developer configure the settings or hyper parameters of Spring boot application. application.yml is a configuration file which is basically the same thing as application.properties. It has the advantage of more conveniently specifying hierarchical configuration data.

