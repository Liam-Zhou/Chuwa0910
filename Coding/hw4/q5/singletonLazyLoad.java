public class singletonLazyLoad {
    private singletonLazyLoad(){

    }

    private static class singletonLazyLoadHolder(){
        private static final singletonLazyLoad  instance = new singletonLazyLoad();
    }

    public static singletonLazyLoad getInstance(){
        return singletonLazyLoadHolder.instance;
    }

}
