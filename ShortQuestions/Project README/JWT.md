This branch is configured with the personal login info based on default Spring Security.

JWT version.
## Add Dependency
```xml
<!--spring security-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt -->
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt</artifactId>
  <version>0.9.1</version>
</dependency>

<!--从Java 9开始，发生显著的变化，导致某些之前默认可用的包在新的Java版本中默认不再可用。javax.xml.bind包，包括DatatypeConverter类。-->
<dependency>
  <groupId>javax.xml.bind</groupId>
  <artifactId>jaxb-api</artifactId>
  <version>2.3.1</version>
</dependency>
```

## Add Code
- controller/AuthJWTController
- entity/security
- payload/security
- service/security
- config/security
### 具体修改细节
- 针对 `SecurityDBJWTConfig / filterChain`
```java
http.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))
http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
```

- 针对` AuthJWTController`
```java
String token = tokenProvider.generateToken(authentication);
JWTAuthResponse jwtAuthResponse = new JWTAuthResponse(token);
jwtAuthResponse.setTokenType("JWT");
// 修改函数返回值： ResponseEntity<JWTAuthResponse>
```

## Operations
- Add data in DB `roles` table:
```sql
use redbook;
insert into roles values (1, "ROLE_ADMIN");
insert into roles values (2, "ROLE_USER");
```
- Call `localhost:8080/api/v1/jwt/signup`, create new users
- Call `localhost:8080/api/v1/jwt/signin`, login to the account

- Call `localhost:8080/api/v1/posts` 
  - in browser, you will be routed to login page. Then use login information for getting all data. 
  - For Postman, go to the `Authorization` and choose the type `Basic Auth`. Put the login info into the form.
  s


## 解析代码
### `JwtTokenProvider`： 生成 / 验证 JWT
- `Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);`
  - `.setSigningKey(jwtSecret)`：这一步将你的签名密钥（jwtSecret）设置到解析器中。这个密钥应该与用于签名JWT的密钥相匹配。
  - `.parseClaimsJws(token)`：这一步实际上解析和验证了传入的token字符串。方法专门用于解析具有签名的JWT（即JWS），如果成功，
    这个方法会返回一个`Jws<Claims>`对象，其中包含了JWT的负载（即claims）；如果失败会抛出异常。5种级别的异常：
    - `SignatureException`：签名	
    - `MalformedJwtException`: 格式不对
    - `ExpiredJwtException`: expired
    - `UnsupportedJwtException`: 身份不支持
    - `IllegalArgumentException`: 其他
### `JwtAuthenticationFilter`
- `doFilterInternal`
  1. 验证token的有效性：
  `tokenProvider.validateToken(token)`
  2. 解析用户名：
  `String username = tokenProvider.getUsernameFromJWT(token);` 
  3. 加载用户详情：
  `UserDetails userDetails = ..loadUserByUsername(username);`
  4. 创建token, 用户详情放入token：
  `UsernamePasswordAuthenticationToken authenticationToken = new ..(userDetails, null, ..getAuthorities())`
  5. 设置认证详情：
  `authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));`
  将当前HTTP请求的详情设置到认证对象中。这对于后续的安全决策可能是必要的，比如IP地址检查等。
  6. 设置Spring Security的安全上下文：
  `SecurityContextHolder.getContext().setAuthentication(authenticationToken);`
  token存储在SecurityContextHolder的上下文中，这样，应用的其他部分就可以知道当前用户已经被认证，并且可以获取他们的权限信息。
  7. 继续过滤器链：
  `filterChain.doFilter(request, response);`
  方法调用过滤器链中的下一个过滤器，或者如果这是链中的最后一个过滤器，则继续处理请求。这意味着请求现在可以继续执行，因为用户已成功认证。

### `JwtAuthenticationEntryPoint`
- 自定义认证入口点
```java
http.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))
```
这行代码用于自定义认证过程中的入口点。当访问被保护的资源而未经过认证（即，没有登录或者提供了无效的认证凭证）时，Spring Security会调用一个AuthenticationEntryPoint实现。
- `authenticationEntryPoint`

是一个实现了AuthenticationEntryPoint接口的对象，它的`commence()`方法会在认证失败时被调用。这可以用于返回一个特定的错误信息或者重定向到一个登录页面。
  - 返回错误信息：`response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());`
  - 重定向页面：`response.sendRedirect("/login");`

### 添加自定义过滤器（JWT Authentication Filter）
```java
http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
```
- 这行代码向Spring Security过滤器链中添加一个自定义过滤器，用于处理JWT认证。
- jwtAuthenticationFilter()是一个返回自定义JWT认证过滤器的方法。这个过滤器负责解析和验证JWT令牌，然后设置Spring Security的安全上下文（SecurityContextHolder）。
- `addFilterBefore`方法将这个过滤器添加到`UsernamePasswordAuthenticationFilter`(默认存在于Spring Security Filter Chain之中)之前。
- 这意味着在用户名和密码的认证处理之前，先进行JWT的解析和验证。这是因为**如果请求中携带了有效的JWT，就不需要进行基于表单的登录认证。**
通过这种方式，你可以在用户访问受保护资源之前，通过JWT来认证用户的身份，这对于构建无状态的REST API尤其重要。

## Reference
https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

https://github.com/spring-projects/spring-security/issues/11926

https://stackoverflow.com/questions/74877743/spring-security-6-0-dao-authentication

https://stackoverflow.com/questions/72381114/spring-security-upgrading-the-deprecated-websecurityconfigureradapter-in-spring

https://www.linkedin.com/pulse/solved-deprecated-websecurityconfigureradapter-mateus-nascimento/

https://www.bezkoder.com/websecurityconfigureradapter-deprecated-spring-boot/