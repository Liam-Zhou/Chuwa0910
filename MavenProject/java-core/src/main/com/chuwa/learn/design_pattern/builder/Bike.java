package main.com.chuwa.learn.design_pattern.builder;

public class Bike {
    public void setFrame(String frame) {
        this.frame = frame;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getFrame() {
        return frame;
    }

    public String getSeat() {
        return seat;
    }

    private String frame;
    private String seat;

    public Bike() {
    }

}
