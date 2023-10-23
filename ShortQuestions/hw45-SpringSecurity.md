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

## 9. What is JWT?

JSON Web Token, is a compact and self-contained way to represent information between two parties in the form of a JSON object. It is often used for securely transmitting information between a client (typically a user) and a server. JWTs are commonly used for authentication and authorization in web applications and APIs.

## 10. What is the spring security filter?

## 11. decribe how do JWT work(slides 里有图， 26 页)

## 12. Do you use any Encoder to encode Password?

- BCrypt (common): BCrypt is a widely recommended password hashing algorithm known for its security. It incorporates a salt (random data) and a configurable cost factor to make brute-force attacks significantly more difficult.
- Argon2: Argon2 is another modern, secure password hashing algorithm designed to be memory-hard and resistant to various types of attacks. It was the winner of the Password Hashing Competition in 2015.
- Scrypt: Scrypt is designed to be more memory-intensive, making it computationally expensive and resistant to hardware-based attacks. It's a good choice for security, but it can be more resource-intensive.

## 13. What is UserDetailService? AuthenticationProvider?AuthenticationManager? AuthenticationFilter?(把这几个名字看熟悉也行)

## 14. What is the disadvantage of Session? how to overcome the disadvantage?

## 15. how to get value from application.properties?

Using the annotation `@Value("${my.property}")`. Like in ppt 45-46, in application.properties add `app.jwt-secret = JWTSecretKey` and in code JwtTokenProvider add `@Value("$app.jwt-secret")`

## 16. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?

## 17. What is Spring security authentication and authorization?

- SpringSecurity Authorization:

  - Role-Based Access Control (RBAC): Spring Security allows you to define roles and permissions. You can assign roles to users, and users inherit permissions associated with their roles. This is a common approach for authorization, especially in web applications.

  - Expression-Based Access Control: Spring Security provides expression-based security expressions that you can use to define fine-grained access control. You can specify conditions based on user roles, attributes, or custom expressions.

  - Method-Level Security: You can use Spring Security to secure individual methods or service endpoints. By annotating methods with security annotations, you can control who is allowed to execute specific methods.

  - Pre- and Post-Processing: Spring Security supports pre- and post-processing of requests and responses, allowing you to control access before a method is invoked and verify the result afterward.

## 18. (Optional)Assuming that the Redbook UI supports dark mode and multiple languages, when a user signs in, their preferences (such as dark-mode=true and lang=eng) will be read from the database. For the assignment, you can set a value like in the course materials; there is no need to actually read from a database. After signing in, observe the response header and cookie for related information. Continue calling other APIs and observe the request header or cookie for other information. After signing in, Spring Security will generate a session, and the JSESSIONID will be in the cookie. Try to obtain the session content through the JSESSIONID, and then log the session content using the log4j tool. Write the
