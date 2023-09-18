package DesignPattern;
//Eager Initialization
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return INSTANCE;
    }
}

class lazySingleton {
    private static lazySingleton instance;
    private lazySingleton() {}
    public static lazySingleton getInstance() {
        if (instance == null) {
            instance = new lazySingleton();
        }
        return instance;
    }
}

class doubleCheckedSingleton {
    private volatile static doubleCheckedSingleton instance;
    private doubleCheckedSingleton() {}
    public static doubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (doubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new doubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}

class staticInnerSingleton {
    private staticInnerSingleton() {}
    private static class SingletonHolder {
        private static final staticInnerSingleton INSTANCE = new staticInnerSingleton();
    }
    public static staticInnerSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

enum enumSingleton {
    INSTANCE;
    // Add methods and fields
}



