### 1.	create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.

#### `Annotations used by Entities`

@Entity:

Usage: Marks a Java class as an entity, which means it is mapped to a database table.

Example:

```Java

@Entity
public class User {
    // Class definition
}
```

@Table:

Usage: Specifies the name of the database table to which the entity is mapped.

Example:

```Java
@Entity
@Table(name = "users")
public class User {
    // Class definition
}
```

@Id:

Usage: Specifies the primary key of an entity.

Example:

```Java
@Entity
public class User {
    @Id
    private Long id;
    // Other fields, getters, and setters
}
```

@GeneratedValue:

Usage: Provides the specification of generation strategies for the values of primary keys.

Example:

```Java
@Entity
public class User {
    @Id
    private Long id;
    // Other fields, getters, and setters
}
```

#### `Annotations used by Controllers`

@Controller:

Usage: Marks a class as a Spring MVC controller.

Example:

```
@Controller
public class MyController {
    // Controller methods
}
```

@RequestMapping:

Usage: Maps web requests to specific handler classes and/or handler methods.

Example:

```Java
@Controller
public class MyController {
    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
```

@RequestParam:

Usage: Used to extract query parameters from the URL.

Example:

```Java
@Controller
public class MyController {
    @RequestMapping("/greet")
    public String greet(@RequestParam("name") String name) {
        return "Hello, " + name + "!";
    }
}
```

@ResponseBody:
 
Usage: Indicates that the return value of a method should be serialized directly to the HTTP response body.

Example:

```Java
@Controller
public class MyController {
    @RequestMapping("/api/data")
    @ResponseBody
    public String getData() {
        return "Some data from the API";
    }
}
```

### 2 Explain the annotation

the @Column annotation is used to specify the details of a column in a database table. The @Column annotation is used to define the columns in a database table for the fields name and studentName.

1. #### @Column(columnDefinition = "varchar (225) default 'John Snow' ")
   
* Usage: This annotation is used to define the column in the database table for the name field.

* Attributes:

* columnDefinition: Specifies the SQL fragment that is used when generating the DDL (Data Definition Language) for the column.

Explanation:

* varchar(225): Specifies that the column is of variable character type with a maximum length of 225 characters.

* default 'John Snow': Specifies the default value for the column, which is set to 'John Snow' if no value is provided when inserting a new record.

In this case, the name field in the database table will be of type VARCHAR with a maximum length of 225 characters, and if no value is provided for the name field during insertion, it will default to 'John Snow'.


2. #### @Column(name = "STUDENT_NAME", length=50, nullable=false, unique=false)
   
* Usage: This annotation is used to define the column in the database table for the studentName field.
  
* Attributes:
  
* name: Specifies the name of the column in the database table.
  
* length: Specifies the maximum length of the column's value.
  
* nullable: Indicates whether the column can have a null value (true means it can be null, false means it cannot be null).
  
* unique: Indicates whether the values in the column must be unique across all records in the table.
  
* Explanation:
  
* name = "STUDENT_NAME": Specifies that the column in the database table is named "STUDENT_NAME".
  
* length = 50: Specifies that the maximum length of the studentName field is 50 characters.
  
* nullable = false: Specifies that the studentName field cannot be null, meaning a value must be provided during insertion.*

* unique = false: Specifies that the values in the studentName column are not required to be unique across all records in the table.
