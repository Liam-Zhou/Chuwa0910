package DesignPattern.Singleton;

/**
 * @Description:
 * @Author: hyc
 * @Date: 2/27/24
 */
public class SingletonL {
    // Lazy Load
    // 声明静态实例，但不初始化
    private static SingletonL instance;

    // 私有构造方法，防止外部直接实例化
    private SingletonL() {}

    // 提供获取实例的静态方法，使用双重检查锁定确保线程安全
    public static SingletonL getInstance() {
        if (instance == null) {
            synchronized (SingletonL.class) {
                if (instance == null) {
                    instance = new SingletonL();
                }
            }
        }
        return instance;
    }
}
