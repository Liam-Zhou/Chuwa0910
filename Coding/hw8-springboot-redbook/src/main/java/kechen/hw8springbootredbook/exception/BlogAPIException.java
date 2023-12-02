package kechen.hw8springbootredbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BlogAPIException extends RuntimeException{
    private HttpStatus httpStatus;   // 保存异常的 HTTP 状态码。
    private String message;   // 用于保存异常的消息。

    public BlogAPIException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public BlogAPIException(String message, HttpStatus httpStatus, String message1) {
        // 首先调用父类 RuntimeException 的构造函数传递消息，然后设置异常的状态和消息。
        super(message);
        this.httpStatus = httpStatus;
        this.message = message1;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
