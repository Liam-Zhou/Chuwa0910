# Database
## MySQL - Relational Database
### Exercise
1. Create ```oms_company_address``` table.

    ```
    CREATE TABLE IF NOT EXISTS `oms_company_address` (
      `id` BIGINT NOT NULL,
      `address_name` VARCHAR(200),
      `send_status` INT(1),
      `receive_status` INT(1),
      `name` VARCHAR(64),
      `phone` VARCHAR(64),
      `province` VARCHAR(64),
      `city` VARCHAR(64),
      `region` VARCHAR(64),
      `detail_address` VARCHAR(200),
      PRIMARY KEY(`id`)
    );
    ```

2. Insert some random data to ```oms_company_address``` table.

    ```
    INSERT INTO `oms_company_address`
    (`id`, `address_name`)
    VALUES
    (1, '171 Hemenway ST.'),
    (2, '172 Hemenway ST.');
    ```

3. Write a SQL query to fetch all data from ```oms_company_address``` table.

    ```
    SELECT * 
    FROM `oms_company_address`;
    ```

4. Write a SQL query to fetch top 3 records from ```oms_company_address``` table.

    ```
    SELECT *
    FROM `oms_company_address`
    ORDER BY id DESC
    LIMIT 3;
    ```

5. Update ```oms_company_address``` table to set all phone to 666-6666-8888.

    ```
    UPDATE `oms_company_address`
    SET phone = '666-6666-8888';
    ```

6. Delete one entry from ```oms_company_address``` table.

    ```
    DELETE FROM `oms_company_address`
    WHERE id = 1;
    ```

7. (Optional) You can also try to create other tables that listed above.

    ```
    CREATE TABLE IS NOT EXISTS `oms_order_setting` (
      `id` BIGINT NOT NULL,
      `normal_order_overtime` INT,
      `comfirm_overtime` INT,
      `finish_overtime` INT,
      `comment_overtime` INT,
      PRIMARY KEY(`id`)
    );
    ```

## MongoDB - Non-SQL Database
### Exercise

1. Create ```test```  DB.

    ```
    use test
    ```

2. Create ```oms_company_address``` collection (method: createCollection()).

    ```
    db.createCollection("oms_company_address")
    ```

3. Insert few random entries to ```oms_company_address``` collection (method: insert()).

    ```
    db.oms_company_address.insert([
      {address_name: "171 Hemenway ST", phone: "123-456-7890", city: "Boston"},
      {address_name: "172 Hemenway ST", phone: "987-654-3210", city: "Boston"},
    ])
    ```

4. Read one entry from ```oms_company_address``` collection (method: find()).

    ```
    db.oms_company_address.findOne()
    ```

5. Readd all entry from ```oms_company_address``` collection (method: find()).

    ```
    db.oms_company_address.find()
    ```

6. Update one entry from ```oms_company_address``` collection (method: update() or save()).

    ```
    db.oms_company_address.update(
      {address_name: "171 Hemenway ST"}, 
      {$set: {phone: "111-222-3333"}}
    )
    ```

7. Remove one entry from ```oms_company_address``` collection (method: remove()).

    ```
    db.oms_company_address.remove({address_name: "171 Hemenway ST"})
    ```

8. (Optional) You can also try to create other tables that listed above.

# REST API
### Postman

1. 5 GET APIs with different response type.
 
    1. GET https://www.google.com 200 OK
    2. GET https://www.google.com/thispagedoesnotexist 404 NOT FOUND
    3. GET https://122.gov.cn 405 NOT ALLOWED
    4. GET https://httpstat.us/403 403 FORBIDDEN
    5. GET https://httpstat.us/503 503 SERVICE UNAVAILABLE

2. 5 Post API with json request body, please also paste the response here.

    1. POST https://jsonplaceholder.typicode.com/posts
       
       - Request Body
         ```
         {
          "title": "foo",
          "body": "bar",
          "userId": 1
         }
         ```
       - Response
         ```
         {
          "title": "foo",
          "body": "bar",
          "userId": 1,
          "id": 101
         }
         ```

    2. POST https://reqres.in/api/users
    
       - Request Body
         ```
         {
           "name": "morpheus",
           "job": "leader"
         }
         ```
       - Response
         ```
         {
           "name": "morpheus",
           "job": "leader",
           "id": "719",
           "createdAt": "2023-09-18T21:37:29.167Z"
         }
         ```
    
    3. POST https://httpbin.org/post
    
       - Request Body
         ```
         {
           "name": "Alice",
           "age": 25
         }
         ```
       - Response
         ```
         {
           "args": {}, 
           "data": "{\"name\":\"Alice\",\"age\":25}", 
           "files": {}, 
           "form": {}, 
           "headers": {
             "Accept": "*/*", 
             "Content-Length": "30", 
             "Content-Type": "application/json", 
             "Host": "httpbin.org", 
             "User-Agent": "curl/7.64.1", 
             "X-Amzn-Trace-Id": "Root=1-61b155f3-2b4556531d8f5f4d4de25d91"
           }, 
           "json": {
             "age": 25, 
             "name": "Alice"
           }, 
           "origin": "73.162.151.228, 73.162.151.228", 
           "url": "https://httpbin.org/post"
         }
         ```
    
    4. POST  https://your-custom-endpoint.beeceptor.com
    
       - Request Body
         ```
         {
           "hello": "world"
         }
         ```
       - Response
         ```
         {
           "hello": "world"
         }
         ```
    
    5. POST https://postman-echo.com/post
    
       - Request Body
         ```
         {
           "data": {
             "name": "John",
             "age": 30,
             "city": "New York"
           }
         }
         ```
       - Response
         ```
         {
           "args": {},
           "data": {},
           "files": {},
           "form": {},
           "headers": {
             "x-forwarded-proto": "https",
             "x-forwarded-port": "443",
             "host": "postman-echo.com",
             "x-amzn-trace-id": "Root=1-6514ec18-54c53cb643b50531607a056e",
             "content-length": "0",
             "user-agent": "PostmanRuntime/7.30.0",
             "accept": "*/*",
             "cache-control": "no-cache",
             "postman-token": "863cb18c-ab88-4dae-9841-594148957814",
             "accept-encoding": "gzip, deflate, br"
           },
           "json": null,
           "url": "https://postman-echo.com/post"
         }
         ```

3. 3 PUT API with json request body, please also paste the response here.

    1. PUT https://jsonplaceholder.typicode.com/posts/1
       
       - Request Body
         ```
         {
           "id": 1,
           "title": "Updated Title",
           "body": "Updated body text",
           "userId": 1
         }
         ```
       - Response
         ```
         {
           "id": 1,
           "title": "Updated Title",
           "body": "Updated body text",
           "userId": 1
         }
         ```
       
    2. PUT https://reqres.in/api/users/2
       
       - Request Body
         ```
         {
           "name": "morpheus",
           "job": "zion resident"
         }
         ```
       - Response
         ```
         {
           "name": "morpheus",
           "job": "zion resident",
           "updatedAt": "2023-09-18T21:37:29.167Z"
         }
         ```
       
    3. PUT https://httpbin.org/put
       
       - Request Body
         ```
         {
           "name": "Alice",
           "job": "Engineer"
         }
         ```
       - Response
         ```
         {
           "args": {}, 
           "data": "{\"name\":\"Alice\",\"job\":\"Engineer\"}", 
           "files": {}, 
           "form": {}, 
           "headers": {
             "Accept": "*/*", 
             "Content-Length": "36", 
             "Content-Type": "application/json", 
             "Host": "httpbin.org", 
             "User-Agent": "curl/7.64.1", 
             "X-Amzn-Trace-Id": "Root=1-61b155f3-2b4556531d8f5f4d4de25d91"
           }, 
           "json": {
             "job": "Engineer", 
             "name": "Alice"
           }, 
           "origin": "73.162.151.228, 73.162.151.228", 
           "url": "https://httpbin.org/put"
         }
         ```

4. 2 DELETE API.

    1. DELETE https://jsonplaceholder.typicode.com/posts/1   
    2. DELETE https://reqres.in/api/users/2

5. Each example with 404, 501, 500 and any http status codes you know.

    1. 501 Not Implemented
       
       This means the request method is not supported by the server and cannot be handled.
       
    2. 500 Internal Server Error
       
       A generic error message, given when an unexpected condition was encountered.
    
    3. 404 Not Found
    
       This status code is returned when the requested resource could not be found on the server.
    
    4. 502 Bad Gateway
       
       The server was acting as a gateway or proxy and received an invalid response from the upstream server.
       
    5. 504 Gateway Timeout
       
       The server, while acting as a gateway or proxy, did not receive a timely response from an upstream server or some other auxiliary server.

### API Design

1. Find 2 collection of APIs example, ie. Twitter, Paypal, Youtube, etc.

    1. Twitter APIs:
       
       - GET https://api.twitter.com/2/tweets/{id}
       - POST https://api.twitter.com/2/tweets
       - PUT https://api.twitter.com/2/users/{id}
       - DELETE https://api.twitter.com/2/tweets/{id}
    
    2. PayPal APIs:
       
       - GET https://api.paypal.com/v1/payments/payment/{payment_id}
       - POST https://api.paypal.com/v1/payments/payment
       - PUT https://api.paypal.com/v1/invoicing/invoices/{invoice_id}
       - DELETE https://api.paypal.com/v1/vault/credit-card/{credit_card_id}

2. Design a collection of APIs for a Blog Website, please specify GET, POST, PUT, DELETE. 

    1. Posts APIs:

       - GET /api/posts - Retrieve all posts
       - POST /api/posts - Create a new post
       - PUT /api/posts/{post_id} - Update a specific post by ID
       - DELETE /api/posts/{post_id} - Delete a specific post by ID

    2. Comments APIs:

       - GET /api/posts/{post_id}/comments - Retrieve all comments of a post
       - POST /api/posts/{post_id}/comments - Create a new comment on a post
       - PUT /api/comments/{comment_id} - Update a specific comment by ID
       - DELETE  /api/comments/{comment_id} - Delete a specific comment by ID

**Design APIs for the following features:**

1. Find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.

    ```
    GET /api/customers/{customer_id}/payments
    ```
 
2. Find the customer’s history orders from 10/10/2022 to 10/24/2022.

    ```
    GET /api/customers/{customer_id}/orders?start_date=2022-10-10&end_date=2022-10-24
    ```
 
3. Find the customer’s delivery address.

    ```
    GET /api/customers/{customer_id}/addresses
    ```

4. If I also want to get customer’s default payment and default delivery address, what kind of the API (URL) should be?

    ```
    GET /api/customers/{customer_id}/default-payment
    GET /api/customers/{customer_id}/default-address
    ```
