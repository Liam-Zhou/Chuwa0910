##### 2.  explain how the below annotaitons specify the table in database?
This table got a column named "name", with varchar(255) as the variable type and length up to 255, and a default value "John Snow".
Another column named "STUDENT_NAME", length up to 50, could not bt null, and does not need to be unique.

##### 3.  What is the default column names of the table in database for  @Column ?
The variable name that used this annotation.

##### 4.  What are the layers in springboot application? what is the role of each layer?
Presentation Layer: Authentication, JSON Translation
Business Layer: Business Logic, Validation, Authorisation
Persistence Layer: Storage Logic
Database: Actual Database

##### 5.  Describe the flow in all of the layers if an API is called by Postman.
Client send HTTPS request to controller, then controller call Service Layer to operate the corresponding logic operations. Connect to database and init corresponding model if necessary.

##### 6.  What is the application.properties? do you know application.yml?
application.properties is a properties file for configuration settings, using key&value pairs.
application.yml is a YAML file for configuration settings, using indentation and colons for structure.
