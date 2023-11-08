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
