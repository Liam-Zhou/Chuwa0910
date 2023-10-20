###### 2.  What is the authentication?
Kind of validation, make sure you have the something like account and password, fingerprint or anything could prove.

###### 3.  What is the authorization?
Give the access to corresponding users if they have the access.

###### 4.  What is the difference between authentication and authorization?
Authentication verifies the identity of a user or entity, while authorization determines what actions or resources they are allowed to access once their identity is confirmed.

###### 5.  What is HTTP Session?
An HTTP session is a stateful mechanism used in web development to maintain information about a user's interactions with a web application across multiple HTTP requests and responses. It allows a web server to associate data with a specific user and keep track of their activity as they navigate through a website or web application. 

###### 6.  What is Cookie? 
A cookie is a small piece of data that a web server sends to a user's web browser during their visit to a website. The browser stores this data, and then, whenever the user revisits the same website or makes subsequent requests to the site, the browser sends the cookie back to the server.

###### 7. What is the difference between Session and Cookie?
Sessions are used for server-side state management and maintaining user-specific data, while cookies are used for client-side storage of small amounts of data, often for user preferences and tracking.

###### 8.  How do we use session and cookie to keep user information across the the application? 
Using Sessions:

    Set up session management.
    Create sessions for users.
    Store user data in sessions.
    Retrieve user data from sessions.
    Update or remove session data as needed.

Using Cookies:

    Set cookies with server-side code.
    Read and parse cookies on the server.
    Update cookies by setting new values.
    Delete cookies by setting an expired date.

    
###### 9.  What is JWT?
JWTs are a flexible and widely adopted mechanism for securely transmitting information between parties, particularly in web applications and APIs.

###### 10. What is the spring security filter?
In Spring Security, filters are components that process HTTP requests and responses to enforce security policies. They are organized in a filter chain and perform tasks like authentication, authorization, CSRF protection, and more. The chain is configured to secure web applications and APIs. Each filter has a specific role, such as authentication, authorization, or logout handling. Custom filters can also be added to implement application-specific security logic. Configuration defines filter order and behavior.

###### 11. decribe how do JWT work(slides 里有图， 26页)
They consist of a header, payload, and signature. After a user logs in, the server creates a JWT containing user data and signs it. The client stores the JWT and sends it with requests. Servers verify the token's signature, extract claims, and make authorization decisions. Tokens can expire, and the process is stateless.

###### 12. Do you use any Encoder to encode Password?
Yes, for sure. Hashing, Salting, or any algorithm like RSA

###### 13. What is UserDetailService? AuthenticationProvider? AuthenticationManager? AuthenticationFilter?(把这几个名字看熟悉也行)
UserDetailsService retrieves user details.
AuthenticationProvider authenticates users using various mechanisms.
AuthenticationManager orchestrates the authentication process by using one or more authentication providers.
AuthenticationFilter handles user authentication by intercepting and processing incoming requests.

###### 14. What is the disadvantage of Session? how to overcome the disadvantage?
Disadvantages of sessions:

    Scalability challenges.
    Server-side storage complexity.
    Introduce statefulness.
    Session timeout management.
    Resource consumption.
    User mobility complexity.

Solutions:

    Use distributed caching.
    Consider client-side storage (e.g., JWTs).
    Design stateless architecture.
    Careful session timeout configuration.
    Limit session data size.
    Implement flexible session management for user mobility.

###### 15. how to get value from application.properties?
Using java.util.Properties (Core Java):

    Create application.properties with key-value pairs.
    Load properties using java.util.Properties.
    Retrieve values by key.

Using Spring Boot (Spring Framework):

    Create application.properties (if not already present).
    Use @Value annotation to inject property values into Spring beans.

###### 16. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?
configure(HttpSecurity http) configures how HTTP requests are secured, including access control and authorization.
configure(AuthenticationManagerBuilder auth) configures how user authentication is performed, defining where user details are stored and how users are authenticated.

###### 17.  What is Spring security authentication and authorization?
Authentication: It verifies user identities through various methods like form-based, basic, or token-based authentication.
Authorization: It controls user access based on roles, expressions, method-level security, and custom access logic.