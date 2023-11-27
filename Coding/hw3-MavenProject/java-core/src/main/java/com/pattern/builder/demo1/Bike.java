package com.pattern.builder.demo1;

//建造者模式具体的产品对象
public class Bike {
    private String frame;
    private String seat;

    //setter and getter
    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
