# HW6

## MySQL Questions

### 1.  Create  oms_company_address  table 
```sql
create table `oms_company_address` (
	`id` bigint not null,
    `address_name` varchar(200),
    `send_status` int(1),
    `receive_status` int(1),
    `name` varchar(64),
    `phone` varchar(64),
    `province` varchar(64),
    `city` varchar(64),
    `region` varchar(64),
    `detail_address` varchar(200),
    primary key (`id`));
```

### 2.  Insert some random data to  oms_company_address  table
```sql
insert into oms_company_address (id, address_name, send_status) 
values (1, "CA", 1), (2, "CA", 0), (3, "WA", 0); 
```

### 3.  Write a SQL query to fetch all data from  oms_company_address  `table 
```sql
select * from oms_company_address;
```

### 4.  Write a SQL query to fetch top 3 records from  oms_company_address  table 
```sql
select * from oms_company_address order by id asc limit 3;
```

### 5.  Update  oms_company_address  table to set all  phone to 666-6666-8888
```sql
update oms_company_address set phone = "666-6666-8888";
```

### 6.  Delete one entry from  oms_company_address  table
```sql
delete from oms_company_address where id = 1
```

## MongoDB Questions
### 1.  Create  test DB 
```
use test
```

### 2.  Create  oms_company_address  collection  (method: createCollection() )
```
db.createCollection("oms_company_addess")
```
### 3.  Insert few random entries to  oms_company_address  collection (method: insert() )
```
db.oms_company_address.insert([
    {id: 1, address_name: "CA"},
    {id: 2, address_name: "WA", send_status: 1}
])
```

### 4.  Read one entry from  oms_company_address  collection (method: find() )
```
db.oms_company_address.find({id: 1})
```

### 5.  Read all entries from  oms_company_address  collection (method: find() )
```
db.oms_company_address.find()
```

### 6.  Update one entry from  oms_company_address collection (method: update() or save() )
```
db.oms_company_address.update({id: 1}, {$set: {address_name: "WA}})
```

### 7.  Remove one entry from  oms_company_address collection (method: remove() )
```
db.oms_company_address.remove({id: 2})
```

## API Examples
- GET https://api.waifu.pics/sfw/neko 
    - status: 200
    - response: 
    ``` json
    {
        "url": "https://i.waifu.pics/IL-llQG.jpg"
    }
    ```
- GET https://google.com
    * status: 200
    * response: html of google homepage (too long)

- GET https://google.com/google
    * status: 404

- GET https://zenquotes.io/api/today
    * status: 200
    * response:
    ```json
    [
    {
        "q": "No man is free who is not master of himself.",
        "a": "Epictetus",
        "h": "<blockquote>&ldquo;No man is free who is not master of himself.&rdquo; &mdash; <footer>Epictetus</footer></blockquote>"
    }
    ]
    ```

- GET https://wizard-world-api.herokuapp.com/Spells?Type=CounterSpell
    * status: 200
    * response: 
    ```json
    [
    {
        "id": "d7ebf72c-9c63-4745-b4fe-d4f6b8a71b04",
        "name": "General Counter-Spell",
        "incantation": "Finite Incantatem",
        "effect": "Terminates all spell effects",
        "canBeVerbal": true,
        "type": "CounterSpell",
        "light": "Red",
        "creator": null
    }
    ]
    ```

## API design
- get all blogs from a user: GET http://myblog.com/{user_id}/blogs
- get one blog from a user given blog id: GET http://myblog.com/{user_id}/blogs/{blog_id}
- post new blog: POST http://myblog.com/{user_id}/blogs
- edit existing blog: UPDATE http://myblog.com/{user_id}/blogs/{blog_id}

1.  find the customer's payments, like credit card 1, credit card 2, paypal, Apple Pay.
GET http://mystore.com/{user_id}/payments
2.  Find the customer's history orders from 10/10/2022 to 10/24/2022
GET http://mystore.com/{user_id}/orders?start_date="10/10/2022"&end_date="10/24/2022"
3.  find the customer's delievery  addresses
GET http://mystore.com/{user_id}/addresses
4.  If I also want to get customer's default payment and default delievery address, what kind of the API (URL) should be?
GET http://mystore.com/{user_id}/payments/default
GET http://mystore.com/{user_id}/addresses/default