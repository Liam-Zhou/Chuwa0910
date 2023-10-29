# HW6 - Grace Hu

## Database

### MySQL Database Exercise

#### 1. Create oms_company_address table
    
    create table exercise.oms_company_address(
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
    
#### 2. Insert some random data to oms_company_address table

    INSERT INTO exercise.oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
    VALUES
        (1, 'Office Address', 1, 0, 'Company A', '123-456-7890', 'Province A', 'City A', 'Region A', '123 Main Street'),
        (2, 'Warehouse Address', 0, 1, 'Company B', '987-654-3210', 'Province B', 'City B', 'Region B', '456 Oak Street'),
        (3, 'Office Address', 1, 1, 'Company C', '555-123-4567', 'Province C', 'City C', 'Region C', '789 Pine Street');

#### 3. Write a SQL query to fetch all data from oms_company_address `table

    SELECT * FROM exercise.oms_company_address;

#### 4. Write a SQL query to fetch top 3 records from oms_company_address table

    SELECT * FROM exercise.oms_company_address
    LIMIT 3;

#### 5. Update oms_company_address table to set all phone to 666-6666-8888

    UPDATE exercise.oms_company_address
    SET phone = '666-6666-8888';
    
#### 6. Delete one entry from oms_company_address table

    DELETE FROM exercise.oms_company_address
    WHERE id = 4;


#### 7. (Optional) You can also try to create other tables that listed above

### MongoDB - Non-SQL Database Exercise

#### 1. Create test DB

    use test

#### 2. Create oms_company_address collection (method: createCollection() )

    db.createCollection("oms_company_address")

#### 3. Insert few random entries to oms_company_address collection (method: insert() )

    db.oms_company_address.insert([
    {
        id: 1,
        address_name: "Company A",
        send_status: 1,
        receive_status: 0,
        name: "John Doe",
        phone: "123-456-7890",
        province: "California",
        city: "Los Angeles",
        region: "West",
        detail_address: "123 Main St"
    },
    {
        id: 2,
        address_name: "Company B",
        send_status: 0,
        receive_status: 1,
        name: "Jane Smith",
        phone: "987-654-3210",
        province: "New York",
        city: "New York City",
        region: "East",
        detail_address: "456 Elm St"
    },
])

#### 4. Read one entry from oms_company_address collection (method: find() )

    db.oms_company_address.findOne({ id: 1 })

#### 5. Read all entries from oms_company_address collection (method: find() )

    db.oms_company_address.find()

#### 6. Update one entry from oms_company_address collection (method: update() or save() )

    db.oms_company_address.update(
    { id: 1 },
    { $set: { phone: "666-6666-8888" } }
)

#### 7. Remove one entry from oms_company_address collection (method: remove() )

    db.oms_company_address.remove({ id: 2 })

#### 8. (Optional) You can also try to create other tables that listed above

## REST API

### Postman

- 5 GET APIs with different response type
    1. API: GET https://www.google.com
        
        status code: 200 OK

    2. API: GET https://jsonplaceholder.typicode.com/posts/1000
        
        status code: 404 Not Found

    3. API: GET https://httpstat.us/403
        
        status code: 403 Forbidden

    4. API: GET https://httpstat.us/500
        
        status code: 500 Internal Server Error

    5. API: GET https://httpbin.org/status/401
        
        status code: 401 UNAUTHORIZED

- 5 Post API with json request body, please also paste the response here

    1. API: POST https://jsonplaceholder.typicode.com/posts

        Request Body:
        {
            "title": "foo",
            "body": "bar",
            "userId": 1
        }

        Response:
        {
            "id": 101
        }

        status code: 201 Created

    2. API: POST https://reqres.in/api/users

        Request Body:
        {
            "name": "Grace",
            "job": "Developer"
        }

        Response:
        {
            "id": "826",
            "createdAt": "2023-10-01T03:13:03.200Z"
        }

        status code: 201 Created

    3. API: POST https://api.github.com/user/repos

        Request Body:
        {
            "name": "my-repo"
        }

        Response:
        {
            "message": "Requires authentication",
            "documentation_url": "https://docs.github.com/rest/repos/repos#create-a-repository-for-the-authenticated-user"
        }

        status code: 401 Unauthorized

    4. API: POST https://api.openweathermap.org/data/3.0/stations

        Request Body:
        {
            "external_id": "DEMO_TEST001",
            "name": "Weather Station",
            "latitude": 35.0,
            "longitude": -105.0,
            "altitude": 100
        }


        Response:
        {
            "cod": 401,
            "message": "Invalid API key. Please see https://openweathermap.org/faq#error401 for more info."
        }

        status code: 401 Unauthorized

    5. API: POST https://jsonplaceholder.typicode.com/comments

        Request Body:
        {
            "postId": 1,
            "name": "John Doe",
            "email": "john.doe@example.com",
            "body": "This is a great post!"
        }

        Response:
        {
            "id": 501
        }

        status code: 201 Created

- 3 PUT API with json request body, please also paste the response here
    
    1. API: PUT https://jsonplaceholder.typicode.com/posts/1

        Request Body:
        {
            "userId": 1,
            "id": 1,
            "title": "Updated Title",
            "body": "Updated body content."
        }

        Response:
        {
            "id": 1
        }

        status code: 200 OK

    2. API: PUT https://reqres.in/api/users/2

        Request Body:
        {
            "name": "Updated User",
            "job": "Engineer"
        }

        Response:
        {
            "updatedAt": "2023-10-01T03:25:41.285Z"
        }

        status code: 200 OK

    3. API: PUT https://api.github.com/gists/nonexistent-gist-id

        Request Body:
        {
            "name": "Updated User",
            "job": "Engineer"
        }

        Response:
        {
            "message": "Not Found",
            "documentation_url": "https://docs.github.com/rest"
        }

        status code: 404 Not Found

- 2 DELETE API

    1. API: DELETE https://jsonplaceholder.typicode.com/comments/1

        Request Body

        Response: {}

        status code: 200 OK

    2. API: DELETE http://www.google.com

        Request Body: N/A (Since it's a DELETE request)

        Response: 405 Method Not Allowed

### API Design
1. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- name convention

    Paypal: https://developer.paypal.com/api/rest/requests/
    Youtube: https://developers.google.com/youtube/v3/docs

2. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

Design APIs for the following features (思考：path variable 怎么⽤？有sub resources, 哪些地⽅该⽤复数)
#### 1. find the customer's payments, like credit card 1, credit card 2, paypal, Apple Pay.

    GET /api/users/{customerId}/payments

#### 2. Find the customer's history orders from 10/10/2022 to 10/24/2022

    GET /api/users/123/orders?startDate=2022-10-10&endDate=2022-10-24

#### 3. find the customer's delievery addresses
    
    GET /api/users/123/addresses

#### 4. If I also want to get customer's default payment and default delievery address, what kind of the API (URL) should be?

    GET /api/users/123/defaults

#### Response Body Example:
    {
        "customerId": "123",
        "defaultPayment": {
            "paymentId": "payment-1",
            "cardType": "Visa",
            "lastFourDigits": "1234"
        },
        "defaultDeliveryAddress": {
            "addressId": "address-1",
            "street": "123 Main St",
            "city": "Berkeley",
            "state": "CA",
            "postalCode": "12345"
        }
    }

