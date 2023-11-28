package kechen.learn.c02_basic_thread_handling;

public class JoinTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("t Thread start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t Thread end");
        });

        System.out.println("Main start");
        t.start();
        try {
            System.out.println("Main thread is stopped and waiting for t thread end");
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Mian stop");
    }
}
