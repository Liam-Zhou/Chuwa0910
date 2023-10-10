
#### API Design 

##### 1. Find 2 collection example. ie. Twitter, Paypal, Youtube etc. -- 命名规范
> - Twitter: https://www.postman.com/twitter/workspace/twitter-s-public-workspace/collection/9956214-784efcda-ed4c-4491-a4c0-a26470a67400?action=share&creator=29411339
> - Paypal: https://www.postman.com/paypal/workspace/paypal-public-api-workspace/collection/19024122-92a85d0e-51e7-47da-9f83-c45dcb1cdf24?action=share&creator=29411339
##### 2.  Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
> Retrieve a List of Blog Posts
>> GET: /api/posts

>Create a New Blog Post
>> POST: /api/posts

>Retrieve a Specific Blog Post
>> GET: /api/posts/{post_id}

> Update an Existing Blog Post
>> PUT: /api/posts/{post_id}

> Delete a Blog Post
>> DELETE: /api/posts/{post_id}

> Retrieve Comments for a Blog Post
>> GET: /api/posts/{post_id}/comments

> Create a New Comment for a Blog Post
>> POST: /api/posts/{post_id}/comments

> Update an Existing Comment
>> PUT: /api/comments/{comment_id}

> Delete a Comment
>> DELETE: /api/comments/{comment_id}

##### Design APIs for the following features (思考：path variable 怎么用？有sub resources, 哪些地方该用复数)
###### 1.  find the customer's payments, like credit card 1, credit card 2, paypal, Apple Pay.
> GET /api/customers/{userid}/payments
###### 2.  Find the customer's history orders from 10/10/2022 to 10/24/2022
> GET /api/customers/{userid}/orders?start-date="10/10/2022"&end-date="10/24/2022"
###### 3.  find the customer's delievery  addresses
> GET /api/customers/{userid}/addresses
###### 4.  If I also want to get customer's default payment and default delievery address, what kind of the API (URL) should be?
> GET /api/customers/{userid}/payments/default
> GET /api/customers/{userid}/addresses/default