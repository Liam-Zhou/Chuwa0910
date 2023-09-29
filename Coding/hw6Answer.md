### Database
sql and MongoDB database operations are performed via mySQLWorkBench and MongoDB Campass GUI.
Screen shots of the operations are included in the short answer folder.

### API examples:
Get: 
get random picture of dog: https://dog.ceo/api/breeds/image/random 
get information about countries: https://restcountries.com/v3.1/name/norway

Post: 
https://jsonplaceholder.typicode.com/posts
Json Request body:
```json
{
  "title": "foo",
  "body": "bar",
  "userId": 1
}
```

Put(updating):
https://jsonplaceholder.typicode.com/posts/1
Json request body:
```json
{
  "title": "Updated Title",
  "body": "Updated Content",
  "userId": 1,
  "id": 1
}
```

Delete(Similar to put but there's no request body):

https://jsonplaceholder.typicode.com/posts/1
request type: Delete


### API design
API for a Blog Website:
get: GET http://myblog/posts/:postID
post: POST http://myblog/posts
```jason
{
  "title": "Post Title",
  "content": "Post Content",
  "authorId": "123",
  "tags": ["tag1", "tag2"]
}
```
put: PUT http://myblog/post/:postID
```jason
{
  "title": "Updated Title",
  "content": "Post Content",
  "authorId": "123",
  "tags": ["tag1", "tag2"]
}
```
delete: DELETE /posts/:postID

find the customer's payment, like credit card or paypal
GET https://shoppingcart/customers/5/payments

find the customer's history order from 10/10/2022 to 10/24/2022
GET https://shoppingcart/customers/5/orders?startDate=2022-10-10&endDate=2022-10-24

find the customer's delievery address: 
GET https://shoppingcart/customers/5/addresses





