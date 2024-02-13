package DesignPattern.Observer;

/**
 * @Description: 抽象主题角色类
 * @Author: hyc
 */
public interface Subject {
    void add(Observer observer);

    void delete(Observer observer);

    void notify(String message);
}
