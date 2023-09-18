package patterns.singleton.demo6;

import patterns.singleton.demo6.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton ins_1 = Singleton.INSTANCE;
        Singleton ins_2 = Singleton.INSTANCE;

        System.out.println(ins_1 == ins_2);
    }
}
