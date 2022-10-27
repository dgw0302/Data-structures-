package 生产者与消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class producerAndConsumer {

    //队列大小
    private static final Integer FULL = 10;

    //队列东西的个数
    private static Integer count = 0;

    //锁对象
    private Lock lock = new ReentrantLock();
    //两个条件变量，一个为缓冲区未满，一个为缓冲区未null

    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();


    class Producer implements Runnable {

        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                lock.lock();
                try {

                    while(count == FULL) {
                        //如果生成的数据填满了
                        //把当前拿到锁的线程放进NotFull队列阻塞
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    count++;
                    System.out.println("生产者生成，目前有" + count);
                    //唤醒消费者
                    notEmpty.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
         for(int i = 0; i < 10; i++) {
             lock.lock();

             try {
                 while(count == 0) {
                    try {
                        notEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                 }

                 count--;
                 System.out.println("消费者" + count);

                 //唤醒生产者
                 notFull.signal();
             } finally {
                lock.unlock();
             }
         }
        }
    }
        public static void main(String[] args) {
            producerAndConsumer test = new producerAndConsumer();
            new Thread(test.new Producer()).start();
            new Thread(test.new Producer()).start();
            new Thread(test.new Producer()).start();
            new Thread(test.new Consumer()).start();
            new Thread(test.new Consumer()).start();
            new Thread(test.new Consumer()).start();
            new Thread(test.new Consumer()).start();
        }

}
