package Problem21.BasicHandling;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread p1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("p1 ends");});

        Thread p2 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("p2 ends");});

        Thread p3 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("p3 ends");
            } catch (InterruptedException e) {
                System.out.println("p3 is interrupted");
            }
            });

        p2.setDaemon(true);
        p1.start();
        p2.start();
        p3.start();
        p1.join();

        p3.interrupt();
        p3.join();
        System.out.println("Main end");
    }
}
