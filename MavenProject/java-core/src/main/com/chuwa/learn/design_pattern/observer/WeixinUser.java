package main.com.chuwa.learn.design_pattern.observer;

public class WeixinUser implements Observer{
    public void update() {
        System.out.println("收到了消息");
    }
}
