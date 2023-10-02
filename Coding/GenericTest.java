class Generic<T>{

    private T obj;

    public Generic(T obj){

        this.obj=obj;

    }

    public T getObj(){
        return obj;
    }



}

public class GenericTest{

    public static void main(String []args){

        Generic<Integer>obj1 = new Generic<>(5);
        System.out.println(obj1.getObj());



    }

}