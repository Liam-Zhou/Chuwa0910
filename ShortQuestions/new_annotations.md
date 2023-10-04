@QueryMapping
are often created in projects to provide custom behavior for queries in a data access layer, but their specific meaning and usage would depend on how they are implemented in your codebase.

@MutationMapping is not a standard Spring Boot annotation. It might be a custom annotation in your project used to map or define mutation operations. Mutations in the context of GraphQL typically represent operations that modify data on the server.

@CreationTimestamp: This annotation is typically used in Spring Boot projects that use the Hibernate framework for Object-Relational Mapping (ORM). When applied to a field in an entity class, it automatically sets the field's value to the timestamp of when the entity was created when the entity is saved to the database. This is useful for tracking when a particular record was created.

@UpdateTimestamp is also used in Hibernate-based Spring Boot projects. When applied to a field in an entity class, it automatically updates the field's value with the timestamp of when the entity was last updated when the entity is saved or updated in the database. This is useful for tracking the last modification timestamp of a record.


