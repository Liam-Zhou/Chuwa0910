******************************************
Q1. MySQL part

1. Create oms_company_address table

       CREATE TABLE `sys`.`oms_company_address` (
       `id` BIGINT NOT NULL,
       `address` VARCHAR(20) NULL,
       `send_status` INT(1) NULL,
       `receive_status` INT(1) NULL,
       `name` VARCHAR(64) NULL,
       `phone` VARCHAR(64) NULL,
       `province` VARCHAR(64) NULL,
       `city` VARCHAR(64) NULL,
       `region` VARCHAR(64) NULL,
       `detail_address` VARCHAR(200) NULL,
       PRIMARY KEY (`id`));

2. Insert some random data to oms_company_address table
    

        INSERT INTO `sys`.`oms_company_address`(id, address, city) VALUES (11, "Jersey City", "NJ")
        INSERT INTO `sys`.`oms_company_address_test` values (1,2,3,4,5,6,7,8,9,10);
        INSERT INTO `sys`.`oms_company_address_test` values (2,2,3,4,5,6,7,8,9,10);
        INSERT INTO `sys`.`oms_company_address_test` values (3,2,3,4,5,6,7,8,9,10);
        INSERT INTO `sys`.`oms_company_address_test` values (4,2,3,4,5,6,7,8,9,10);
        INSERT INTO `sys`.`oms_company_address_test` values (5,2,3,4,5,6,7,8,9,10);
        INSERT INTO `sys`.`oms_company_address_test` values (6,2,3,4,5,6,7,8,9,10);
        INSERT INTO `sys`.`oms_company_address_test` values (7,2,3,4,5,6,7,8,9,10);


3. Write a SQL query to fetch all data from oms_company_address `table

        SELECT * FROM `sys`.`oms_company_address

4. Write a SQL query to fetch top 3 records from oms_company_address table

       SELECT *
       FROM oms_company_address
       ORDER BY id
       LIMIT 3;

5. Update oms_company_address table to set all phone to 666-6666-8888


        UPDATE oms_company_address
        SET phone = '666-6666-8888';

6. Delete one entry from oms_company_address table
    
        DELETE FROM `sys`.`oms_company_address`
        WHERE id = 3;

MongoDB Part

1. Create test DB
` use test`
2. Create oms_company_address collection (method: createCollection() )
`db.createCollection("oms_company_address")   `

3. Insert few random entries to oms_company_address collection (method: insert() )


      db.oms_company_address.insertOne({
         id:1,
         address_name: "california",
         send_status: 0,
         receive_status: 1,
         name: "Yi",
         phone: "3404039209",
         province: "CA",
         city: "newark",
         region: "na",
         detail_address: "null",
      })

4. Read one entry from oms_company_address collection (method: find() )
`db.oms_company_address.findOne();`

5. Read all entries from oms_company_address collection (method: find() )
   `db.oms_company_address.find();`
6. Update one entry from oms_company_address collection (method:update() or save()) 
`db.oms_company_address.updateOne({ "name": "Alice" }, { $set: { "age": 31 } );`
7. Remove one entry from oms_company_address collection (method:remove())
  ` db.oms_company_address.deleteOne({"name":"Yi"});`
******************************************
Q2. Postman : See postman.json file

1. 5 GET APIs with different response type
   1. GET www.airchina.us/ status: 200 OK
   2. GET www.google.com/chuwaicc status: 404 not found
   3. GET httpstat.us/403 status:403 Forbidden
   4. GET httpstat.us/502 status:502 Bad Gateway
   5. Get httpstat.us/503 status:503 Service Unavailable

2. 5 Post API with json request body, please also paste the response here
   1. register-successful: /api/register
      response: 200
   

         {
         "email": "eve.holt@reqres.in",
         "password": "pistol"
         }
   
         {
         "id": 4,
         "token": "QpwL5tke4Pnpja7X4"
         }

   2. create: /api/users
      response: 201


      {
      "name": "morpheus",
      "job": "leader"
      }
      {
      "name": "morpheus",
      "job": "leader",
      "id": "817",
      "createdAt": "2023-09-28T22:13:43.010Z"
      }
   3. register-unsuccessful: /api/register
      response: 400 (Bad Request)


      {
      "email": "sydney@fife"
      }

      {
      "error": "Missing password"
      }
   4. login-successful: /api/login
      response: 200


      {
      "email": "eve.holt@reqres.in",
      "password": "cityslicka"
      }
      
      {
      "token": "QpwL5tke4Pnpja7X4"
      }
   5. login-unsuccessful: /api/login
      response: 400


      {
      "email": "peter@klaven"
      }
      {
      "error": "Missing password"
      }

3. 3 PUT API with json request body, please also paste the response here
   1. update: /api/users/2
      response:200


      {
      "name": "morpheus",
      "job": "zion resident"
      }
      {
      "name": "morpheus",
      "job": "zion resident",
      "updatedAt": "2023-09-28T22:18:07.292Z"
      }
4. 2 DELETE API
   1. DELETE http://www.google.com status: 403 Method Not Allowed
   2. DELETE http://www.airchina.us status:200 OK
5. Each example with 404, 401,500 and any http status codes you know
> 404 Not found, 401 Unauthorized, 500 Internal Server Error. 
******************************************
Q3.

1. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  
> Twitter: https://developer.twitter.com/en/docs/twitter-api

>Paypal: https://developer.paypal.com/api/rest/requests/

2. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
   Design APIs for the following features (思考：path variable 怎么用？有sub resources, 哪些地方该用复数)

POST:
>Create a new blog : /user/user_id/create

GET: 
> Get All Blog: /user/user_id/blogs

> Get a specific blog: /user/user_id/blogs: blog_id

PUT:
> Update a Blog blog: /user/user_id/blogs

DELETE:
> Delete a Blog blog: /user/user_id/blogs: blog_id

3. find the customer's payments, like credit card 1, credit card 2, paypal, Apple Pay
> GET /api/users/{user_id}/payments/{payment_method: like apple pay, credit card }

4. find the customer's history orders from 10/10/2022 to 10/24/2022
> GET /api/users/{user_id}/history?start-date="10/10/2022" & end-date="10/24/2022"

5. find the customer's delievery  addresses
> GET /api/users/{user_id}/address

6. If I also want to get customer's default payment and default delievery address, what kind of the API should be? 
> GET /api/users/{user_id}/payment/default-payment
> 
> GET /api/users/{user_id}/payment/default-address

      {
         "customer_id": "12345",
         "name": "John Doe",
         "email": "john.doe@example.com",
         "default_payment_address": {
            "address_id": "98765",
            "street": "123 Main St",
            "city": "Anytown",
            "state": "CA",
            "postal_code": "12345"
         },
         "default_delivery_address": {
            "address_id": "54321",
            "street": "456 Elm St",
            "city": "Another Town",
            "state": "NY",
            "postal_code": "54321"
         }
      }
