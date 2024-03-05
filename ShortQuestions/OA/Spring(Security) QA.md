### Spring Bean Lifecycle



### Spring Security Session存储什么信息

Spring Security在处理Web安全性时，使用session来存储关于已认证用户的信息。当用户成功地通过身份验证后，他们的身份信息会被存储在session中，以便后续的请求可以知道用户已经被认证，并知道用户的导份。

在Spring Security中，这个信息一服是被存储为一个叫做`SecurityContext`的对象，包含了关于当前用户的身份认证和授权的详细信息。

以下是在Spring Security session中通常存储的主要内容：

1. **Authentication对象**：这是当前用户已经完成身份验证的标志。它包含以下信息：

- ﻿**Principal**：用户的标识，通常是一个`UserDetails`对象或它的子类，提供了用户名、密码和授权等信息。
- **Credentials**：通常是用户的密码或其他认证信息。
- ﻿**Authozities**：当前用户被授予的权限列表，这可以是角色（如`ROLE_USER`、`ROLE_ADMIN`等）或其他更細粒度的权限。

1. ﻿﻿UserDetails对象：如果你使用了`UsexDetailsService`，这个刘象会被用来加载特定用户的详细信息，如用户名、密码、是否启用以及其他的属性。
2. ﻿﻿﻿其他Spring Security相关的属性：除了`SecurityContext`, session中也可能存储其他与

Spring Security相关的属性，例如防止跨站请求伪造（CSRF） 的会牌。

为了更好地保护这些信息，应该果取措施确保session的安全性，例如使用HTTPS、限割session的生命周期和采用适当的Session管理策略。

最后，值得注意的是，如果你使用无状态认证机制（例如JWVT），那么不需要session来存储安金上下文，因为每个请求都会携带足够的信息来验证和授权用户。



### Caching in Spring Projecgt


Using caching in a Spring project can significantly improve performance by reducing the need to repeatedly fetch data from slower data sources such as databases or external APIs. Spring provides comprehensive support for caching through its caching abstraction, which allows you to easily integrate caching into your application.

Here's how you can use caching in your Spring project:

1. **Enable Caching**: To enable caching in your Spring project, you need to add `@EnableCaching` annotation to one of your configuration classes, typically a configuration class annotated with `@Configuration`.

   ```java
   import org.springframework.cache.annotation.EnableCaching;
   import org.springframework.context.annotation.Configuration;
   
   @Configuration
   @EnableCaching
   public class CachingConfig {
       // Configuration settings
   }
   ```

2. **Define Cacheable Methods**: Annotate the methods that you want to cache with `@Cacheable` annotation. This annotation indicates that the method's result should be cached based on the specified cache name.

   ```java
   javaCopy code
   import org.springframework.cache.annotation.Cacheable;
   import org.springframework.stereotype.Service;
   
   @Service
   public class MyService {
   
       @Cacheable("myCache")
       public String getData(String key) {
           // Method logic to fetch data
           return fetchedData;
       }
   }
   ```

3. **Configure Cache Providers**: Spring supports various caching providers such as Ehcache, Redis, Caffeine, and others. You need to configure the cache provider in your Spring configuration file (e.g., `application.properties` or `application.yml`).

   For example, if you're using Ehcache as the caching provider, you would include the following configuration in your `pom.xml`:

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-cache</artifactId>
   </dependency>
   <dependency>
       <groupId>org.ehcache</groupId>
       <artifactId>ehcache</artifactId>
   </dependency>
   ```

   And then configure Ehcache in your `application.properties`:

   ```properties
   spring.cache.type=ehcache
   ```

4. **Use Cache Managers**: Spring uses CacheManager to manage caching in your application. You can inject CacheManager into your classes to access cache-related functionality programmatically.

   ```java
   javaCopy code
   import org.springframework.cache.CacheManager;
   import org.springframework.stereotype.Component;
   
   @Component
   public class CacheHelper {
   
       private final CacheManager cacheManager;
   
       public CacheHelper(CacheManager cacheManager) {
           this.cacheManager = cacheManager;
       }
   
       public void clearCache(String cacheName) {
           cacheManager.getCache(cacheName).clear();
       }
   }
   ```

5. **Configure Cache Eviction Policies**: You can configure cache eviction policies such as time-to-live (TTL) or maximum cache size to control how long cached data remains valid or how much data can be cached.

   ```java
   import org.springframework.cache.annotation.CacheConfig;
   import org.springframework.cache.annotation.CacheEvict;
   import org.springframework.stereotype.Service;
   
   @Service
   @CacheConfig(cacheNames = "myCache")
   public class MyService {
   
       @CacheEvict(allEntries = true)
       public void clearCache() {
           // Clear all entries from cache
       }
   }
   ```

The procedure outlined above utilizes Spring's caching abstraction, which is a high-level caching framework built into the Spring Framework itself. This abstraction layer allows developers to integrate caching functionality into their Spring applications without being tied to a specific caching implementation.

The caching abstraction provided by Spring is designed to be flexible and compatible with various caching providers, including:

1. **Ehcache**: Ehcache is an open-source, widely-used, and highly configurable caching library for Java applications.
2. **Caffeine**: Caffeine is a high-performance, near-optimal caching library for Java 8 and above.
3. **Redis**: Redis is an in-memory data structure store often used as a caching solution due to its speed and versatility.
4. **GemFire**: GemFire is an in-memory data grid platform for scaling and distributing data across distributed systems.
5. **Hazelcast**: Hazelcast is an open-source distributed computing platform that includes a caching solution among its features.
6. **Guava Cache**: Guava Cache is a lightweight caching library provided by Google's Guava library, offering simple and effective caching capabilities.



### Security: csrf()

CSRF 的全称是 Cross-Site Request Forgery。

在 Spring Security 中，`csrf()` 是一个配置方法，用于启用或配置跨站请求伪造（CSRF）保护。CSRF 是一种攻击方式，攻击者利用用户的身份在用户不知情的情况下发送恶意请求，以执行未经授权的操作。

`csrf()` 方法通常用于在 Spring Security 中配置 CSRF 保护，可以配置一些选项来定制 CSRF 保护的行为。例如，可以配置是否启用 CSRF 保护、CSRF 令牌的生成策略、CSRF 令牌的存储方式等。

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // 禁用 CSRF 保护
    }
}
```

在这个示例中，我们创建了一个安全配置类 `SecurityConfig`，并覆盖了 `WebSecurityConfigurerAdapter` 的 `configure(HttpSecurity http)` 方法。在 `http` 对象上调用 `csrf().disable()` 方法来禁用 CSRF 保护。这意味着在应用程序中将不会进行 CSRF 令牌验证，所有请求都将被允许。



## SecurityFilterChain

可配置多重规则

- 第一部分：matcher_url + 规则 （permitAll / hasAnyRole / hasAnyAuthority）
- 第二部分：其他的请求 anyRequest() + 需要验证 authenticated()

![image-20240221013026793](/Users/hyc/Library/Application Support/typora-user-images/image-20240221013026793.png)

### 查看用户验证后身份
运行的controller/service处贴上这段代码进行查验

```java
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

// 检查当前用户是否已经认证
if (authentication != null && authentication.isAuthenticated()) {
    // 获取当前用户的用户名
    String username = authentication.getName();
    System.out.println("当前用户名：" + authentication);
}
```

## HTTP Basic - `.httpBasic(withDefaults())`

`.httpBasic(withDefaults())`是Spring Security中的一个配置方法，它用于启用HTTP Basic认证。HTTP Basic认证是一种简单的认证协议，客户端会将用户的用户名和密码以`username:password`的形式进行Base64编码，然后作为HTTP请求的`Authorization`头部发送给服务器。服务器接收到这个请求后，会解码并验证用户名和密码是否正确。

在Spring Security中，如果你不显式启用某种认证方式（比如表单登录、HTTP Basic等），Spring Security默认会拒绝所有未经认证的请求，返回403 Forbidden错误。这是因为Spring Security的核心原则之一是默认拒绝访问，只有明确授权的请求才会被允许。

因此，如果你在Spring Security配置中没有添加`.httpBasic(withDefaults())`（或其他认证配置），尽管你的安全配置可能已经正确设置了用户的认证信息，但是因为缺乏一个有效的认证入口点来处理和接受认证信息，所有的请求都会被认为是**未认证**的，从而返回`403 Forbidden错误`。

通过添加.httpBasic(withDefaults())，你告诉Spring Security启用HTTP Basic认证机制，这样客户端就可以通过发送包含用户名和密码的HTTP请求来进行认证。一旦认证成功，**用户就会被授予访问其他受保护资源的权限**，否则会返回`401 Unauthorized错误`。

总结：

- 启用HTTP Basic认证方式
- 允许客户端通过HTTP请求的`Authorization`头部发送用户名和密码进行认证。
- 避免因缺少认证机制而导致的403 Forbidden错误，使得只有通过认证的用户才能访问受保护的资源。

### HTTP Code

**403 Forbidden:** 未认证

**401 Unauthorized:** 认证成功，但是用户权限受限



### Spring Annotation

- `@JsonProperty`: Dto对应Json里面的field名

  ```java
  public class LoginDto {
      @JsonProperty("accountOrEmail")
      private String accountOrEmail;
      private String password;
  }
  ```

  

### Provider / Manager in Spring Security

在 Spring Security 中，Provider 和 Manager 是两个关键概念，它们共同构成了认证和授权的流程。

1. **AuthenticationManager**： `AuthenticationManager` 是 Spring Security 中用于处理认证（Authentication）的核心接口。它定义了一个方法 `authenticate`，接受一个 `Authentication` 对象作为参数，并返回一个已认证的 `Authentication` 对象。在认证流程中，`AuthenticationManager` 负责根据提供的凭据（用户名、密码等）对用户进行认证，并返回一个已认证的 `Authentication` 对象，表示认证成功。
2. **AuthenticationProvider**： `AuthenticationProvider` 是 `AuthenticationManager` 的实现者之一，它负责具体的认证逻辑。每个 `AuthenticationProvider` 实现类都要处理特定类型的认证请求，例如基于用户名密码的认证、基于LDAP的认证等。当 `AuthenticationManager` 要对用户进行认证时，它会委托给注册的 `AuthenticationProvider` 实现类来处理认证请求。

在 Spring Security 配置中，可以配置多个 `AuthenticationProvider`，这样就可以实现多种认证方式的支持。例如，你可以配置一个 `DaoAuthenticationProvider` 用于基于数据库的用户名密码认证，同时也可以配置一个 `LdapAuthenticationProvider` 用于基于LDAP的认证。

总的来说，`AuthenticationManager` 是认证的入口，它委托给注册的 `AuthenticationProvider` 来实际执行认证逻辑。通过配置适当的 `AuthenticationProvider`，可以支持多种认证方式，并且可以根据需要进行扩展和定制。

```java
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(authenticationProvider);
    }
```

