### 1. 5 get api with different responses

`GET` : https://www.youtube.com/ `Status code` : 200;

`GET` : https://www.youtube.com/1112 `Status code` : 404 NOT FOUND;

`GET` : https://httpstat.us/500 `Status code` : 500 Internal Server Error;

`GET` : http://httpbin.org/post `Status code` : 405 METHOD NOT ALLOWED;

`GET` : https://s3.amazonaws.com/your-bucket-name/your-object-key `Status Code` : 403Forbidden;

### 2. 5 Post API with json request body, please also paste the response here

1. Create a new user

```
POST /api/users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "mypassword"
}
```

Response:

```
HTTP/1.1 201 Created
Content-Type: application/json

```
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "createdAt": "2023-10-01T22:48:40.000Z"
}

2. Update a user's profile

```
PUT /api/users/1
Content-Type: application/json

{
  "name": "Jane Doe"
}
```

Response:

```
HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": 1,
  "name": "Jane Doe",
  "email": "john.doe@example.com",
  "updatedAt": "2023-10-01T22:48:40.000Z"
}
```

3. Create a new product

```
POST /api/products
Content-Type: application/json

{
  "name": "My Product",
  "description": "This is a great product!",
  "price": 19.99
}
```

Response:

```
HTTP/1.1 201 Created
Content-Type: application/json

{
  "id": 1,
  "name": "My Product",
  "description": "This is a great product!",
  "price": 19.99,
  "createdAt": "2023-10-01T22:48:40.000Z"
}
```

4. Place an order

```
POST /api/orders
Content-Type: application/json

{
  "customer_id": 1,
  "product_ids": [1, 2, 3],
  "total": 59.97
}
```

Response:

```
HTTP/1.1 201 Created
Content-Type: application/json

{
  "id": 1,
  "customer_id": 1,
  "product_ids": [1, 2, 3],
  "total": 59.97,
  "status": "pending",
  "createdAt": "2023-10-01T22:48:40.000Z"
}
```

5. Send a message to a user

```
POST /api/users/1/messages
Content-Type: application/json

{
  "body": "Hello, world!"
}
```

Response:

```
HTTP/1.1 201 Created
Content-Type: application/json

{
  "id": 1,
  "sender_id": 1,
  "recipient_id": 1,
  "body": "Hello, world!",
  "createdAt": "2023-10-01T22:48:40.000Z"
}
```

### 3. PUT API with json request body, please also paste the response here 

1. Update a user's profile

```
PUT /api/users/1
Content-Type: application/json

{
  "name": "Jane Doe"
}
```

Response:

```
HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": 1,
  "name": "Jane Doe",
  "email": "john.doe@example.com",
  "updatedAt": "2023-10-01T22:48:40.000Z"
}
```

2. Update a product

```
PUT /api/products/1
Content-Type: application/json

{
  "name": "My Updated Product",
  "description": "This is a great product!",
  "price": 29.99
}
```
Response:

```
HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": 1,
  "name": "My Updated Product",
  "description": "This is a great product!",
  "price": 29.99,
  "updatedAt": "2023-10-01T22:48:40.000Z"
}
```

3. Update an order
```
PUT /api/orders/1
Content-Type: application/json

{
  "status": "shipped"
}
```

Response:
```
HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": 1,
  "customer_id": 1,
  "product_ids": [1, 2, 3],
  "total": 59.97,
  "status": "shipped",
  "updatedAt": "2023-10-01T22:48:40.000Z"
}
```

### API Design

1. Find 2 collection of APIs example, ie. Twitter, Paypal, Youtube, etc.


    1. PayPal APIs:
       
       * GET https://api.paypal.com/v1/payments/payment/{payment_id}
       * POST https://api.paypal.com/v1/payments/payment
       * PUT https://api.paypal.com/v1/invoicing/invoices/{invoice_id}
       * DELETE https://api.paypal.com/v1/vault/credit-card/{credit_card_id}
      
    2. Twitter APIs:
       
       * GET https://api.twitter.com/2/tweets/{id}
       * POST https://api.twitter.com/2/tweets
       * PUT https://api.twitter.com/2/users/{id}
       * DELETE https://api.twitter.com/2/tweets/{id}

2.	Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

   
    `GET`

* /blogs: Get a list of all blogs.
* /blogs/:id: Get a specific blog by ID.
* /blogs/:id/posts: Get a list of all posts for a specific blog.
* /blogs/:id/posts/:id: Get a specific post by ID.
* /blogs/:id/categories: Get a list of all categories for a specific blog.
* /blogs/:id/categories/:id: Get a specific category by ID.
* /blogs/:id/tags: Get a list of all tags for a specific blog.
* /blogs/:id/tags/:id: Get a specific tag by ID.
  
   `POST`

* /blogs: Create a new blog.
* /blogs/:id/posts: Create a new post for a specific blog.
* /blogs/:id/categories: Create a new category for a specific blog.
* /blogs/:id/tags: Create a new tag for a specific blog.

  
   `PUT`

* /blogs/:id: Update a specific blog.
* /blogs/:id/posts/:id: Update a specific post.
* /blogs/:id/categories/:id: Update a specific category.
* /blogs/:id/tags/:id: Update a specific tag.
  
   `DELETE`

* /blogs/:id: Delete a specific blog.
* /blogs/:id/posts/:id: Delete a specific post.
* /blogs/:id/categories/:id: Delete a specific category.
* /blogs/:id/tags/:id: Delete a specific tag.


### Design APIs for the following features

 ### `Find the customer's payments:`
  
To retrieve a list of customer's payments, you can use the following API endpoint:

- Endpoint: /customers/{customerId}/payments <br />
- HTTP Method: GET <br />
- Path Variable: {customerId} represents the unique identifier for the customer. <br />
- Response: A list of payment methods associated with the customer. <br />

 ###  `Find the customer's history orders from 10/10/2022 to 10/24/2022:` <br />
- To retrieve the customer's historical orders within a specific date range, you can use the following API endpoint:

- Endpoint: /customers/{customerId}/orders <br />
- HTTP Method: GET <br />
- Path Variable: {customerId} represents the unique identifier for the customer. <br />
- Query Parameters: startDate=10/10/2022 and endDate=10/24/2022 <br />
- Response: A list of orders placed by the customer between the specified dates. <br />

###  `Find the customer's delivery addresses:` <br />
- To retrieve a list of customer's delivery addresses, you can use the following API endpoint:<br />

- Endpoint: /customers/{customerId}/addresses<br />
- HTTP Method: GET<br />
- Path Variable: {customerId} represents the unique identifier for the customer.<br />
- Response: A list of delivery addresses associated with the customer.<br />

 ### `Get customer's default payment and default delivery address:`<br />
- To retrieve the customer's default payment method and default delivery address, you can use the following API endpoint:<br />

- Endpoint: /customers/{customerId}/defaults<br />
- HTTP Method: GET<br />
- Path Variable: {customerId} represents the unique identifier for the customer.<br />
- Response: An object containing the customer's default payment method and default delivery address.<br />
