package com.kechen.exception;

//自定义异常类
public class ParkingFullException extends Exception{
    // public ParkingFullException(String message)：异常类的构造方法。
    // 当创建 ParkingFullException 的实例时，可以向构造方法传递一个描述异常原因的字符串 message。
    // 这个构造方法通过 super(message) 调用父类 Exception 的构造方法，将异常消息传递给父类，从而设置异常的描述信息。
    public ParkingFullException(String message){
        super(message);
    }
}
