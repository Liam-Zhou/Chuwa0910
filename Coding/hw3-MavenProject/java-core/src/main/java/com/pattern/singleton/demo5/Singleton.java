package com.pattern.singleton.demo5;

// 懒汉式-方式3（双重检查锁模式）
// 对于 getInstance() 方法来说，绝大部分的操作都是读操作（因为每次判断if null只有第一次有写操作，后面都是读操作），读操作是线程安全的。
// 所以我们没必让每个线程必须持有锁才能调用该方法，我们需要调整加锁的时机。由此也产生了一种新的实现模式：双重检查锁模式
public class Singleton {

    private Singleton(){}

    private static volatile Singleton instance; //不进行赋值，只有在首次使用该对象时才会创建

    public static Singleton getInstance(){
        //第一次判断，如果instance的值不为null，不需要抢占锁，直接返回对象
        if(instance == null){
            synchronized(Singleton.class){
                //第二次判断
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
