1.  List all of the annotations you learned from class and homework to annotaitons.md

    > In /hw42/annotations.md

2.  Type the Comment feature for the class project. 
   
    https://github.com/TAIsRich/springboot-redbook/blob/06_mapper-exception/src/main/java/com/chuwa/redbook/controller/CommentController.java

    > In Coding/redbook-blog
    
3.  In postman, call of the APIs in PostController and CommentController.

    > In Coding/hw42/hw42P3 

4.  what is JPA? and what is Hibernate?
   
    > JPA: JPA use JDBC to CRUD database, and transfer result from database to Java Entities; 
    > Hibernate: JPA is a standard of ORM, and hibernate is a framework to do that. 

5.  What is Hiraki? what is the benefits of connection pool?

    > Hiraki is a pool for JPA to CRUD database by multi-thread. In general, destroy or create a thread is very consuming, by using the connection pool (Hiraki) it can become multiple use and efficient. 

6.  What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.

    > @OneToMany. The owning class can hold many other object.
    > @ManyToOne. The owning class can only match to one object.
    > @ManyToMany. The owning class can match to multiple objects.
    ```Java
    class Post {
        @ManyToOne(mappedBy = "post")
        private Set<Comment> comments; 
    }

    class Comment {
        @ManyToOne(mappedBy = "comment")
        @JoinColumn(name = "post_id")
        private Post post; 
    }

    class Class {
        @ManyToMany()
        @MappedBy(name = "classes")
        private Set<Student> students; 
    }

    class Student {
        @ManyToMany()
        @JoinCoumn(...)
        private List<Class> classes; 
    }

    ```

7. What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

    > all the change for the object (owning attribute) will be reflected to this. if orphanRemoval is true, meaning that if the owner doesn't need it, it will be removed. 
    > Persist: saved
    > Merge: merged
    > refresh: updated 
    > Remove: removed 
    > Detach: detached 
    > All: all operations. 

8.  What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

    > If the attribute/ variable not been used, it will not be updated, for Lazy. For EAGER, it will be updated if things changed. 

9.  What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

    > Basic operation like `find,By,And,Or,Between,IsNull,IsNotNull,...` with attributes in the database; 
    > You can implement the method by yourself but not recommended. 
    > Example like `findByLastnameAndFirstname`  

10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
    
    > Done, In Coding/redbook-blog/src/main/DAO/PostRepository.java 
    
11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.
12. (Optional) use JDBC to read the data from database.
13. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.
    > Done, In Coding/redbook/blog/src/main/DAO/PostRepositoryJPQL.java 

14. What is JPQL?
    > It is a kind of QL, similar but also use OOP. By `@Query("xxxxx")` as Annotation of function. 

15. What is @NamedQuery and @NamedQueries?

    > Another way to write JPQL. And can be used by the entityManager. 

16. What is @Query? In which Interface we write the sql or JPQL?

    > `@Query` an annotation for entity to have certain functions, in the entity, you write sql or JPQL. 

17.  What is HQL and Criteria Queries?

     > another SQL can be writen. 

18. What is EnityManager?

    > a mutlithreading pool to execute namedquery. 

19. What is SessionFactory and Session?

    > another way to write sql with features to run or rollback the sql. 

20. What is Transaction? how to manage your transaction?

    > Use annotation `@Transaction` if anything in that throws exception, will rollback whole procedure. 

21. What is hibernate Caching?

    > A caching before DB, if multiple call recorded, it will direct return results. 

22. What is the difference between first-level cache and second-level cache?

    > First level is built-in, second one shall be set to record. 

23. How do you understand @Transactional? (不要clone，要自己抄写并测试  ,,-+6transactional，https://github.com/TAIsRich/tutorial-transaction)

    > Done. Coding/hw42/hw42P23 

24. Write a simple factory design patte

    > DOne. Coding/hw42/Factory