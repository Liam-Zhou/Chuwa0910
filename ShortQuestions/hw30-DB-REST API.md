# Homework 5 (HW30-DB&REST-APIs)

## take below examples

### 5 GET APIs with different response type

API GET `https://jsonplaceholder.typicode.com/todos/1`
response code: 200 OK

```
{
  "userId": 1,
  "id": 1,
  "title": "delectus aut autem",
  "completed": false
}
```

API GET `https://ghibliapi.herokuapp.com/locations`
response code: 503 Service Unavailable

```
<!DOCTYPE html>
<html>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">
	<title>Application Error</title>
	<style media="screen">
		html,
		body,
		iframe {
			margin: 0;
			padding: 0;
		}

		html,
		body {
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
```

API GET `https://catfact.ninja/fact`
response code: 200 OK

```
{
    "fact": "Cat paws act as tempetature regulators, shock absorbers, hunting and grooming tools, sensors, and more",
    "length": 102
}
```

API GET `https://api.genderize.io?name=luc`
response code: 422 Unprocessable Entity

```
{
    "error": "Missing 'name' parameter"
}
```

### 5 Post API with json request body, please also paste the response here

API POST `https://jsonplaceholder.typicode.com/posts`
response code: 201 Created

request body:

```
{
    "title": "foo",
    "body": "bar",
    "userId": 1
}
```

response body:

```
{
    "title": "foo",
    "body": "bar",
    "userId": 1,
    "id": 101
}
```

API POST `https://httpbin.org/post`
response code: 200 OK
request body:

```
{
    "title": "fo1",
    "body": "bar",
    "userId": "asd"
  }
```

response body:

```
{
    "args": {},
    "data": "{\n    \"title\": \"fo1\",\n    \"body\": \"bar\",\n    \"userId\": \"asd\"\n  }",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Content-Length": "64",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "5b3bfcf7-9356-47f7-903b-33a2715dcc69",
        "User-Agent": "PostmanRuntime/7.31.1",
        "X-Amzn-Trace-Id": "Root=1-651a5be4-170410ed07b9e72d3c11d03b"
    },
    "json": {
        "body": "bar",
        "title": "fo1",
        "userId": "asd"
    },
    "origin": "108.75.173.174",
    "url": "https://httpbin.org/post"
}
```

API POST `https://graph.facebook.com/{{api_version}}/{{ig_user_id}}/media?media_type=REELS&video_url={{video_url}}&caption=Hello World!&share_to_feed=false&access_token={{page_access_token}}`

response code: 400 Bad Request

response body:

```
{
    "error": {
        "message": "Invalid OAuth access token - Cannot parse access token",
        "type": "OAuthException",
        "code": 190,
        "fbtrace_id": "ABH-nbT1bR3fwq3OT1TYsMI"
    }
}
```

### 3 PUT API with json request body, please also paste the response here

API PUT `https://jsonplaceholder.typicode.com/posts/1`

request body

```
{
    "title": "fo1",
    "body": "bar",
    "userId": "asd"
}
```

response body

```
{
    "title": "fo1",
    "body": "bar",
    "userId": "asd",
    "id": 1
}
```

API PUT `https://jsonplaceholder.typicode.com/posts/1`
response code: 500 Internal Server Error

request body:

```
{
    "title": "fo1",
    "body": "bar",
    "userId": "asd"
```

response body:

```
SyntaxError: Unexpected end of JSON input
at JSON.parse (<anonymous>)
	at parse (/app/node_modules/body-parser/lib/types/json.js:89:19)
	at /app/node_modules/body-parser/lib/read.js:121:18
	at invokeCallback (/app/node_modules/body-parser/node_modules/raw-body/index.js:224:16)
	at done (/app/node_modules/body-parser/node_modules/raw-body/index.js:213:7)
	at IncomingMessage.onEnd (/app/node_modules/body-parser/node_modules/raw-body/index.js:273:7)
	at IncomingMessage.emit (node:events:525:35)
	at endReadableNT (node:internal/streams/readable:1358:12)
	at processTicksAndRejections (node:internal/process/task_queues:83:21)
```

API PUT `https://jsonplaceholder.typicode.com/posts`
response code: 404 Not Found

request body:

```
{
    "title": "fo1",
    "body": "bar",
    "userId": "asd"
}
```

response body: `{}`

### 2 DELETE API

API DELETE `https://jsonplaceholder.typicode.com/posts/1`

response code: 200 OK

response body: `{}`

API DELETE `https://jsonplaceholder.typicode.com/posts`

response code: 404 Not Found

response body: `{}`

- Each example with 404, 401,500 and any http status codes you know

- API DELETE `https://jsonplaceholder.typicode.com/posts`

response code: 404 Not Found

- API GET `http://httpstat.us/401`

response code: 401 Unauthorized

API PUT `https://jsonplaceholder.typicode.com/posts/1`

response code: 500 Internal Server Error

API POST `https://graph.facebook.com/{{api_version}}/{{ig_user_id}}/media?media_type=REELS&video_url={{video_url}}&caption=Hello World!&share_to_feed=false&access_token={{page_access_token}}`

response code: 400 Bad Request
