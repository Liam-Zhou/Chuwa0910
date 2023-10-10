### 1.Explain how the below annotations specify the table in database?

```
@Column(columnDefinition = "varchar(255) default 'John Snow' ")
private String name ;

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```


The @Column annotation can be used to specify the table in database by using the name property. If the name property is not specified, the column name will be inferred from the property name.

In the first example, the columnDefinition property is used to specify the column definition in the database. The columnDefinition property can be used to specify the data type, length, and other constraints for the column. In this case, the columnDefinition property specifies that the name column is a varchar(255) column with a default value of John Snow.

In the second example, the name property is used to specify the column name in the database. The length property is used to specify the maximum length of the column. The nullable property is used to specify whether the column can be null. The unique property is used to specify whether the column must be unique. In this case, the STUDENT_NAME column is a varchar(50) column
that cannot be null and must be unique.
