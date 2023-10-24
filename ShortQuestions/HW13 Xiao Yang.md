# HW13 Xiao Yang

### 1. List all of the annotations you learned from class and homework to annotaitons.md

[See Here](./annotations.md)

### 2.  What is the authentication?



### 3.  What is the authorization?



### 4.  What is the difference between authentication and authorization?


### 5. What is HTTP Session?
### 6.  What is Cookie? 
### 7. What is the difference between Session and Cookie?
### 8.  How do we use session and cookie to keep user information across the the application? 
### 9.  What is JWT?
### 10. What is the spring security filter?

### 11. Decribe how do JWT work(slides 里有图， 26页)
### 12. Do you use any Encoder to encode Password?
### 13. What is UserDetailService? AuthenticationProvider?AuthenticationManager? AuthenticationFilter?(把这几个名字看熟悉也行)
### 14. What is the disadvantage of Session? how to overcome the disadvantage?
### 15. how to get value from application.properties?
### 16. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?
### 17.  What is Spring security authentication and authorization?
### 18. (Optional)Assuming that the Redbook UI supports dark mode and multiple languages, when a user signs in, their preferences (such as dark-mode=true and lang=eng) will be read from the database. For the assignment, you can set a value like in the course materials; there is no need to actually read from a database. After signing in, observe the response header and cookie for related information. Continue calling other APIs and observe the request header or cookie for other information. After signing in, Spring Security will generate a session, and the JSESSIONID will be in the cookie. Try to obtain the session content through the JSESSIONID, and then log the session content using the log4j tool. Write the code based on the 08_04 branch