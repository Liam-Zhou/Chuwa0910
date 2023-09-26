package homework.hw4;

public class LazySingleton {
    private static class InstanceHolder {
        private static final Singleton instance = new Singleton();
    }

    private LazySingleton() {}

    public static Singleton getEagerInstance() {
        return instance;
    }
    
}


class EagerSingleton {

    private static Singleton instance = new Singleton();
    private EagerSingleton() {}

    public static Singleton getLazyInstance() {
        return InstanceHolder.instance;
    }
}

