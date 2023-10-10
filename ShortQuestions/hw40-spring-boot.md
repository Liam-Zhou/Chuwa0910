### Explain how the below annotaitons specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

The @Column annotation in java, specifically when used in conjunction with JPA for database Mapping, allows you to specify
various attributes related to the corresponding database column. 

columnDefinition:
This attribute allows you to define the SQL data type and any additional constraints for the database column. 
In the example, columnDefinition = "varchar(255) default 'John Snow'" specifies that the name column will have a VARCHAR data type 
with a maximum length of 255 characters and a default value of 'John Snow'. 
This means that if we insert a record into the database without specifying a value for the name column, it will default to 'John Snow'.