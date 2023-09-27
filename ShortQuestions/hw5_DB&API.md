DataBase

1.
use CreatetestDB

2.
db.createCollection("oms_company_address")

3.
db.oms_company_address.insert([
  {company: "公司A", address: "地址A", city: "城市A", zip: "12345"},
  {company: "公司B", address: "地址B", city: "城市B", zip: "67890"},
  {company: "公司C", address: "地址C", city: "城市C", zip: "11223"}
])

4.
db.oms_company_address.find().limit(1)

5.
db.oms_company_address.find()

6.
db.oms_company_address.update(
  {company: "公司A"},
  {$set: {address: "新地址A"}}
)

var doc = db.oms_company_address.findOne({company: "公司A"});
doc.address = "新地址A";
db.oms_company_address.save(doc);

7.
db.oms_company_address.remove({company: "公司A"})

8.
db.createCollection("oms_company_contact")

API Example

API-GET-1:
https://restcountries.com/v3.1/all
status: 200OK

API-GET-2:
https://restcountries.com/v3.1/all/abc
status: 404 Not Found


API-GET-3:
https://ghibliapi.herokuapp.com/locations
status: 503 Service Unavailable

API-GET-4:
https://jsonplaceholder.typicode.com/posts
status: 200OK

API-GET-5:
https://dog.ceo/api/breeds/list/all
status: 200OK

API-POST-1:
https://jsonplaceholder.typicode.com/posts

request body
{
  "title": "foo",
  "body": "bar",
  "userId": 1
}

status: 200 OK

response
{
    "title": "foo",
    "body": "bar",
    "userId": 1,
    "id": 101
}


API-POST-2:
https://jsonplaceholder.typicode.com/posts

request body
{
  "title": "foo",
  "body": "bar",
  "userId": 1,
  "email":song2392823910@gmail.com
}

status: 500Internal Server Error

response
SyntaxError: Unexpected token s in JSON at position 62
at JSON.parse (<anonymous>)
	at parse (/app/node_modules/body-parser/lib/types/json.js:89:19)
	at /app/node_modules/body-parser/lib/read.js:121:18
	at invokeCallback (/app/node_modules/body-parser/node_modules/raw-body/index.js:224:16)
	at done (/app/node_modules/body-parser/node_modules/raw-body/index.js:213:7)
	at IncomingMessage.onEnd (/app/node_modules/body-parser/node_modules/raw-body/index.js:273:7)
	at IncomingMessage.emit (node:events:525:35)
	at endReadableNT (node:internal/streams/readable:1358:12)
	at processTicksAndRejections (node:internal/process/task_queues:83:21)

API-POST-3:
https://jsonplaceholder.typicode.com/posts

request body
{
  "title": "foo",
  "body": "bar",
}

status: 201 Created

response
{
    "title": "foo",
    "body": "bar",
    "id": 101
}


API-POST-4:
https://jsonplaceholder.typicode.com/posts/abc

request body
{
  "title": "foo",
  "body": "bar",
}

status: 404Not Found

response
{

}


API-POST-5:
https://google.com

request body
{
  "title": "foo",
  "body": "bar",
}

status: 405Method Not Allowed

response
<!DOCTYPE html>
<html lang=en>
  <meta charset=utf-8>
  <meta name=viewport content="initial-scale=1, minimum-scale=1, width=device-width">
  <title>Error 405 (Method Not Allowed)!!1</title>
  <style>
    *{margin: 0;padding: 0
}html,code{font: 15px/22px arial,sans-serif
}html{background:#fff;color:#222;padding: 15px
}body{margin: 7% auto 0;max-width: 390px;min-height: 180px;padding: 30px 0 15px
}* > body{background:url( //www.google.com/images/errors/robot.png) 100% 5px no-repeat;padding-right:205px}p{margin:11px 0 22px;overflow:hidden}ins{color:#777;text-decoration:none}a img{border:0}@media screen and (max-width:772px){body{background:none;margin-top:0;max-width:none;padding-right:0}}#logo{background:url(//www.google.com/images/branding/googlelogo/1x/googlelogo_color_150x54dp.png) no-repeat;margin-left:-5px}@media only screen and (min-resolution:192dpi){#logo{background:url(//www.google.com/images/branding/googlelogo/2x/googlelogo_color_150x54dp.png) no-repeat 0% 0%/100% 100%;-moz-border-image:url(//www.google.com/images/branding/googlelogo/2x/googlelogo_color_150x54dp.png) 0}}@media only screen and (-webkit-min-device-pixel-ratio:2){#logo{background:url(//www.google.com/images/branding/googlelogo/2x/googlelogo_color_150x54dp.png) no-repeat;-webkit-background-size:100% 100%}}#logo{display:inline-block;height:54px;width:150px}
  </style>
  <a href= //www.google.com/><span id=logo aria-label=Google></span></a>
  <p><b>405.</b> <ins>That’s an error.</ins>
  <p>The request method <code>POST</code> is inappropriate for the URL <code>/</code>.  <ins>That’s all we know.</ins>

API-PUT-1:
https://jsonplaceholder.typicode.com/posts/1

Request Body
{
  "id": 1,
  "title": "foo updated",
  "body": "bar",
  "userId": 1
}

status:200OK
response:
{
    "id": 1,
    "title": "foo updated",
    "body": "bar",
    "userId": 1
}

API-PUT-2:
https://jsonplaceholder.typicode.com/posts/1/abc

Request Body
{
  "id": 1,
  "title": "foo updated",
  "body": "bar",
  "userId": 1
}

status:404Not Found

response:
{

}

API-PUT-3:
https://ghibliapi.herokuapp.com/locations

Request Body
{
  "id": 1,
  "title": "foo updated",
  "body": "bar",
  "userId": 1
}

status:503Service Unavailable

response:
<!DOCTYPE html>
	<html>
	  <head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta charset="utf-8">
		<title>Application Error</title>
		<style media="screen">
		  html,body,iframe {
			margin: 0;
			padding: 0;
}
		  html,body {
			height: 100%;
			overflow: hidden;
}
		  iframe {
			width: 100%;
			height: 100%;
			border: 0;
}
		</style>
	  </head>
	  <body>
		<iframe src="//www.herokucdn.com/error-pages/application-error.html"></iframe>
	  </body>
	</html>

Delete-API-1:
https://jsonplaceholder.typicode.com/posts/1

status:200OK

Delete-API-2:
https://google.com

status:405Method Not Allowed

status:200OK

API Design
1.
Twitter API
GET /2/timeline/:id.json
POST /2/tweets

YouTube
GET    /youtube/v3/playlistItems
POST  /youtube/v3/playlistItems


2.

1).
GET /customers/:customerId/payments

GET /customers/:customerId/payments/creditcard1

2).
GET /customers/:customerId/orders?startDate=2022-10-10&endDate=2022-10-24

3).
GET /customers/:customerId/addresses
GET /customers/:customerId/addresses/:addressId

4).
GET /customers/:customerId/default-payment
GET /customers/:customerId/default-address


