import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;
import java.util.concurrent.Future;

public class PrintNumber{

        public static void main(String []args){

            PrintNumber pn = new PrintNumber();
            pn.CreateThread();

        }

        public void CreateThread(){
            ExecutorService exe = Executors.newFixedThreadPool(3);

            Runnable task1 = () -> {
                for(int i=1; i<11; i++)
                    System.out.println("Thread:" + Thread.currentThread().getName() + " is printing -" +i);
            };

            Runnable task2 = () -> {
                for(int i=11; i<21; i++)
                    System.out.println("Thread:" + Thread.currentThread().getName() + " is printing -" +i);
            };

            Runnable task3 = () -> {
                for(int i=21; i<31; i++)
                    System.out.println("Thread:" + Thread.currentThread().getName() + " is printing - " +i);
            };


            Future<?> future1 = exe.submit(task1);
            Future<?> future2 = exe.submit(task2);
            Future<?> future3 = exe.submit(task3);

            exe.shutdown();


        }


}


