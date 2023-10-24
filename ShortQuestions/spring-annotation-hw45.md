- `@PreAuthorize`: allows you to specify access control rules and conditions for securing methods and endpoints in a Spring application.

```
@PreAuthorize("hasRole('ROLE_ADMIN')")
```

- `@ExceptionHandler`: used for defining methods that handle exceptions that occur during the processing of HTTP requests in a Spring MVC application

```
@ExceptionHandler(BlogAPIException.class)
public ResponseEntity<ErrorDetails> handleBlogAPIException(BlogAPIException exception, WebRequest webRequest) {}
```
