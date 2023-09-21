package Observer;

import java.util.ArrayList;
import java.util.*;

/**
 * @Description: 具体主题角色类
 * @Author: hyc
 */
public class SubscriptionSubject implements Subject {

    private List<Observer> wechatUserList = new ArrayList<>();

    public void add(Observer observer) {
        wechatUserList.add(observer);
    }

    public void delete(Observer observer) {
        wechatUserList.remove(observer);
    }

    public void notify(String message) {
        for (Observer observer : wechatUserList) {
            observer.update(message);
        }
    }
}
