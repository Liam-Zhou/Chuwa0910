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

### 9.
