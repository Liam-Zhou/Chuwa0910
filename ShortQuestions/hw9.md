# Homework 9 (Hw41-springboot-RUD)

## 1. List all of the new annotations to your annotaitons.md and explain its role.

## 2. how do you do the debug?

- Look into the console log
- Make a debug breakpoint in corresponding code line
- Compare the running variable value with expected one

## 3. What is DTO, VO, Payload, DO, model?

- DTO: Data Transfer Object - an object that carries data between processes
- VO: Value Object, is a special type of object that can hold values such as java.
- Payload: contains the actual data to be accessed or processed by the receiver. The payload typically contains the data that needs to be processed or manipulated by the server, such as a JSON or XML object, or sometimes binary data like images or videos.

## 4. What is @JsonProperty("description_yyds") (不会的话，课上问)?

@JsonProperty(name) annotation, is used to specify the property name in a JSON object when serializing or deserializing a Java object using the Jackson library. It is often used when the JSON property name is different from the field name in the Java object, or when the JSON property name is not in camelCase.

## 5. do you know what is jackson?

```
<dependency>
<groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.3</version>
    <scope>compile</scope>
</dependency>
```

Jackson is a solid and mature JSON serialization/deserialization library for Java. The ObjectMapper API provides a straightforward way to parse and generate JSON response objects with a lot of flexibility. Additionally, we prototyped the ObjectMapperBuilder class to create immutable instances of the ObjectMapper class. This article discussed the main features that make the library so popular.

## 6. What is spring-boot-stater?

### - a. what dependecies in the below starter? do you know any starters?

```
<dependency>
    <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Spring Boot Starter POMs are a set of convenient dependency descriptors that you can include in your application. You get a one-stop-shop for all the Spring and related technology that you need, without having to hunt through sample code and copy-paste loads of dependency descriptors.

- In the Spring Boot Framework, all the starters follow a similar naming pattern: spring-boot-starter-_, where _ denotes a particular type of application.
  - Web Starter
  - Test Starter
  - JPA Data Starter
  - Mail Starter

## 7. do you know `@RequestMapping(value = "/users", method = RequestMethod.POST)` ? could you list CRUD by this style?

It's a POST request annotation in SpringBoot framework.

- Create: `@RequestMapping(value = "/users", method = RequestMethod.POST)`
- Read: `@RequestMapping(value = "/users", method = RequestMethod.GET)`
- Update: `@RequestMapping(value = "/users", method = RequestMethod.PUT)`
- Delete: `@RequestMapping(value = "/users", method = RequestMethod.DELETE)`

## 8. What is ResponseEntity? why do we need it?

```
   new ResponseEntity<>(postResponse, HttpStatus.OK);
   new ResponseEntity<>(postResponse,
   HttpStatus.CREATED);
   ResponseEntity.ok(postService.getPostById(id));
```

ResponseEntity represents the whole HTTP response: status code, headers, and body. We can use it to fully configure the HTTP response, define different HTTP response codes for different situations.

## 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

Java ResultSet interface is a part of the java.sql package. It is one of the core components of the JDBC Framework. ResultSet Object is used to access query results retrieved from the relational databases.

```
//https://www.digitalocean.com/community/tutorials/java-resultset
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/empdb", "root", "root");
stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(query);
while (rs.next()) {
    Integer empId = rs.getInt(1);
    String firstName = rs.getString(2);
    String lastName = rs.getString(3);
    Date dob = rs.getDate(4);
    System.out.println("empId:" + empId);
    System.out.println("firstName:" + firstName);
    System.out.println("lastName:" + lastName);
    System.out.println("dob:" + dob);
    System.out.println("");
}
rs.close();
```

## 10. What is the ORM framework?

Object-relational mapping (ORM) is a way to align programming code with database structures. ORM uses metadata descriptors to create a layer between the programming language and a relational database.

## 11. Learn how to use ObjectMapper by this example.

    - a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-cor e/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java

```
FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
String s = objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree() // learn how to use it?
```

## 12. What is the serialization and desrialization?

- a. https://hazelcast.com/glossary/serialization/

Serialization means converting an object into a sequence of bytes, deserialization is exactly the opposite. In deserialization, an object is reconstructed back from the sequence of bytes. In Java, Serialization and deserialization play a great role in the transfer of data and saving it to a database or disk.

## 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

`Arrays.stream(array).average(arr).orElse(Double.NaN);`

## 14. 抄写，https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable, 你也可以像我一样分 branch 添加新代码。

## 15. (Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comment 你也可以像我一样分 branch 添加新代码。

## 16. (Optional)Try to write the CRUD api for a new application Cassandra-Blog

- a. spring 提供了相关 dependency,(https://start.spring.io/) i. Spring Data for Apache Cassandra
- b. Cassandra 十分流行，且面试问的多。
