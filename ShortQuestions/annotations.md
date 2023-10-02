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
