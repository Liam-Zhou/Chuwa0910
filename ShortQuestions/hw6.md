### Postman  
take below examples,
1. 5 GET APIs with different response type
    * API: GET https://api.github.com/repos/{owner}/{repo}
   ```json
   {
   "id": 1296269,
   "node_id": "MDEwOlJlcG9zaXRvcnkxMjk2MjY5",
   "name": "Hello-World",
   "full_name": "octocat/Hello-World",
   ...
   }
   ```
   * API: GET https://api.openweathermap.org/data/2.5/weather?q={city}&appid={API_KEY}
   ```json
   {
   "coord": {
   "lon": -0.1257,
   "lat": 51.5085
   },
   "weather": [{
   "id": 804,
   "main": "Clouds",
   "description": "overcast clouds",
   ...
   }],
   ...
   }
   ```
    * API: GET https://dog.ceo/api/breeds/image/random
   ```json
    {
    "message": "https://images.dog.ceo/breeds/hound-ibizan/n02100877_10808.jpg",
    "status": "success"
    }
   ```
    * API: GET https://restcountries.com/v3.1/name/{country}
   ```json
    [
    {
    "name": {
    "common": "Canada",
    ...
    },
    "flags": [...],
    ...
    }
    ]
   ```
    * API: GET https://v2.jokeapi.dev/joke/any
   ```json
    {
    "error": false,
    "category": "Programming",
    "type": "single",
    "joke": "Why do programmers prefer dark mode? Because the light attracts bugs!",
    ...
    }
   ```
2. 5 Post API with json request body, please also paste the response here 
* API: POST https://jsonplaceholder.typicode.com/posts
* Request Body:
```json
{
  "title": "foo",
  "body": "bar",
  "userId": 1
}
```
* Response:
```json
    {
  "title": "foo",
  "body": "bar",
  "userId": 1,
  "id": 101
}

```
* API: POST https://reqres.in/api/register
* Request Body:
```json
 {
  "email": "eve.holt@reqres.in",
  "password": "pistol"
}

```
* Response:
```json
    {
  "id": 4,
  "token": "QpwL5tke4Pnpja7X4"
}

```

* API:POST https://reqres.in/api/users
*  Request Body:
```json
{
  "name": "morpheus",
  "job": "leader"
}
```
* Response:
```json
    {
  "name": "morpheus",
  "job": "leader",
  "id": "539",
  "createdAt": "2023-10-10T21:13:28.824Z"
}

```

* API: POST https://httpbin.org/post
* Request Body:
```json
{
"sampleKey": "sampleValue"
}

```
* Response:
```json
  {
  "args": {},
  "data": "{\"sampleKey\":\"sampleValue\"}",
  "files": {},
  "form": {},
  ...
}

```

* API: POST https://jsonplaceholder.typicode.com/comments
* Request Body:
```json
    {
  "postId": 1,
  "name": "sample name",
  "email": "name@example.com",
  "body": "comment body content here"
}

```
* Response:
```json
    {
  "postId": 1,
  "name": "sample name",
  "email": "name@example.com",
  "body": "comment body content here",
  "id": 501
}

```

3. 3 PUT API with json request body, please also paste the response here
* API:PUT https://jsonplaceholder.typicode.com/posts/1
* Request Body:
```json
    {
  "id": 1,
  "title": "Updated title",
  "body": "Updated body content",
  "userId": 1
}

```
* Response:
```json
    {
  "id": 1,
  "title": "Updated title",
  "body": "Updated body content",
  "userId": 1
}

```
* API:PUT https://reqres.in/api/users/2
* Request Body:
```json
    {
  "name": "morpheus updated",
  "job": "zion resident"
}

```
* Response:
```json
    {
  "name": "morpheus updated",
  "job": "zion resident",
  "updatedAt": "2023-10-10T21:25:43.511Z"
}

```
* API:PUT https://httpbin.org/put
* Request Body:
```json
    {
  "sampleKey": "newValue"
}

```
* Response:
```json
    {
  "args": {},
  "data": "{\"sampleKey\":\"newValue\"}",
  "files": {},
  "form": {},
  ...
}

```
4. 2 DELETE API

* API: DELETE https://jsonplaceholder.typicode.com/posts/1
* API: DELETE https://reqres.in/api/users/2

### API Design
1.  Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范
    * Twitter:

        GET /statuses/home_timeline.json - fetches a collection of the latest Tweets and retweets posted by the user and the users they follow.
        POST /statuses/update.json - posts a new tweet.
    * YouTube:
        GET /youtube/v3/channels - returns a collection of channels that match the API request parameters.
        POST /youtube/v3/channels - creates a new channel.
2.  Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
    ## Posts:

**Fetch all posts:**
- **Method:** GET
- **Endpoint:** `/posts`

**Fetch a specific post by ID:**
- **Method:** GET
- **Endpoint:** `/posts/{postId}`

**Create a new post:**
- **Method:** POST
- **Endpoint:** `/posts`

**Update a post:**
- **Method:** PUT
- **Endpoint:** `/posts/{postId}`

**Delete a post:**
- **Method:** DELETE
- **Endpoint:** `/posts/{postId}`

## Comments:

**Fetch all comments for a specific post:**
- **Method:** GET
- **Endpoint:** `/posts/{postId}/comments`

**Add a comment to a post:**
- **Method:** POST
- **Endpoint:** `/posts/{postId}/comments`

**Update a comment:**
- **Method:** PUT
- **Endpoint:** `/comments/{commentId}`

**Delete a comment:**
- **Method:** DELETE
- **Endpoint:** `/comments/{commentId}`

## Categories:

**Fetch all categories:**
- **Method:** GET
- **Endpoint:** `/categories`

**Add a new category:**
- **Method:** POST
- **Endpoint:** `/categories`

**Update a category:**
- **Method:** PUT
- **Endpoint:** `/categories/{categoryId}`

**Delete a category:**
- **Method:** DELETE
- **Endpoint:** `/categories/{categoryId}`

## Users:

**Fetch all users:**
- **Method:** GET
- **Endpoint:** `/users`

**Register a new user:**
- **Method:** POST
- **Endpoint:** `/users`

**Update user details:**
- **Method:** PUT
- **Endpoint:** `/users/{userId}`

**Delete a user:**
- **Method:** DELETE
- **Endpoint:** `/users/{userId}`


1.  find the customer's payments, like credit card 1, credit card 2, paypal, Apple Pay.
- **Method:** GET
- **Endpoint:** `/customers/{customerId}/payments`
2.  Find the customer's history orders from 10/10/2022 to 10/24/2022
- **Method:** GET
- **Endpoint:** `/customers/{customerId}/orders?startDate=10/10/2022&endDate=10/24/2022`
3.  find the customer's delievery  addresses
- **Method:** GET
- **Endpoint:** `/customers/{customerId}/addresses`
4.  If I also want to get customer's default payment and default delievery address, what kind of the API (URL)
    should be?
- **Method:** GET
- **Endpoint:** `/customers/{customerId}/payments/default`


### MySQL 

# Step 1: Table Creation
```sql
CREATE TABLE oms_company_address (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
address_name VARCHAR(200),
send_status TINYINT(1),
receive_status TINYINT(1),
name VARCHAR(64),
phone VARCHAR(64),
province VARCHAR(64),
city VARCHAR(64),
region VARCHAR(64),
detail_address VARCHAR(200)
);
```
# Step 2: Data Insertion
```sql
INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
...
('address_10', 0, 0, 'J', '888-888-8888', 'province_9', 'city_9', 'region_9', 'detail_address_9');
```

# Step 3: Data Retrieval
```sql 
SELECT * FROM oms_company_address;
```

# Step 4: Limiting Data Retrieval
```sql
SELECT * FROM oms_company_address LIMIT 3;
```

# Step 5: Data Update
```sql
UPDATE oms_company_address SET phone = '666-6666-8888';
```
# Step 6: Data Deletion
Remove a specific entry.
```sql
DELETE FROM oms_company_address WHERE id = 1;
```

###  MongoDB
1.  Create  test DB
```javascript
use test
```
2.  Create  oms_company_address  collection  (method: createCollection() )
``` javascript
db.createCollection("oms_company_address")

```
3.  Insert few random entries to  oms_company_address  collection (method: insert() )
``` javascript
db.oms_company_address.insert([
    {...}, // entry 1
    {...}, // entry 2
    // ... add more sample entries
])

```
4.  Read one entry from  oms_company_address  collection (method: find() )
``` javascript
db.oms_company_address.find({ "_id": ObjectId("specific_id_here") }).pretty()

```
5.  Read all entries from  oms_company_address  collection (method: find() )
``` javascript
db.oms_company_address.find().pretty()

```
6.  Update one entry from  oms_company_address collection (method: update() or save() )
``` javascript
db.oms_company_address.update(
   { "_id": ObjectId("specific_id_here") },
   {
     $set: {
       "field_to_update": "new_value"
     }
   }
)

```
7.  Remove one entry from  oms_company_address collection (method: remove() )
``` javascript
db.oms_company_address.remove({ "_id": ObjectId("specific_id_here") })

```
