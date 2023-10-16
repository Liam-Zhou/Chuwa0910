
#Mysql
1.  Create  oms_company_address  table
```sql
create table `oms_company_address` (
	`id` int,
    `address_name` varchar(200),
    `send_status` int,
    `receive_status` int,
    `name` varchar(64),
    `phone` varchar(64),
    `province` varchar(64),
    `city` varchar(64),
    `region` varchar(64),
    `detail_address` varchar(200),
    primary key (`id`));
```

2.  Insert some random data to  oms_company_address  table
```sql
insert into oms_company_address (id, address_name, send_status) 
values (1, "1160 commonwealth ave.", 0), (2, "50 Chester St.",1); 
```

3.  Write a SQL query to fetch all data from oms_company_address table
```sql
select * from oms_company_address;
```

4.  Write a SQL query to fetch top 3 records from  oms_company_address  table
```sql
select * from oms_company_address order by id desc limit 3;
```

5.  Update  oms_company_address  table to set all  phone to 666-6666-8888
```sql
update oms_company_address set phone = "666-6666-8888";
```

6.  Delete one entry from  oms_company_address table
```sql
delete from oms_company_address where id = 1;
```

# MongoDB Questions
1.  Create test DB
> do it in panel
2.  Create  oms_company_address  collection  (method: createCollection() )
>  db.createCollection("oms_company_addess")
3.  Insert few random entries to  oms_company_address collection (method: insert() )
> db.oms_company_address.insert([
>     {id: 1, address_name: "1160 commonwealth ave.", send_status: 0},
>     {id: 2, address_name: "50 Chester St.", send_status: 1}
> ])

4.  Read one entry from  oms_company_address  collection (method: find() )
> db.oms_company_address.find({id: 1})

5.  Read all entries from  oms_company_address  collection (method: find() )
> db.oms_company_address.find()
6.  Update one entry from  oms_company_address collection (method: update() or save() )
> db.oms_company_address.update({id: 1}, {$set: {address_name: "specific address"}})

7.  Remove one entry from  oms_company_address collection (method: remove() )
> db.oms_company_address.remove({id: 1})

## API design
* Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
* get all: GET http://blog.com/{user_id}/blogs
* get one: GET http://blog.com/{user_id}/blogs/{blog_id}
* post: POST http://blog.com/{user_id}/blogs (with responseBody)
* update: UPDATE http://blog.com/{user_id}/blogs/{blog_id}

1.  find the customer's payments, like credit card 1, credit card 2, paypal, Apple Pay.
> http://customer.com/{user_id}/payments
2.  Find the customer's history orders from 10/10/2022 to 10/24/2022
> http://customer.com/{user_id}/orders?start_date="10/10/2022"&end_date="10/24/2022"
3.  find the customer's delivery addresses
> http://customer.com/{user_id}/addresses
4.  If I also want to get customer's default payment and default delievery address, what kind of the API (URL) should be?
> http://customer.com/{user_id}/payments/default
> <br><br>
> http://customer.com/{user_id}/addresses/default