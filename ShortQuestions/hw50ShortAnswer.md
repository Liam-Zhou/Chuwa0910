### 2. microservice design architecture.
Microservice is an architecture design pattern that splits the large application into small and independent service based applications. Each team work on their individual microservice.

### 3. Resilience patterns & Circuit breaker.
Resilience pattern ensure the operation of microservice.
Time out. Timeout prevents a microservice from waiting too long for another microservice.
Circuit breaker. If a system call results in an error, the circuit breaker is opened and does not allow any calls to pass through.

### 4. Unable to access the article!!

### 5. Load balancer.
Load balancer decide which request should be routed to which server; it distributes the set of requested operations across servers and ensures no single server bears too many request. Here are some of its advantages: Load balancers minimize server response time and maximize throughput. Load balancer ensures high availability and reliability by sending requests only to online servers. Load balancers do continuous health checks to monitor the server's capability of handling the request. Depending on the number of requests or demand load balancers add or remove the number of servers. Load balancer could be placed between anywhere among the client aplication, server, cache servers or the database servers.

### 6. How to do service discovery?
Service discovery automatically detect and keep track of deployed services. It's important to keep track of microservice instances.
Here's a few ways to manage the services:
Dynamic Management of services: Microservices can be frequently relocated to different servers or ports to balance loads and optimize resource use. 
Client-Side vs. Server-Side Discovery: Client-Side: responsible for determing the location of the service instances and load balancing the requets.
Server-Side Discovery: Central server responsible for tracking the service instances and directing client requests to available instances. 
Registry-Based Discovery: Service registries used as database of services, instances, and their locations, registering themselves with a registry on startup and deregister on shutdown. For example, Eureka.

### 7. Kafka
Kafka is a design pattern based on publish/subscribe model to provide high-throughput, low-latency platform for handling real-time data feeds. Here are some of its core components: 
Producer: publish messages to Kafka topics.
Topic: Category or feed name messages are published. Kafka stores and categorizes messages using topics.
Consumer: subscribe to topics and proccess the feed of published messages.
Broker: Clusteres consist of one or more servers, each of which is called a broker. Responsible for maintaining the published data. 
Partition: topics split into partitions to allow for data to be spread across multiple brokers for scalability. Partition could be placed on separate machine to allow multiple consumers to read from a topic in parallel.
Offset: unique identifier of messages within a partition to denotes the position of a consumer.
Zookeeper: For managing and coordinating Kafka brokers. Used to notify the presence of any new broker. Notify producers/consumers about the new broker.
