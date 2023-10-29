## Spring Annotation

- Dto

  - Relationship:
    - `@OneToMany`: define a one-to-many relationship between two entities. It's typically used when one entity can be associated with multiple instances of another entity.
    - `@ManyToOne`: define the many-to-one side of a one-to-many relationship.
    - `@ManyToMany`
  - Validation:
    - `@Valid`: validation of nested objects within an object. When applied to a field or method parameter of an object, it indicates that validation should be applied to the associated nested objects.
    - `@NotEmpty`
    - `@Size`: specify the size or length constraints for a field or parameter.
    - `@Email`: validate whether a given string represents a valid email address.

- Entity

  - `@NamedQuery`: is used to define a single named query within an entity class.
  - `@NamedQueries`: is used to define multiple named queries within an entity class.

- Dao (Repository)

  - `@Transactional`: The annotated method should be executed within a transaction.
  - `@PersistenceContext`: inject an entity manager into a managed component, such as a managed bean or an EJB (Enterprise JavaBean).

    ```
    @Service
    public class MyService {
        @PersistenceContext
        private EntityManager entityManager;
    }
    ```

  - `@Query`: used to define custom queries in Spring Data JPA
  - `@Param`: used to map method parameters to named parameters in a JPQL query defined with `@Query`

    ```
    @Query("SELECT u FROM User u WHERE u.username = :name")
    User findByUsername(@Param("name") String username);
    ```
