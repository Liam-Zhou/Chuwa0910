1.  create a file to list all of the annotaitons you learned and known, and explain the usage and how do you
    understand it. you need to update it when you learn a new annotation. Please organize those annotations
    well, like annotations used by entity, annotations used by controller.
        -File name: annotations.md
        -you'd better also list a code example under the annotations.


2.  explain how the below annotaitons specify the table in database?
    
    @Column(columnDefinition = "varchar(255) default 'John Snow'")
        private String name;
  
    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
        private String studentName;



3.  What is the default column names of the table in database for @Column ?
    @Column
    private String firstName;
    @Column
    private String operatingSystem;


4.  What are the layers in springboot application? what is the role of each layer?


5.  Describe the flow in all of the layers if an API is called by Postman.


6.  What is the application.properties? do you know application.yml?


7.  Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;
        -https://www.mongodb.com/compatibility/spring-boot




