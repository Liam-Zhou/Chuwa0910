## SpringBoot Annotations

- Used By Entity:

  - `@Entity`: declare on top of the Entity Class, it's the ORM connection between Spring and database
  - `@Table`: corresponds the Entity Class to the table in the database; Has attributes including 'name' and '@UniqueConstraint'
  - `@Id`: the primary key (id) of that table;
  - `@GeneratedValue`: for some fields in entity, auto-generate its value in the database; Has rules including "strategy = GenerationType.IDENTITY"
  - `@Column`: for some fields in entity, connect them with column in database; Has attributes including 'name' and 'nullable'
  - `@CreationTimestamp` and `@UpdateTimestamp`: Hibernate annotations, for auto-generate timestamps when creating / updating
  - `@Document`: MongoDB annotaion, on top of the Entity Class, like the '@Entity' annotation for MySQL
  - `@CreatedDate` and `@LastModifiedDate`: Spring annotations for mongoDB

  ```
  // MySQL & Hibernate
  @Entity
  @Table(
        name = "posts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        }
  )
  public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
  ```

  ```
  // MongoDB
  @Document("post")
  public class Post {
    @Id
    private String id;
        @CreatedDate
    private LocalDateTime createDateTime;

    @LastModifiedDate
    private LocalDateTime updateDateTime;
  }
  ```

- Used By Service:

  - `@Service`: Declare a Service Bean, on top of the Service Class
  - `Autowired`: auto injected the Bean Class in the Spring Container

  ```
  @Service
  public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
  }
  ```

- Used By Controller:

  - `@RestController`: Declare a REST controller, on top of the Controller Class.
  - `@RequestMapping`: Declare a REST request path, on top of the Controller Class
  - `@PostMapping`: Declare a Post API, on top of the post method
  - `@RequestBody`: Decalre a request body data, in front of the input variable of post method

  ```
  @RestController
  @RequestMapping("/api/v1/posts")
  public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        PostDTO response = postService.createPost(postDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
  }
  ```
