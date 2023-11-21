package kechen.hw7mongoblog.repository;

import kechen.hw7mongoblog.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}

/**
 * In Spring Data MongoDB, the `PostRepository` interface extends the `MongoRepository` interface, providing CRUD (Create, Read, Update, Delete) operations for the `Post` entity.
 *
 * Let's break down the declaration:
 *
 * ```java
 * public interface PostRepository extends MongoRepository<Post, String> {
 * }
 * ```
 *
 * - `PostRepository`: This is an interface that acts as a repository for handling database operations related to the `Post` entity.
 *
 * - `extends MongoRepository<Post, String>`: This is where the `PostRepository` interface extends the `MongoRepository` interface provided by Spring Data MongoDB.
 *     - `Post` is the entity type that the repository manages, representing a MongoDB document. In this case, it's the `Post` class.
 *     - `String` represents the type of the identifier field (`id` in this case) of the `Post` entity.
 *
 * By extending `MongoRepository`, the `PostRepository` gains various built-in methods provided by Spring Data MongoDB, such as `save`, `findById`, `findAll`, `delete`, and more.
 * These methods can be used directly without needing to implement them manually.
 *
 * For instance:
 * - `save`: Saves an instance of `Post` into the MongoDB database.
 * - `findById`: Retrieves a `Post` by its ID.
 * - `findAll`: Retrieves all `Post` entities.
 * - `delete`: Deletes a `Post` entity.
 *
 * You can also define custom query methods in the `PostRepository` interface by following the Spring Data repository naming conventions or using `@Query` annotations to perform more complex queries if needed. This interface abstracts away the database operations and provides a convenient way to interact with MongoDB without writing boilerplate code for common CRUD operations.
 */
