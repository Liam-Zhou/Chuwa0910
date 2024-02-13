package java8.generic;

/**
 * @Description:
 * @Author: hyc
 * @Date: 2/10/24
 */
public class GenericClass<T> {
    // T-> Integer, User, Product
    T obj;

    public GenericClass(T obj) {this.obj = obj; }

    public T getObj() {return this.obj; }
}
