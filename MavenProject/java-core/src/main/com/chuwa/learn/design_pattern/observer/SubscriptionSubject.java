package main.com.chuwa.learn.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{

        private List<Observer> weixinUserList = new ArrayList<Observer>();


        public void attach(Observer observer) {
            weixinUserList.add(observer);
        }


        public void detach(Observer observer) {
            weixinUserList.remove(observer);
        }


        public void notifyObservers(String message) {
            for(Observer observer : weixinUserList){
                observer.update(message);
            }
        }
}
