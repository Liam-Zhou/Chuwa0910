# Difan Xue

## MySQL

```sql
CREATE DATABASE Chuwa;

USE Chuwa;

-- Create oms_company_address table
CREATE TABLE oms_company_address(
	id bigint primary key,
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

-- Insert some random data to oms_company_address table
insert into oms_company_address
(id, address_name, send_status,  receive_status, name, phone)
values
(101, 'a street', 1, 0, 'alice', '123-456-7890'),
(120, 'b street', 1, 1, 'bob', '123-456-7890'),
(121, 'c street', 1, 0, 'eddie', '000-000-0000'),
(122, 'a street', 1, 1, 'jason', '123-456-7890');

-- Write a SQL query to fetch all data from oms_company_address `table
select * from oms_company_address;

-- Write a SQL query to fetch top 3 records from oms_company_address table
select * from oms_company_address limit 3;

-- Update oms_company_address table to set all phone to 666-6666-8888
update oms_company_address set phone = '666-6666-8888';

-- Delete one entry from oms_company_address table
delete from oms_company_address where id = 101;
```

---

## MongDB

```sql
-- Creaet DB
use test

-- Create oms_company_address collection
db.createCollection("oms_company_address")

-- Insert few entries
db.oms_company_address.insert([
	{"name": "Jason", "address_name": "Los Angeles", "phone": "111-222-3333"},
	{"name": "Eddie", "address_name": "San Jose", "phone": "111-222-3333"},
	{"name": "Nick", "address_name": "Los Angeles", "phone": "123-456-7890"}
])

-- Read one entry from collection
db.oms_company_address.findOne()

-- Read all entries from collection
db.oms_company_address.find()

-- Update one entry
db.oms_company_address.update(
	{"name": "Jason"},
	{
		$set: {phone: "666-6666-8888"}
	}
)
-- Remove one entry
db.oms_company_address.remove({"name": "Nick"})
```

---

## Postman

- 5 GET APIs with different response type

GET [https://google.com](https://google.com/) → 200

GET [https://google.com](https://google.com/)/a → 404

GET https://httpstat.us/403 → 403

GET https://httpstat.us/405 →405

GET https://httpstat.us/500 → 500

- 5 Post API with json request body, please also paste the response here

POST /api/user

```sql
{
  "username": "new_user",
  "email": "new_user@example.com",
  "password": "password123"
}
```

response

```sql
{
  "message": "User created successfully",
  "user_id": 12345,
  "status": 201
}
```

POST /api/products

```sql
{
  "name": "",
  "description": "A sample product",
  "price": 19.99
}
```

response

```sql
{
  "message": "User created successfully",
  "user_id": 12345,
  "status": 201
}
```

POST /api/posts

```sql
{
  "title": "New Post",
  "content": "This is the content of the new post."
}
```

response

```sql
{
  "error": "Authorization error",
  "message": "Unauthorized access",
  "status": 401
}
```

POST /api/orders

```sql
{
  "customer_name": "John Doe",
  "product_id": "product123",
  "quantity": 2
}
```

response

```sql
{
  "error": "Internal server error",
  "message": "An error occurred while processing the request",
  "status": 500
}
```

POST /api/tasks

```sql
{
  "task_name": "Task A",
  "description": "Complete task A by Friday."
}
```

response

```sql
{
  "error": "Resource conflict",
  "message": "Task with the same name already exists",
  "status": 409
}
```

- 3 PUT API with json request body, please also paste the response here

PUT  api/users/12345

```sql
{
  "username": "updated_user",
  "email": "updated_user@example.com"
}
```

response

```sql
{
  "message": "User updated successfully",
  "status": 200
}
```

PUT  api/products/product123

```sql
{
  "name": "Updated Product",
  "description": "An updated product description"
}
```

response

```sql
{
  "error": "Resource not found",
  "message": "User with ID 'product123' not found",
  "status": 404
}
```

PUT  api/tasks/task789

```sql
{
  "task_name": "",
  "description": "An updated task description"
}
```

response

```sql
{
  "error": "Validation error",
  "message": "Task name is required",
  "status": 422
}
```

- 2 DELETE API

DELETE /api/user/12345

```sql
Status: 204 No Content
```

DELETE /api/posts/789

```sql
{
  "error": "Resource not found",
  "message": "Post with ID '789' not found",
  "status": 404
}
```

- Each example with 404, 401,500 and any http status codes you know
    - **404 Not Found**: This status code indicates that the requested resource could not be found on the server.
    - **501 Not Implemented**: It indicates that the server doesn't recognize or support the HTTP method used in the request.
    - **500 Internal Server Error**: This is a generic error message returned by the server when it encounters an unexpected condition that it cannot handle.
    - **200 Success**: This status code indicates that the request has been successfully processed, and the server is returning the expected response.
    - **504 Gateway Timeout**: This status code is typically returned when the server, acting as a gateway or proxy, did not receive a timely response from an upstream server or another auxiliary server.

## API Design

- Find 2 collection of APIs example

twitter: https://developer.twitter.com/en/docs/twitter-api

- Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

post blog: POST /blogs/{id}

review blog: GET /blogs/{id}

update blog: PUT /blogs/{id}

delete blog: DELETE /blogs/{id}

1. find the customer's payments, like credit card 1, credit card 2, paypal, Apple Pay.

GET /api/users/{user_id}/payments/{pay_id}
2. Find the customer's history orders from 10/10/2022 to 10/24/2022

GET /api/users/{user_id}/history?start-date="10/10/2022" & end-date="10/24/2022”
3. find the customer's delievery addresses

GET /api/users/{user_id}/addresses
4. If I also want to get customer's default payment and default delievery address, what kind of the API (URL)should be?

GET /api/users/{user_id}/payments/default-payment

GET /api/users/{user_id}/adresses/default-address