package default_interface_method;

interface DIM{

    static final String BB = "I am here";

    int add(int a, int b);

    default int substract(int a, int b){
        return a-b;
    }

    static String name(){
        return BB;
    }

 }


 class DimTest implements DIM{

     @Override
     public int add(int a, int b) {
         return a+b;
     }
 }

 public class DIMImpl {

    public static void main(String []args){
        DimTest dim = new DimTest();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.substract(1, 2));
        System.out.println("static method: " + DIM.name());
    }
}