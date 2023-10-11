2. how do you do the debug?
    * Set breakpoints where required, initiate in debug mode, and then proceed step-wise, observing watch variables when deemed necessary.

3.  What is DTO, VO, Payload, DO, model?
    * DTO (Data Transfer Object): Facilitates data conveyance between different sections of a system, predominantly between the business logic and the presentation tier.
     *  VO (Value Object): Characterizes a value rather than an identifiable entity.
    *   Payload: Constitutes the core data transported in a message body, like JSON or XML in an HTTP transaction.
    * DO (Domain Object): Denotes an object epitomizing a fundamental entity of the application domain.
    *   Model: Signifies the data structures or entities formulated to signify and operate data within a system.
4. What is @JsonProperty("description_yyds") ?
   * It serves to map a particular Java class field to a named JSON property during the processes of serialization and deserialization.
5. do you know what is jackson?
   * It offers APIs to both generate (write) and parse (read) JSON.
6. What is spring-boot-stater?
* It's a package dependency that eases project initialization by furnishing a selection of dependencies, preset settings, and automated configuration for certain functionalities.
7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
* The mentioned is a creation representation.
8. What is ResponseEntity? why do we need it?
* In the Spring Framework, ResponseEntity embodies an HTTP response. It allows tailoring the feedback sent to the client while managing web petitions. This aids in combining the response status, headers, and body in a singular entity.

9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
* ResultSet is an interface symbolizing the result compilation of a database inquiry. The general flow involves establishing a database link, executing SQL queries to retrieve the ResultSet, and subsequently navigating through the rows to access and process data.
10. What is the ORM framework?
* An instrument streamlining the communication between an application written in Java or another object-oriented language and a relational database.

12. What is the serialization and desrialization?
* Serialization transmutes a data structure or object into a format (like binary, JSON, XML) suitable for storage or network transmission. Deserialization is its counterpart, converting the serialized format back to the original structure or object.****
13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24,
```java
double avg = Arrays.stream(array)
    .average()
    .orElse(0.0);
```
