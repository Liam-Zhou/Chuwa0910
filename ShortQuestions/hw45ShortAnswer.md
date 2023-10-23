### 2. Authentication
Identity of users are checked for providing the access to the system. Done before the authorization process.
Needs user's login details. Transmit information thorugh an ID Token.
Example: Employees in a company are required to authenticate through the network before accessing their company email.

### 3. Authorization
User's authorities are checked for accessing the resoures. Users are validated. Determines what permission do user have.
Example: After an employee successfully authenticates, the system determines what information the employees are allowed to access.

### 4. Explained as above

### 5. http session:
Server-side storage mechanism used to maintain state across multiple requests from the same user. When a user logs into a web application or performs an action that requires state management, a session is created on the server. You cannot directly access session data from the browser, as it is stored on the server.

### 6. Cookie: 
Cookie is a small piece of data sent from a webserver to a user's browser. The browser stores the cookie and sends it back with each subsequent request to the same server. This allows the server to identify and track users and remember their preferences or other data. It's produced by the webserver and sent to the clinet through http headers.

### 7. Session vs cookie.
Session is stored in the server but cookie is sent to the user's browswer.

### 8. 
Cookies and sessions are used in web applications to maintain state and provide a better user experience.
http is stateless, each request made to the server is independent and has no knowledge of previous requests. So cookies and sessions help server to maintain its state. It also helps to track user identification. They could also enable web applications to provide persoanlized user experience.
 
### 9. JWT
Json Web Token: Popular way to do user authorization in web apps. Once the user is logged in, each subsequent request will include the jwt, alloiwng the user to access resources that are permitted with that token.

### 10. Spring security filter
Spring security proccess http request through a chain of filters in this order:
1. Security Context Persistence filter: loading and stroing the security context containing authentication and authorization information for each http request.

2. Log out filter: handles the log out process.
3. User name Password Authentication filter.
4. Basic Authentication Filter: processing http basic authentication headers.
5. Remember Me authentication filter.
6. Exception Translation filter: handles any Spring security exceptions.
7. Filter Security Interceptor: Handles authorization(access control) checks.

### 11. How does jwt works.
The claims in a jwt are encoded as a json object digitally signed and optionally encrypted. JWT contains a header: the type of token(jwt) and the signing algorithm.
2. Json Payload containing the claim about an entity(like user).
3. Signature: Take the enocded header, payload, the header algorithm, and sign.
4. Output: Base64-url string seprated by dots to pass to html and http environments.

For us user to deploy it, we need to:
1: Add the jwt depedency.
2: Create JwtAuthenticationEntryPoint class; this method is called whenever an exception is thrown due to an unauthenticated user trying to access a resource.
3: Add jwtproperties in application.properties file.
4: Create JwtTokenProvider.
5: JwtAuthenticationFilter.
6: Create JWTAuthResponseDTO.
7: Configure JWT in Spring Security Configuration.
8: Change login/signinAPI to return token to client.

### 12. Passwords Encoding.
Springboot provides password hashing depedency. You can create a pssword encoder bean in the configuration class, and can inject it to where you can use it. You'll get a String of encoded Password.

### 13. 
UserDetailService retrive user-related data. AuthenticationProvider is used for authentication.
AuthenticationManager defines the main strategy interface for authentication. AuthenticationFilter extract credential inforamtion.

### 14. Disadvantage of html session.
Session is stateful, meaning that there's always something to consider when you're scaling up things. To overcome it we can use the stateless authentication tokens. Also, session dependent on cookies. So if a user disable cookies, session won't function properly. To address that, we can store the dataa in the browser's local storage.

### 15. Injecting value from application.properties.
myobject.value=Hello, World! in the properties file.

In the java class, we do: @Value("${myproperty.value}")
                          private String myValue;(myValue prints out "hello world".)

### 16. Configure
Configure in httpSecurity is used to configure web-absed security for specific http requests. By default it is applied to all requests, but it can be restricted to specific request based on their attributes.
Configure(AuthenticationManagerBuilder auth) is a builder object provided by Spring Security to help you set up an manager. It's the main spring secruity interface for authentication.

### 17. Authentication vs Authorization. Answered in number 2 and 3.
