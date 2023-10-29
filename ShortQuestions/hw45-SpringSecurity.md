# Homework 45 - SpringSecurity

## 1. List all of the annotations you learned from class and homework to annotaitons.md

## 2. What is the authentication?

Authentication: The process of Verifying the identity of a user for accessing a secure resource, such as web application, API or system.

## 3. What is the authorization?

Authorization: The process of Validating the identity has granted/denyed access for specific resources/operations, based on the permissions and privileges assigned to the user.

## 4. What is the difference between authentication and authorization?

Authentication is more inclined to validate you are you, and Authorization is more inclined to validate you have the permission.

## 5. What is HTTP Session?

It refers to a resolution for keeping connection between client and server. The seesion is a server-side storage mechanism that can maintain the state and data of users' with application across multiple requests. It enables the server to remember(restore) information about the user, such as login status, shopping cart contents, and other user-specific data, throughout their visit to the site. And then return the sessionId to the client's user for further requests.

## 6. What is Cookie?

A cookie is a small piece of data that a web server sends to a user's web browser, which is then stored on the user's computer. Cookies are commonly used in web development to maintain state and store information about the user's interactions with a website.

## 7. What is the difference between Session and Cookie?

- Location of Storage: Session is stored on the server whereas Cookie is stored on the client-side (often in the web browser).
- Size: Session data can be larger in size and more complex whereas Cookie are limited in size(usually a few kilobytes).

## 8. How do we use session and cookie to keep user information across the application?

- Use a session to keep track of user-specific data on the server
- Then the web server sent back the sessionId to the client-side(user browser)
- The browser stores the sessionId in the cookie and send it back with each subsequent request to the same server.
- The server would find user's session with sessionId in the cookie

## 9. What is JWT?

JSON Web Token, is a compact and self-contained way to represent information between two parties in the form of a JSON object. It is often used for securely transmitting information between a client (typically a user) and a server. JWTs are commonly used for authentication and authorization in web applications and APIs.

## 10. What is the spring security filter?

In Spring Security, a security filter is a fundamental component responsible for processing various security-related tasks in a web application. These filters are part of the filter chain, which is a series of filters applied to incoming HTTP requests and outgoing responses.

- Authentication Filters:

      - UsernamePasswordAuthenticationFilter: Handles form-based authentication. It processes login requests and validates the user's credentials.
      - BasicAuthenticationFilter: Processes HTTP Basic Authentication requests, often used with RESTful APIs.
      - RememberMeAuthenticationFilter: Supports remember-me functionality, allowing users to be automatically logged in on subsequent visits.

- Authorization Filters:

  - FilterSecurityInterceptor: Enforces authorization rules and permissions based on access control lists (ACLs) or custom security rules.
  - WebExpressionVoter: Implements role-based access control based on expressions defined in annotations or XML configuration.

- Session Management Filters:

  - ConcurrentSessionFilter: Helps manage concurrent user sessions and controls the number of active sessions per user.
  - SessionManagementFilter: Enforces session timeout and session fixation protection.

- CSRF Protection Filters:

  - CsrfFilter: Provides Cross-Site Request Forgery (CSRF) protection by validating tokens in requests.

- Logout Filter:

  - LogoutFilter: Handles user logout requests, logging users out and redirecting them to a specified URL.

- Custom Filters: Developers can create custom filters to perform specific security-related tasks. These filters can be inserted into the Spring Security filter chain.

- Exception Handling Filters: Various filters are responsible for handling exceptions and security-related errors, such as AccessDeniedException, AuthenticationException, etc.

## 11. decribe how do JWT work(slides 里有图， 42 页)

JWT consists of three parts including Header, Payload and Signature. JWT work as below:

- 1. Post `/authenticate` with username and password, from Client to Server
- 2. Validate the username and password and Generate the JWT using secret key at Server side
- 3. Return the generated JWT, from Server to Client
- 4. GET `/hello` with JWT in the Header, from Client to Server
- 5. Validate JWT using secret key, at Server side
- 6. Return the response, from Server to Client

## 12. Do you use any Encoder to encode Password?

- `BCrypt` (common): BCrypt is a widely recommended password hashing algorithm known for its security. It incorporates a salt (random data) and a configurable cost factor to make brute-force attacks significantly more difficult.
- `Argon2`: Argon2 is another modern, secure password hashing algorithm designed to be memory-hard and resistant to various types of attacks. It was the winner of the Password Hashing Competition in 2015.
- `Scrypt`: Scrypt is designed to be more memory-intensive, making it computationally expensive and resistant to hardware-based attacks. It's a good choice for security, but it can be more resource-intensive.

## 13. What is UserDetailService? AuthenticationProvider?AuthenticationManager? AuthenticationFilter?(把这几个名字看熟悉也行)

`UserDetailsService` is an interface in Spring Security that is used to load user-specific data. It typically retrieves user details from a database or any other data source. The primary method in this interface is loadUserByUsername(String username), which loads user details based on a username. It returns a UserDetails object, which contains user information like username, password, and granted authorities (roles). You need to implement this interface or configure it to load user details specific to your application.

`AuthenticationProvider` is responsible for authenticating users based on their credentials (usually username and password). It receives an Authentication object, validates the credentials, and, if valid, returns a fully authenticated Authentication object. Spring Security supports various authentication providers, including DaoAuthenticationProvider (which uses a UserDetailsService), LdapAuthenticationProvider, and others. You can configure and customize the authentication provider based on your authentication needs.

`AuthenticationManager` is the central component in Spring Security responsible for managing the authentication process. It orchestrates authentication by delegating the process to one or more AuthenticationProvider instances. When a user attempts to log in, the AuthenticationManager is responsible for choosing the appropriate authentication provider and passing the Authentication request to it. It then receives the result of the authentication process and, if successful, returns a fully authenticated Authentication object.

`AuthenticationFilter` is not a standard component in Spring Security, but it generally refers to a filter in the servlet filter chain that handles authentication-related tasks. Spring Security uses various authentication filters, such as UsernamePasswordAuthenticationFilter for form-based authentication or BasicAuthenticationFilter for HTTP Basic Authentication. These filters intercept incoming requests, extract user credentials, and attempt to authenticate the user. If authentication is successful, they create an authenticated SecurityContext and associate it with the request, allowing access to secured resources.

In summary, these components work together to handle user authentication and authorization in Spring Security. The `UserDetailsService` retrieves user details, the `AuthenticationProvider` validates credentials, the `AuthenticationManager` manages the authentication process, and `Authenticationfilters` help in extracting and validating credentials from incoming requests.

## 14. What is the disadvantage of Session? how to overcome the disadvantage?

- Server Affinity: Difficulty for multiple servers
  - Resolution 1: Session Sharing
  - Resolution 2: Session Stickness
- Resource Consumption: for many users on the server-side
  - Configure short session lifetimes for applications
- Data Security: Sensitive Data stored in session
  - Implement encryption when dealing with sensitive data
  - use secure communication protocols (e.g., HTTPS) to protect data in transit

## 15. how to get value from application.properties?

Using the annotation `@Value("${my.property}")`. Like in ppt 45-46, in application.properties add `app.jwt-secret = JWTSecretKey` and in code JwtTokenProvider add `@Value("$app.jwt-secret")`

## 16. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?

`configure(HttpSecurity http)` Method:

- This method is used to configure security rules related to request authorization. It defines which URL paths are protected, who has access to them, and what specific security requirements (e.g., authentication, authorization) should be applied.
- Inside this method, you can specify rules using methods like .antMatchers(), .permitAll(), .hasRole(), .hasAuthority(), and more. These methods allow you to express access control rules for different parts of your application.
- Here is an example of how you might use this method to configure some security rules:

```
@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/public/**").permitAll()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasRole("USER")
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();
}
```

`configure(AuthenticationManagerBuilder auth)` Method:

- This method is used to configure the authentication mechanism for your application, specifying how users are authenticated and where user details are retrieved.
- You can define how user authentication works, such as using an in-memory user store, a custom user details service (implementing UserDetailsService), an LDAP server, or a custom authentication provider.
- Inside this method, you configure authentication providers, such as in-memory authentication, database authentication, or custom authentication. You can define user details, passwords, roles, and other authentication-related data.
- Here is an example of how you might use this method to configure authentication using an in-memory user store:

```
@Autowired
public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .inMemoryAuthentication()
            .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
            .and()
            .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN");
}
```

## 17. What is Spring security authentication and authorization?

- SpringSecurity Authorization:

  - Role-Based Access Control (RBAC): Spring Security allows you to define roles and permissions. You can assign roles to users, and users inherit permissions associated with their roles. This is a common approach for authorization, especially in web applications.

  - Expression-Based Access Control: Spring Security provides expression-based security expressions that you can use to define fine-grained access control. You can specify conditions based on user roles, attributes, or custom expressions.

  - Method-Level Security: You can use Spring Security to secure individual methods or service endpoints. By annotating methods with security annotations, you can control who is allowed to execute specific methods.

  - Pre- and Post-Processing: Spring Security supports pre- and post-processing of requests and responses, allowing you to control access before a method is invoked and verify the result afterward.

## 18. (Optional)Assuming that the Redbook UI supports dark mode and multiple languages, when a user signs in, their preferences (such as dark-mode=true and lang=eng) will be read from the database. For the assignment, you can set a value like in the course materials; there is no need to actually read from a database. After signing in, observe the response header and cookie for related information. Continue calling other APIs and observe the request header or cookie for other information. After signing in, Spring Security will generate a session, and the JSESSIONID will be in the cookie. Try to obtain the session content through the JSESSIONID, and then log the session content using the log4j tool. Write the
