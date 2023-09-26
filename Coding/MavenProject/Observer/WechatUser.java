package Observer;

/**
 * @Description: 具体的观察者类
 * @Author: hyc
 */
public class WechatUser implements Observer{

    private String name;

    public WechatUser(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
