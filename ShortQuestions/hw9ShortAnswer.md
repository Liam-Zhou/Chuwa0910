### 2. how do you debug?

1: use debugger to break the code line by line.
2: check debugging diary provided by yourself or teammembers.

### 3. What is DTO, VO, Payload, DO, model?

They all stand for how your object should be designed in the springboot project. You have to have an object storing all the features from the database, and use this to establish the busniess logic.

### 4. @JsonProperty
It is used for mapping Json property names to java fields.

### 5. what is JSON
Json(JavaScript Object Notation) is a lightweight data-interchange format that is easy for humans to read and write and easy for machines to parse and generate.

### 6. Starter dependencies
In springboot, you can add all kinds of dependencies to help building your applications. 
For example, web dependency, database dependency, test dependency.

### 7. @RequestMapping(value = "/users", method = RequestMethod.POST)
This is just another way of doing http request. Usually, i do this in this way:
```java
@RequestMapping("/restapi")

@PostMapping
public ResponseEntity<DTO> create(@ReauestBody DTO dto){
DTO response = service.createModel(DTO);
return new ResponseEntity<>(response, HTTPSTATUS.CREATED);
}

@GetMapping("/{id}")
public ResponseEntity<List<AuthorDTO>> getAuthorById(@PathVariable(name="id")long id){
DTO dto = service.getAuthorById(id);
return dto;
}

@PutMapping("/{id}")
public ResponseEntity<DTO> updateById(@PathVariable(name = "id") long id, @RequestBody DTO dto){
DTO response = service.createModel(DTO);
return new ResponseEntity<>(response, HTTPSTATUS.CREATED);
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deletById(@PathVariable(name = "id") long id){
service.deletebyid(id)
return new ResponseEntity<>("Deleted", HttpStatus.OK)
}
```

### 8. ResponseEntity
ResponseEntity is a Springboot Class that represents the http response, including the status code, the http headers, and the response body. 

### 9. Result Set
An interface that provides methods to retrieve and read the results returned by executing queries against a database. 

### 10. ORM framework: Object-Relational Mapping.
Map sql queries to objects, classes and methods, and the framework will then translates these high-level operations to sql queries and execute them.

### 12. Serialization
converting data object-a combination of code and data represented within a region of data storage-into a series of bytes that saves the state of the object in an easily transmittable form.
Deserialization: constructing a data structure or object from a series of bytes.

### 13. stream API calculating average of array.
```java
        int[] nums = {1, 2, 3, 4, 5, 6};
        OptionalDouble ans = Arrays.stream(nums).average();
        if(ans.isPresent()){
            System.out.println(ans.getAsDouble());
        }
        else{
            System.out.println("-1");
        }
```

### 14. 
