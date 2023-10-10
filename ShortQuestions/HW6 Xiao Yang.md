# HW6 Xiao Yang

## 1. MySQL Exercise

### 1.1 Create `oms_company_address` table.

```sql
CREATE DATABASE ChuwaTest;

USE ChuwaTest;

CREATE TABLE oms_company_address (
    id bigint not null,
    address_name varchar(200),
    send_status int(1),
    receive_status int(1),
    name varchar(64),
    phone varchar(64),
    province varchar(64),
    city varchar(64),
    region varchar(64),
    detail_address varchar(200)
);
```

### 1.2 Insert some random data to `oms_company_address` table.

```sql
INSERT INTO oms_company_address
VALUES (1, "Santa Clara XXXX", 0, 0, "something name", "408-xxx-xxx", "CA", "Santa Clara", "USA", "Santa Clara XXXX");

INSERT INTO oms_company_address
VALUES (2, "San Jose XXXX", 0, 0, "something name", "408-xxx-xxx", "CA", "San Jose", "USA", "San Jose XXXX");

INSERT INTO oms_company_address
VALUES (3, "New York XXXX", 1, 0, "something name", "408-xxx-xxx", "New York", "New York", "USA", "New York XXXX");

INSERT INTO oms_company_address
VALUES (4, "Shanghai XXXX", 0, 1, "something name", "159-xxxx-xxxx", "Shanghai", "Shanghai", "China", "Shanghai XXXX");
```

### 1.3 Write a SQL query to fetch all data from `oms_company_address` table.

```sql
SELECT * FROM oms_company_address;
```

### 1.3 Write a SQL query to fetch top 3 records from  `oms_company_address `table

```sql
SELECT * FROM oms_company_address LIMIT 3; 
```

### 1.4 Update `oms_company_address` table to set all  phone to 666-6666-88
```sql
UPDATE oms_company_address SET phone = "666-6666-88";
```

### 1.5 Delete one entry from  `oms_company_address`  table
```sql
DELETE FROM oms_company_address WHERE city = "New York";
```

## 2. MongoDB Execise

### 2.1 Create ```test```  DB.
    ``` 
    use test
    ```
### 2.2 Create ```oms_company_address``` collection (method: createCollection()).
    ```
    db.createCollection("oms_company_address")
    ```
### 2.3 Insert few random entries to ```oms_company_address``` collection (method: insert()).
    ```
    db.oms_company_address.insert([
      {address_name: "Santa Clara XXXX", phone: "408-xxx-xxx", city: "Santa Clara"},
      {address_name: "San Jose XXXX", phone: "408-xxx-xxx", city: "San Jose"},
    ])
    ```
### 2.4 Read one entry from ```oms_company_address``` collection (method: find()).
    ```
    db.oms_company_address.findOne()
    ```
### 2.5 Readd all entry from ```oms_company_address``` collection (method: find()).
    ```
    db.oms_company_address.find()
    ```
### 2.6 Update one entry from ```oms_company_address``` collection (method: update() or save()).
    ```
    db.oms_company_address.update(
      {address_name: "Santa Clara XXXX"}, 
      {$set: {phone: "666-666-666"}}
    )
    ```
### 2.7 Remove one entry from ```oms_company_address``` collection (method: remove()).
    ```
    db.oms_company_address.remove({address_name: "Santa Clara XXXX"})
    ```

2. REST API Exercise

### 2.1 5 GET APIs with different response type.

- GET https://www.google.com/ 200;
- GET https://www.google.com/1 404 NOT FOUND;
- GET http://localhost:8080/api/v1/posts 500 500 Internal Server Error;
- GET https://httpstat.us/403 403 403 Forbidden;
- GET https://httpstat.us/400 400 400 Bad Request;

### 2.2 5 Post API with json request body, please also paste the response here.

1. POST https://jsonplaceholder.typicode.com/posts
       
       - Request Body
         ```
         {
            {
                "title": "test title",
                "body": "test body",
                "userId": 1
            }
         }
         ```
       - Response
         ```
         {
            "title": "test title",
            "body": "test body",
            "userId": 1,
            "id": 101
         }
         ```

### 2.3 PUT API with json request body, please also paste the response here.
    1. PUT https://jsonplaceholder.typicode.com/posts/1
       
       - Request Body
         ```
         {
           "id": 1,
           "title": "Test Updated Title",
           "body": "Test Updated body text",
           "userId": 1
         }
         ```
       - Response
         ```
         {
           "id": 1,
           "title": "Test Updated Title",
           "body": "Test Updated body text",
           "userId": 1
         }
         ```

### 2.4 2 DELETE API.
    - DELETE https://jsonplaceholder.typicode.com/posts/1

### 2.5 Each example with 404, 501, 500 and any http status codes you know.
    - 404 Not Found
       This status code means the requested resource could not be found on the server.

    - 501 Not Implemented
       This means the request method is not supported by the server and cannot be handled.
       
    - 500 Internal Server Error
       
       A generic error message, given when an unexpected condition was encountered and could not be handled.
    
    - 200 Success
       
       This status code means everything going well.
       
    - 504 Gateway Timeout
       
       The server, while acting as a gateway or proxy, did not receive a timely response from an upstream server or some other auxiliary server.

### 2.6 API Design
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

