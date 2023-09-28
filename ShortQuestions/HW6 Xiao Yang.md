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
