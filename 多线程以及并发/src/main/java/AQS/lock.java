package AQS;
import sun.misc.Unsafe;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class lock {

    public static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {


        for(int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                   lock.lock();

                    try {
                        lock.lockInterruptibly();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //具体逻辑
                    lock.unlock();

                }
            }).start();
        }

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始阻塞");
                LockSupport.park();
                System.out.println("阻塞完毕");

            }
        });
        t1.start();
        t1.interrupt();

//        new ThreadPoolExecutor();


        BlockingQueue c = new ArrayBlockingQueue<Integer>(10);
       // c.put(2);
        try {
            c.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Semaphore semaphore = new Semaphore(5);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        CountDownLatch cb = new CountDownLatch(2);


        cb.countDown();


        AtomicInteger a = new AtomicInteger(10);
        a.getAndIncrement();
        lock.lock();
        lock.unlock();



    }


































}
