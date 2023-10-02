### 1. 5 get api with different responses

`GET` : https://www.youtube.com/ `Status code` : 200;

`GET` : https://www.youtube.com/1112 `Status code` : 404 NOT FOUND;

`GET` : https://httpstat.us/500 `Status code` : 500 Internal Server Error;

`GET` : http://httpbin.org/post `Status code` : 405 METHOD NOT ALLOWED;

`GET` : https://s3.amazonaws.com/your-bucket-name/your-object-key `Status Code` : 403Forbidden;



### API Design

1. Find 2 collection of APIs example, ie. Twitter, Paypal, Youtube, etc.


    1. PayPal APIs:
       
       * GET https://api.paypal.com/v1/payments/payment/{payment_id}
       * POST https://api.paypal.com/v1/payments/payment
       * PUT https://api.paypal.com/v1/invoicing/invoices/{invoice_id}
       * DELETE https://api.paypal.com/v1/vault/credit-card/{credit_card_id}
      
    2. Twitter APIs:
       
       * GET https://api.twitter.com/2/tweets/{id}
       * POST https://api.twitter.com/2/tweets
       * PUT https://api.twitter.com/2/users/{id}
       * DELETE https://api.twitter.com/2/tweets/{id}

2.	Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

   
    `GET`

* /blogs: Get a list of all blogs.
* /blogs/:id: Get a specific blog by ID.
* /blogs/:id/posts: Get a list of all posts for a specific blog.
* /blogs/:id/posts/:id: Get a specific post by ID.
* /blogs/:id/categories: Get a list of all categories for a specific blog.
* /blogs/:id/categories/:id: Get a specific category by ID.
* /blogs/:id/tags: Get a list of all tags for a specific blog.
* /blogs/:id/tags/:id: Get a specific tag by ID.
  
   `POST`

* /blogs: Create a new blog.
* /blogs/:id/posts: Create a new post for a specific blog.
* /blogs/:id/categories: Create a new category for a specific blog.
* /blogs/:id/tags: Create a new tag for a specific blog.

  
   `PUT`

* /blogs/:id: Update a specific blog.
* /blogs/:id/posts/:id: Update a specific post.
* /blogs/:id/categories/:id: Update a specific category.
* /blogs/:id/tags/:id: Update a specific tag.
  
   `DELETE`

* /blogs/:id: Delete a specific blog.
* /blogs/:id/posts/:id: Delete a specific post.
* /blogs/:id/categories/:id: Delete a specific category.
* /blogs/:id/tags/:id: Delete a specific tag.
