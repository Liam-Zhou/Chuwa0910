# HW13 Xiao Yang

### 1. List all of the annotations you learned from class and homework to annotaitons.md

[See Here](./annotations.md)

### 2.  What is the authentication?
Authentication is the process of verifying the identity of a user or system to ensure that they are who they claim to be.


### 3.  What is the authorization?
Authorization is the process of granting or denying access to specific resources or actions based on a user's identity and the permissions they have.


### 4.  What is the difference between authentication and authorization?
authentication is the process of confirming an entity's identity, while authorization is the process of determining what actions or resources that entity is allowed to access. Both are critical for security, and they often work in tandem to control access to systems and data while ensuring that only authenticated and authorized users can perform specific actions.

### 5. What is HTTP Session?
An HTTP session is a stateful mechanism used in web development to maintain user-specific information across multiple HTTP requests and responses. It allows web applications to recognize and track individual users as they interact with the application. HTTP Session enable web applications to provide personalized experiences and maintain user-specific data across multiple interactions.

### 6.  What is Cookie? 
A cookie is a small piece of data that a web server sends to a user's web browser. And the browser would store this data, and it can be sent back to the server with subsequent HTTP requests. Cookies are commonly used to maintain stateful information, track user behavior, and enable various web application features. They play a fundamental role in web development and user tracking.

### 7. What is the difference between Session and Cookie?
- Storage:
- - Session data is typically stored on the server. A unique session ID is sent to the client's browser, which is used to retrieve the corresponding session data on the server.
- - Cookies are stored on the client side, in the user's browser. They are sent back to the server with each HTTP request to provide information about the client.

- Data format:
- - Session data can be structured in various ways on the server, and it is often stored as objects or associative arrays. The data is not directly visible to the client.

- - Cookies are typically small text files consisting of key-value pairs. The data is stored as plain text and can be inspected by the user or manipulated through browser developer tools.

- Security Concerns:

- - Session data is typically more secure than cookies because it is stored on the server. However, sessions can still be vulnerable to security risks if not properly managed.

- - Cookies can be vulnerable to security issues like cross-site scripting (XSS) and cross-site request forgery (CSRF) because they are stored on the client side. Security measures, such as secure and HttpOnly cookies, can help mitigate these risks.


### 8.  How do we use session and cookie to keep user information across the the application? 

When a user accesses your web application for the first time, you typically create a session for them on the server. This session is assigned a unique session ID, and the associated data is stored on the server. As the user interacts with your application, you can store user-specific information in the session data. For example, you can store user preferences, shopping cart contents, or other data relevant to the user's session.
Cookies are typically created by the server and sent to the user's browser as HTTP response headers. You include the data you want to store in the cookie, and the browser will store it. Similar to sessions, you can store user-specific information in cookies, such as user IDs or preferences. Cookies are often used for small amounts of data that need to persist between requests.
With each subsequent HTTP request, the browser automatically sends the cookies associated with the current website to the server. The server can read the cookie data and use it to personalize the user's experience.

### 9.  What is JWT?

JWT stands for JSON Web Token, and it is a compact, self-contained way to represent and exchange information between two parties securely. JWTs are widely used in web applications for various purposes, including user authentication and data exchange. They are designed to be lightweight and easy to transmit as part of an HTTP request or response.

A JWT typically consists of three parts separated by periods:
- Header: Contains metadata about the token, such as the signing algorithm used.
- Payload: Contains the claims or information being transmitted, such as user ID, roles, or custom data.
- Signature: Used to verify the authenticity of the token. It ensures that the token has not been tampered with.
### 10. What is the spring security filter?

Spring Security is a powerful framework for implementing security features in a Spring-based application. Spring Security provides a set of filters that are responsible for various security-related tasks within your application. These filters are an essential part of the Spring Security architecture and work together to secure the application. These filters are organized in a filter chain, and the order of the filters matters. 

### 11. Decribe how do JWT work(slides 里有图， 26页)
1. User should provide authentication(password), after the server verifying the authentication, it would generate a JWT token using secret key. And send it back to client.

2. Once client got the JWT Token, it should be stored in clientend (like cookies).

3. Client should put this JWT Token into header for very subsequent http request.

4. Server got the JWT token and verify it.

### 12. Do you use any Encoder to encode Password?

In Spring Boot and Spring Security, it's common to encode passwords for user authentication. This is a crucial security measure to ensure that user passwords are not stored in plain text in the database and are adequately protected. Spring Security provides various password encoders to achieve this, and one of the most commonly used encoders is the `BCryptPasswordEncoder`.

1. Dependency Configuration:
Ensure that you have the Spring Security and Spring Security Crypto dependencies in your pom.xml or build.gradle file. These dependencies include the necessary classes and components for password encoding.
2. Configuration:
In your Spring Boot configuration class or a custom Security configuration class, you can configure the password encoder bean. For example:
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```
3. Encoding Passwords:
When creating or updating a user's password (e.g., during user registration or a password change), you can use the PasswordEncoder bean to encode the password before storing it in the database. Here's an example of encoding a password with the BCryptPasswordEncoder:
```java
String rawPassword = "user_password";
String encodedPassword = passwordEncoder.encode(rawPassword);
```

4. Verifying Passwords:
When authenticating a user (e.g., during login), you can use the same PasswordEncoder bean to verify that the provided password matches the stored, encoded password. For example:
```java
boolean passwordMatches = passwordEncoder.matches(rawPassword, encodedPassword);
```
### 13. What is UserDetailService? AuthenticationProvider?AuthenticationManager? AuthenticationFilter?

- `UserDetailsService` is an interface provided by Spring Security. It is a fundamental component for user authentication.
The primary role of UserDetailsService is to load user-specific data based on a given username, often used for authentication purposes. It retrieves user information such as username, password, and granted authorities (roles).
Implementations of UserDetailsService are typically responsible for interacting with a data source (e.g., a database) to retrieve user details.

- `AuthenticationProvider` is another central component in Spring Security. It is responsible for authenticating users based on the information obtained from UserDetailsService. An AuthenticationProvider validates a user's credentials, which may include a username and password or other authentication tokens.
You can configure multiple AuthenticationProvider instances in your Spring Security configuration to support various authentication methods, such as form-based login, token-based authentication, or other mechanisms.

- `AuthenticationManager` serves as the central point for managing the authentication process in Spring Security. It orchestrates the authentication process by delegating the authentication request to the appropriate
AuthenticationProvider. When a user attempts to authenticate, the AuthenticationManager decides which AuthenticationProvider should handle the request and verifies the user's credentials.

- `Authentication` filters are specific components in the Spring Security filter chain responsible for handling various forms of authentication.
For example, the UsernamePasswordAuthenticationFilter is designed for form-based authentication where users submit a username and password.
These filters intercept and process incoming authentication requests and create an Authentication object to represent the user's request.
The authentication filter then forwards the Authentication object to the AuthenticationManager for authentication.

### 14. What is the disadvantage of Session? how to overcome the disadvantage?
Sessions are widely used in web applications for maintaining user-specific information and enabling stateful interactions. However, sessions have certain disadvantages, and it's essential to be aware of these drawbacks and consider ways to overcome them. 

- `Server Resources`:
Sessions consume server resources, especially when there are many active sessions. Each session requires memory to store session data, and this can lead to increased memory usage, impacting the scalability of your application.

- `Scaling Challenges`:
When your application needs to scale horizontally by adding more servers, managing session data across multiple server instances can become complex. Load balancers may need to implement sticky sessions to route requests from the same user to the same server, which can limit load balancing efficiency.

- `Session Invalidation`:
Sessions are typically invalidated after a period of inactivity or based on specific criteria. This can lead to usability issues for users who experience session timeouts, forcing them to log in again or lose their session state.

- `Statefulness`:
Sessions introduce statefulness into an otherwise stateless protocol (HTTP). This can make it more challenging to manage and scale applications.

To overcome the disadvantages of sessions, you can consider the following approaches:

`Use Stateless Authentication`: Implement stateless authentication mechanisms, such as JSON Web Tokens (JWT) or OAuth 2.0, for user authentication and authorization. These mechanisms do not rely on server-side sessions and can help reduce server resource usage.

`External Session Stores`:
Store session data in an external session store, such as a distributed caching solution (e.g., Redis or Memcached). This offloads session data from your application servers, making it easier to scale horizontally.

`Session Cleanup`:
Implement session cleanup strategies to manage inactive sessions effectively. Configure reasonable session timeout values, and consider providing users with options to refresh or extend their sessions without requiring a full login.

`Stateless Services`:
Design your application to be as stateless as possible. Avoid storing unnecessary user-specific data in sessions. Use client-side storage (e.g., browser cookies) for temporary data that does not require server-side state.

`State Management Libraries`:
Consider using state management libraries or frameworks that can help manage user-specific data and reduce the need for server-side sessions.

`Use Caching`:
Utilize caching mechanisms to store frequently accessed data that does not change frequently. This can reduce the need to fetch data from a database on every request.

`Monitoring and Optimization`:
Continuously monitor and optimize your application's resource usage. This includes memory usage, session management, and response times.
### 15. how to get value from application.properties?
- Using the `@Value` Annotation:

You can use the @Value annotation to inject property values directly into your Spring beans. For example, if you have a property called myapp.datasource.url in your application.properties file, you can access it like this:
```java
import org.springframework.beans.factory.annotation.Value;

@Component
public class MyComponent {
    @Value("${myapp.datasource.url}")
    private String datasourceUrl;

    public void doSomething() {
        // Use the property value
        System.out.println("DataSource URL: " + datasourceUrl);
    }
}
```

- Using the Environment Object:

You can also access properties using the Environment object. Here's an example:
```java
import org.springframework.core.env.Environment;

@Component
public class MyComponent {
    private final Environment env;

    public MyComponent(Environment env) {
        this.env = env;
    }

    public void doSomething() {
        // Access the property value
        String datasourceUrl = env.getProperty("myapp.datasource.url");
        System.out.println("DataSource URL: " + datasourceUrl);
    }
}

```

- Using the `@ConfigurationProperties` Annotation:

The @ConfigurationProperties annotation is used to bind a set of properties to a Java object. You define a configuration properties class and annotate it with @ConfigurationProperties. Spring Boot will automatically map properties to fields in this class. Here's an example:
```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("myapp.datasource")
public class DataSourceProperties {
    private String url;

    // Getter and setter methods

    public void doSomething() {
        System.out.println("DataSource URL: " + url);
    }
}

```
### 16. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?
- The configure(HttpSecurity http) method is used to configure security rules related to web-based security, such as URL-level security, authorization, and other settings related to the HTTP layer.

- The configure(AuthenticationManagerBuilder auth) method is used to configure authentication mechanisms for your application. It is primarily concerned with defining how users are authenticated. 

### 17.  What is Spring security authentication and authorization?
- Authentication:

Authentication is the process of verifying the identity of a user or system entity. In the context of Spring Security, it involves determining if a user is who they claim to be. Spring Security offers various authentication mechanisms, including username and password authentication, token-based authentication (e.g., JSON Web Tokens or JWTs), and integration with external authentication providers like LDAP or OAuth.
Authentication can involve checking a user's credentials (e.g., username and password) and ensuring that the user is allowed to access the application.

- Authorization:

Authorization refers to the process of determining whether an authenticated user has permission to perform a specific action or access a particular resource within the application. Spring Security allows you to define authorization rules that specify who can access which parts of your application. Authorization rules can be based on roles, privileges, or other criteria.
Spring Security supports role-based access control, where users are assigned roles, and resource-based access control, where permissions are granted for specific resources.

### 18. (Optional)Assuming that the Redbook UI supports dark mode and multiple languages, when a user signs in, their preferences (such as dark-mode=true and lang=eng) will be read from the database. For the assignment, you can set a value like in the course materials; there is no need to actually read from a database. After signing in, observe the response header and cookie for related information. Continue calling other APIs and observe the request header or cookie for other information. After signing in, Spring Security will generate a session, and the JSESSIONID will be in the cookie. Try to obtain the session content through the JSESSIONID, and then log the session content using the log4j tool. Write the code based on the 08_04 branch