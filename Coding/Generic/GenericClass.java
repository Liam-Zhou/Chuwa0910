package Generic;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class GenericClass<T> {
    T obj;
    public GenericClass(T obj){
        this.obj = obj;
    }

    public T getObj(){
        return this.obj;
    }
}