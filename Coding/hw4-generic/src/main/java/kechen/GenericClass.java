package kechen;

public class GenericClass<T> {
    /*
    The <T> part indicates that T is a type parameter,
    which will be replaced with an actual data type when you create an instance of this class.

    `T obj`: This is an instance variable of the generic type T.
    It's used to store an object of the type specified when you create an instance of the class.
     */
    T obj;

    //constructor
    public GenericClass(T obj) {
        this.obj = obj;
    }

    // getter
    public T getObj() {
        return obj;
    }
}
