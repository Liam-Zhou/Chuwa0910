1: Create  oms_company_address  table

```sql
CREATE TABLE `oms_company_address` (
                                       `id` bigint NOT NULL,
                                       `address_name` varchar(200),
                                       `send_status` int(1),
                                       `receive_status` int(1),
                                       `name` varchar(64),
                                       `phone` varchar(64),
                                       `province` varchar(64),
                                       `city` varchar(64),
                                       `region` varchar(64),
                                       `detail_address` varchar(200),
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci; 
```

2: Insert some random data to  oms_company_address  table
```sql
insert into oms_company_address
(id)
values
(1);
```

3: Write a SQL query to fetch all data from  oms_company_address  `table
```sql
SELECT * from oms_company_address;
```

4:  Write a SQL query to fetch top 3 records from oms_company_address table

```sql
select * from oms_company_address limit 3;
```
5:Update oms_company_address table to set all phone to 666-6666-8888
```sql
update oms_company_address set phone = '666-6666-8888';
```

6: Delete one entry from oms_company_address table
```sql
delete from oms_company_address where id = 1;
```

1:  Create  test DB
```sql
use test
```

2: Create  oms_company_address  collection
```sql
db.createCollection("oms_company_address")


```

3: Insert few random entries to  oms_company_address  collection
```sql

db.oms_company_address.insert([
	{"name": "1"},
	{"name": "2"},
])
```

4: Read one entry from  oms_company_address  collection (
```sql
db.oms_company_address.findOne()
```

5: Read all entries from  oms_company_address  collection

```sql
db.oms_company_address.find()
```

6: Update one entry from  oms_company_address collection 
```sql
db.oms_company_address.update(
	{"name": "1"},
	{
		$set: {name: "11"}
	}
)
```
7:  Remove one entry from  oms_company_address collection
```sql
db.oms_company_address.remove({"name": "11"})
```

1: 5 GET APIs with different response type
```text
200:
fetch('https://fakestoreapi.com/products/category/jewelery')
            .then(res=>res.json())
            .then(json=>console.log(json))
404:
https://github.com/xxxxxxxxxxxxxxxaa
500:
http://localhost/500
401:
http://localhost/401
403:
http://localhost/403
```

2: 5 POST APIs with different response type
```text
POST /api/user
{
"name": "a"
}
Response: {
"status": 201
}
POST /api/product
{
"name": "a"
}
Response: {
"status": 201
}
POST /api/category
{
"name": "a"
}
Response: {
"status": 201
}
POST /api/order
{
"name": "a"
}
Response: {
"status": 201
}
POST /api/message
{
"name": "a"
}
Response: {
"status": 201
}
```

2: 3 PUT APIs with different response type
```text
PUT /api/user/1
{
"name": "a"

}
Response: {
"status": 200
}
PUT /api/product/1
{
"name": "a"
}
Response: {
"status": 200
}
PUT /api/order/1
{
"name": "a"
}
Response: {
"status": 200
}

```

3: 2 DELETE APIs with different response type
```text
DELETE /api/user/1
{

}
Response: {
"status": 200
}
DELETE /api/product/1
{
"name": "a"
}
Response: {
"status": 200
}

```

1: Find 2 collection of APIs example
```text
https://developers.google.com/youtube/v3
https://developers.facebook.com/docs/instagram/
```

2: Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
```text
post blog: POST /blogs/{id}

review blog: GET /blogs/{id}

update blog: PUT /blogs/{id}

delete blog: DELETE /blogs/{id}
```

3: find the customer's payments, like credit card 1, credit card 2, paypal, Apple Pay.
```text
GET /api/v1/users/{id}/payments?method=card1
```

4:  Find the customer's history orders from 10/10/2022 to 10/24/2022
GET /api/v1/users/{id}/history?start-date=10%2F10%2F2022%0A&end-date=10%2F24%2F2022

5: find the customer's delievery  addresses
GET /api/v1/users/{id}/address?option=delivery

6: If I also want to get customer's default payment and default delievery address, what kind of the API (URL)should be?

GET /api/v1/users/{id}?defaults=payments%2Caddress