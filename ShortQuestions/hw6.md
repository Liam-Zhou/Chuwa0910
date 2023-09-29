# HW6 - Ke Chen

## 1. MySQL Exercise
### 1. Create oms_company_address table
```
CREATE SCHEMA `DB_Practice` ;

USE DB_Practice;
CREATE Table oms_company_address(
    'id' BIGINT NOT NULL,
    'address_name' VARCHAR(200) NULL,
    'send_status' INT(1) NULL,
    'receive_status' INT(1) NULL,
    'name' VARCHAR(64) NULL,
    'phone' VARCHAR(64) NULL,
    'province' VARCHAR(64) NULL,
    'city' VARCHAR(64) NULL,
    'region' VARCHAR(64) NULL,
    'detail_address' VARCHAR(200) NULL,
    PRIMARY KEY('id')
);
```
### 2. Insert some random data to oms_company_address table
```
USE DB_Practice;
INSERT INTO oms_company_address VALUES
(1, 'hehualu', 0, 0, 'Ke Chen', '123', 'Hunan', 'Changsha', 'Furongqu', 'hehualu'),
(2, 'juhualu', 1, 0, 'Jack', '456', 'Fujian', 'Fuzhou', 'kaifuqu', 'juhualu')
(3, 'lianhualu', 1, 1, 'Tom', '789', 'Taiwan', 'Taibei', 'yueluqu', 'lianhualu'),
(4, 'guihualu', 0, 0, 'Olive', '098', 'Hubei', 'Wuhan', 'kaifuqu', 'guihualu');
```

### 3. Write a SQL query to fetch all data from oms_company_address table
```
SELECT *
FROM oms_company_address
LIMIT 3;
```

### 4. Write a SQL query to fetch top 3 records from oms_company_address table 
```
SELECT *
FROM oms_company_address
LIMIT 3;
```

### 5. Update oms_company_address table to set all  phone to 666-6666-8888
```
UPDATE oms_company_address
SET phone = '666-6666-8888';
```

### 6. Delete one entry from oms_company_address table
```
DELETE FROM oms_company_address
WHERE id = 1;
```

### 7. (Optional) You can also try to create other tables that listed above
Take table : oms_order_operate_history as an example
```
USE DB_Practice;
CREATE Table oms_order_operate_history(
    'id' BIGINT NOT NULL,
    'order_id' BIGINT NULL,
    'operate_man' VARCHAR(100) NULL,
    'create_time' DATETIME NULL,
    'order_status' INT NULL,
    'note' VARCHAR(500) NULL,
    PRIMARY KEY('id')
);
```
## 1. MongoDB Exercise

query syntax:  
官网：https://www.mongodb.com/docs/manual/crud/
辅助：https://databasefaqs.com/create-tables-in-mongodb/

### 1. Create test DB
```
use test
```
### 2. Create  oms_company_address  collection  (method: createCollection() )
```
db.createCollection("oms_company_address")
{ "ok" : 1 }
```

### 3. Insert few random entries to  oms_company_address  collection (method: insert() )
```
db.oms_company_address.insertMany([
    {id: 1, address_name: 'hehualu', send_status: 0, receive_status: 0, name: 'Ke Chen', phone: '123', province: 'Hunan', city: 'Changsha', region: 'Furongqu', detail_address: 'hehualu'},
    {id: 2, address_name: 'juhualu', send_status: 1, receive_status: 0, name: 'Jack', phone: '456', province: 'Fujian', city: 'Fuzhou', region: 'kaifuqu', detail_address: 'juhualu'}
])
```

### 4. Read one entry from  oms_company_address  collection (method: find() )
```
db.oms_company_address.findOne({ id: 1 })
```

### 5. Read all entries from  oms_company_address  collection (method: find() )
```
db.oms_company_address.find()
```

### 6. Update one entry from  oms_company_address collection (method: update() or save() )
```
db.oms_company_address.updateOne(
    {id: 2},
    {
        $set: {
            send_status : 1,
            phone: '234'
        }
    }
)
```

### 7. Remove one entry from  oms_company_address collection (method: remove() )
```
db.oms_company_address.deleteOne({ id: 1 })
```

### 8. (Optional) You can also try to create other tables that listed above
Take table : oms_order_operate_history as an example
```
db.createCollection("oms_order_operate_history")
{ "ok" : 1 }

db.oms_order_operate_history([
    {id: 1, order_id: 233, operate_man: 'Jack', create_time: 9/18/2023, order_status: 0, note: 'order 35'},
    {id: 2, order_id: 333, operate_man: 'Tom', create_time: 9/20/2023, order_status: 1, note: 'null'},
    {id: 3, order_id: 433, operate_man: 'Jack', create_time: 9/25/2023, order_status: 0, note: 'not null'},
])
```

## 2. Postman Exercise

### 1. 5 GET APIs with different response type

1
- with Text
![GET API with HTML type](/Users/kechen/Desktop/work/Chuwa0910/ShortQuestions/images/hw6-5)

https://www.ibm.com/topics/rest-apis
- with HTML

![GET API with HTML type](/Users/kechen/Desktop/work/Chuwa0910/ShortQuestions/images/hw6-1)
- same url with JSON

![GET API with JSON type](/Users/kechen/Desktop/work/Chuwa0910/ShortQuestions/images/hw6-2)
- same url with XML

![GET API with XML type](/Users/kechen/Desktop/work/Chuwa0910/ShortQuestions/images/hw6-3)
- same url with Text

![GET API with Text type](/Users/kechen/Desktop/work/Chuwa0910/ShortQuestions/images/hw6-4)

### 2. 5 Post API with json request body, please also paste the response here

https://ghibliapi.herokuapp.com/v2/checkout/orders
![POST API with JSON  type](/Users/kechen/Desktop/work/Chuwa0910/ShortQuestions/images/hw6-6)

https://ghibliapi.herokuapp.com/v2/checkout/orders/1
![POST API with JSON  type](/Users/kechen/Desktop/work/Chuwa0910/ShortQuestions/images/hw6-7)

https://ghibliapi.herokuapp.com/create-user
![POST API with JSON  type](/Users/kechen/Desktop/work/Chuwa0910/ShortQuestions/images/hw6-8)

https://ghibliapi.herokuapp.com/add-product
![POST API with JSON  type](/Users/kechen/Desktop/work/Chuwa0910/ShortQuestions/images/hw6-9)

https://ghibliapi.herokuapp.com/create-address
![POST API with JSON  type](/Users/kechen/Desktop/work/Chuwa0910/ShortQuestions/images/hw6-10)

### 3. 3 PUT API with json request body, please also paste the response here


### 4. 2 DELETE API

### 5. Each example with 404, 401,500 and any http status codes you know


## 3. API Design  
### 1.  Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范
***Twitter API***:
Twitter provides a collection of APIs for developers to interact with their platform. These APIs include functionality for posting tweets, retrieving user timelines, searching for tweets, and more. Example endpoints include:
- POST /statuses/update (Create a new tweet)
- GET /statuses/user_timeline (Get a user's timeline)
- GET /search/tweets (Search for tweets)

***PayPal API***:
PayPal offers a set of APIs for payment processing, allowing businesses to accept payments online. These APIs enable features like processing payments, managing subscriptions, and handling refunds. Example endpoints include:
- POST /v2/checkout/orders (Create a new payment order)
- GET /v2/payments/captures/{capture_id} (Retrieve payment capture details)
- POST /v1/billing/subscriptions (Create a new subscription)

### 2.  Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

Design APIs for the following features (思考：path variable 怎么用？有sub resources, 哪些地方该用复数)
### 1.  find the customer's payments, like credit card 1, credit card 2, paypal, Apple Pay.
GET /api/customers/{customer_id}/payments

    Description: Retrieve a list of the customer's payment methods.

    Example: /api/customers/123/payments
### 2.  Find the customer's history orders from 10/10/2022 to 10/24/2022
GET /api/customers/{customer_id}/orders

    Description: Retrieve a list of the customer's orders within a specified date range.

    Parameters:
    start_date (query parameter) - Start date for filtering orders (e.g., 10/10/2022)
    end_date (query parameter) - End date for filtering orders (e.g., 10/24/2022)

    Example: /api/customers/123/orders?start_date=2022-10-10&end_date=2022-10-24
### 3.  find the customer's delievery  addresses
GET /api/customers/{customer_id}/addresses

    Description: Retrieve a list of the customer's delivery addresses.

    Example: /api/customers/123/addresses
### 4.  If I also want to get customer's default payment and default delievery address, what kind of the API (URL) should be?
GET /api/customers/{customer_id}/defaults

    Description: Retrieve the customer's default payment method and default delivery address.
    
    Example: /api/customers/123/defaults
