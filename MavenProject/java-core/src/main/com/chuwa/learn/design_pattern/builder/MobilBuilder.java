package main.com.chuwa.learn.design_pattern.builder;

public class MobilBuilder extends Builder{

        @Override
        public void buildFrame() {
            bike.setFrame("Mobil frame");
        }

        @Override
        public void buildSeat() {
            bike.setSeat("Mobil seat");
        }
}
