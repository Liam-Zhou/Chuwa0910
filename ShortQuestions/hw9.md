# hw9

1. List all of the new annotations to your [annotaitons.md](http://annotaitons.md/) and explain its role.

See the annotations.md
2. how do you do the debug?

Run the program to see the error exception of the terminal. See the log to locate and see the information of bug or payload. See the type of error and the line of it. If we cannot fix it, we could search in the google. Or else, use debug model, set a pointer in the line of error to see the variable when it runs.
3. What is DTO, VO, Payload, DO, model?

DTO: Data Transfer Object. It used to encapsulate the date from the domain object or database

VO: view Object, =payload, return to the front end

payload: hold the data

DO: data object, when we have a api which return the combined result of multiple entity. e.g. bank statement→user+payment+…

model/entity: a class which hold the data and  manupliate the data

4. What is @JsonProperty("description_yyds") ?

it is a Java annotation commonly used with the Jackson library. It's used to specify the name of a JSON property when serializing or deserializing an object.
5. do you know what is jackson?

transfer from java object to json or back to java object.

6. What is spring-boot-stater?

简化配置，avoid the pom.xml to be too large

7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

= `@PostMapping()`

8. What is ResponseEntity? why do we need it?

represents the entire HTTP response, including the status code, headers, and body. 

9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

It is is an interface that represents the result set of a database query.

10. What is the ORM framework?

Object-Relational Mapping

1. ObjectMapper
    
    from jackson library.
    
2. serialization
    
    jackson
    
    object → serializer: serialization
    
     deserializer → object: deserialization
    

13.