### 1. Microservices Components

![image-20240111194005208](/Users/hyc/Library/Application Support/typora-user-images/image-20240111194005208.png)

### 2. How to write Eureka Server

- dependency: Netflix-eureka-server & netflox-eureka-client (业务)
- Configuration: yaml / properties, 自己的项目下配置自己的application name
- Define the routing in API Gateway by some rules like "predicates"

### 3. How to do Service Discovery

**Eureka (Netflix OSS):**

- **特点：** 设计简单，专注于服务发现，由Netflix开发。
- **优势：** 易于使用，与Spring Cloud集成良好。
- **适用场景：** Spring Cloud项目、轻量级场景。

**Nacos:**

- **特点：** 由阿里巴巴开发，支持服务发现、配置管理、动态DNS等。
- **优势：** 全球范围的服务发现、管理和治理。
- **适用场景：** 大规模微服务系统，支持云原生应用。

**Kubernetes Service Discovery:**

- **特点：** Kubernetes自带的服务发现机制，通过Service和Endpoints资源管理服务。
- **优势：** 与Kubernetes集成紧密，自动化、无需额外配置。
- **适用场景：** 在Kubernetes集群中的微服务应用。



### 4. Server/Microservices Communication

- **Sync:**  RestTemplate, Feign

  RestTemplate: Connect One Server to another serve  (Vaccination visited Citizen)

  在微服务架构中，各个微服务通常需要相互通信。RestTemplate 提供了一种方便的方式来进行HTTP请求，从而实现服务之间的交互。

  细节：`RestTemplate` 通过封装底层的HTTP通信细节（如连接管理、序列化/反序列化等），提供了一种高级的方式来与RESTful服务进行交互。它是同步的，意味着在HTTP响应到达之前，当前线程会被阻塞。

  ```java
  // in VaccinationCenter Service 启动类
  // 步骤一：创建RestTemplate实例
  @Bean
  public RestTemplate getRestTemplate() {
      return new RestTemplate();
  }
  
  // in VaccinationCenter Service Controller类
  // 步骤二： 发送请求并接收响应
  List<Citizen> citizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizens/getByCenter/" + centerId, List.class);
  ```

- **Async:** Kafka

### 5. Application Details stored in the service registry

- Service Name

- Service Metadata: such as version, environment

- URLs

- Health Condition: Up / Down
- Authentication and Authorization mechanisms