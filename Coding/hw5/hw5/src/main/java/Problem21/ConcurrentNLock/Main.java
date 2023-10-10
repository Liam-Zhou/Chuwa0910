package Problem21.ConcurrentNLock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Map<String,String> map = new ConcurrentHashMap<String, String>();
        Thread t1 = new myThread(map,"t1");
        Thread t2 = new myThread(map,"t2");
        Thread t3 = new myThread(map,"t3");

        t1.start(); t2.start(); t3.start();
        t1.join(); t2.join();t3.join();
        System.out.println(map);
    }
}

class myThread extends Thread {
    private final Map<String, String> map;
    private final String sign;

    public myThread(Map<String, String> map, String sign) {
        this.map = map;
        this.sign = sign;
    }

    @Override
    public void run() {
        map.put(this.sign,this.sign);
    }
}
