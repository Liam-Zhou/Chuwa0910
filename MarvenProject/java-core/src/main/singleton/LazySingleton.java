public class LazySingleton {

    private LazySingleton(){};

    private static class LazySingletonHolder{
        
        private static LazySingleton instance = new LazySingleton();
    }

    public static LazySingleton getInstance(){
        return LazySingletonHolder.instance;
    }

    public void showMsg(){
        System.out.println("Lazy Singleton");
    }


    public static void main(String []args){

        LazySingleton instance = LazySingleton.getInstance();
        instance.showMsg();

    }
    
}
