1. Find 2 collection of APIs example 
   1. Paypal: https://developer.paypal.com/api/rest/requests/
   2. X: https://developer.twitter.com/en/docs/twitter-api/getting-started/getting-access-to-the-twitter-api
2. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELE
   1. For GET, `/blog/articles/{id}`
   2. For POST, `/blog/articles`, in body write the artcile and it will return the id. 
   3. For PUT, `/blog/articles/{id}`
   4. For Delete, `/blog/articles/{id}`
3. find the customer's payments, like credit card 1, credit card 2, paypal, Apple 
   ```
   GET /v2/users/{id}/payments/{credit_id}
   ```
4. Find the customer's history orders from 10/10/2022 to 10/24/2
    ```
    GET /v2/orders/{credit_id}/history?startDate="10/10/2022"&endDate="10/24/2"
    ```
5. find the customer's delievery  addresse
    ```
    GET /v2/users/{id}/delievery/addresss 
    ```
6. If I also want to get customer's default payment and default delievery address, what kind of the API (URL) should be?
    ```
    GET /v2/users/{id}
    ```
    or 
    ```
    {
        {id} {
            default_payment,
            default_address
        }
    }
    ```