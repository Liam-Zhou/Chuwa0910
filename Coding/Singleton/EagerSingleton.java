package Singleton;

public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){}

    public static EagerSingleton getInstance(){

        return instance;
        
    }

    public void show(){
        System.out.println("Eager Singleton");
    }


    public static void main(String []args){

        EagerSingleton instance = EagerSingleton.getInstance();
        instance.show();

    }


    
}
