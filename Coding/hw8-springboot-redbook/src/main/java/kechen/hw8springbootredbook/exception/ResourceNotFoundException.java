package kechen.hw8springbootredbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 在这个特定的例子中，@ResponseStatus(value = HttpStatus.NOT_FOUND) 告诉 Spring 在处理对应的请求时，
 * 如果发现资源不存在（例如，从数据库查询数据为空），则返回 HTTP 状态码 404（NOT_FOUND）给客户端。
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private  String resourceName;   // 指示资源的名称。
    private String fieldName;   // 指示未找到资源的字段名称。
    private long fieldValue;   // 表示未找到资源的字段值。

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        // Post not found with id : '1'
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(long fieldValue) {
        this.fieldValue = fieldValue;
    }
}
