//package Problem23;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class ThreadWayA {
//    public static void main(String[] args) throws InterruptedException {
////        AtomicInteger A = new AtomicInteger(1);
////        Thread thread1 = new threadA(A,10);
////        Thread thread2 = new threadB(A,10);
////
////        thread1.start();
////        thread2.start();
////
////        thread1.join();
////        thread2.join();
//    }
//}
//
//class threadA extends Thread {
//
//    private final int i;
//    private AtomicInteger a;
//    public threadA(AtomicInteger a, int i) {
//        this.a = a;
//        this.i = i;
//    }
//
//    @Override
//    public void run() {
//        while(this.a.get() < this.i) {
//            synchronized (i) {
//                while(a.get() % 2 != 1) {
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//                System.out.print("ThreadA: ");
//                System.out.println(a.get());
//                a.incrementAndGet();
//                notifyAll();
//            }
//        }
//    }
//}
//
//class threadB extends Thread {
//    private AtomicInteger a;
//    private final int i;
//    public threadB(AtomicInteger a,int i) {
//        this.a = a;
//        this.i = i;
//    }
//
//    @Override
//    public void run() {
//        while ( this.a.get() <= this.i){
//            synchronized (this.a) {
//                while(this.a.get() % 2 != 0) {
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//                System.out.print("ThreadB: ");
//                System.out.println(a.get());
//                a.incrementAndGet();
//                notifyAll();
//            }
//        }
//
//
//    }
//}