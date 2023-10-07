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
