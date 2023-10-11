2. explain how the below annotaitons specify the table in database?
   The described table features a column titled "name". This column employs a varchar(255) datatype, accommodating a length of up to 255 characters. It defaults to the value "John Snow". There's another column, labeled "STUDENT_NAME", which supports a maximum length of 50 characters. This column cannot be left empty and doesn't have a uniqueness constraint.
3. What is the default column names of the table in database for @Column ?
   It would be the variable that has been annotated with this particular annotation.
4. What are the layers in springboot application? what is the role of each layer?
* Presentation Layer: This layer handles authentication and the translation of JSON.
* Business Layer: This is where the business logic, validation, and authorization tasks take place.
* Persistence Layer: This layer manages storage logic.
* Database: Represents the actual database.

5. Describe the flow in all of the layers if an API is called by Postman.
   * An HTTPS request from the client is directed to the controller. Subsequently, the controller invokes the Service Layer to perform the relevant logical operations. If necessary, it establishes a connection with the database and initializes the appropriate model.
6. What is the application.properties? do you know application.yml?
   * application.properties acts as a configuration settings file, adopting a key-value pair structure. On the other hand, application.yml is a YAML file meant for configuration settings, relying on indentation and colons to define its structure.