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





### 6. Transactions in micro-services

在不同微服务之间管理整个事务是一项挑战，因为微服务架构的分布式特性。与单体应用不同，在单体应用中实现单个数据库的ACID事务相对直接，微服务通常使用独立的数据库并独立运行。为了确保在失败的情况下跨服务保持数据一致性，你可以使用以下几种策略：

### **方法一：Saga模式**

Saga模式是一系列本地事务的序列，其中每个事务更新单个服务内的数据，并发布消息或事件以触发另一个服务中的下一个本地事务。Saga可以通过两种方式实现：

- **编排（Orchestration）**：一个中央编排者（一个服务或一组服务）告诉参与的服务执行哪些本地事务。编排者跟踪事务的执行顺序。

- **编舞（Choreography）**：每个服务产生和监听事件，自行决定何时执行其操作。没有中央协调，而是每个服务知道它需要处理哪个事件以及接下来要做什么。

**在Saga模式中回滚**

为了处理失败，Saga中的每个本地事务都应该有一个**补偿事务（compensating transactions）**来撤销其效果。如果本地事务失败，Saga会按**相反顺序执行之前成功的事务的补偿事务**，以维护数据一致性。

### **方法二：两阶段提交（2PC，Two-Phase Commit）**

两阶段提交协议是一个分布式算法，它协调参与事务的所有服务要么提交要么回滚更改。它有两个阶段：

- **准备阶段**：事务管理器要求所有参与服务为事务准备（锁定资源并确认准备就绪）。
- **提交/回滚阶段**：根据所有服务的响应，事务管理器决定如果所有服务都准备好了则提交事务，如果任何服务没有准备好则回滚。

然而，由于2PC的同步性质，它可能导致性能瓶颈和服务之间的耦合增加，因此在微服务中不经常使用。

### 实现回滚

在微服务架构中实现回滚功能通常依赖于补偿事务或为每个服务定义的特定补偿动作。由于直接回滚（如单体应用中的回滚）不可行，所以重点是确保整个系统即使意味着**执行额外的操作来“撤销”跨服务的事务效果**，也能返回到一致的状态。

选择合适的策略取决于你的应用程序的具体需求，包括一致性需求、性能和复杂性。由于其灵活性和与微服务架构原则的一致性，Saga是最常用的方法。