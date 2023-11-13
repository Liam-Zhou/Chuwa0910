package kechen.features.default_interface_method;

public interface DIML {
    static final String BLOG = "ke chen";

    int add(int a, int b);

    // abstract method
    default int substract(int a, int b){
        return a - b;
    }

    static String blogName(){
        return BLOG;
    }
}
