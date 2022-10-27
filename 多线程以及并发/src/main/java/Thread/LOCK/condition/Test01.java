package Thread.LOCK.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition等待与通知
 */
public class Test01 {
    //定义锁
    static Lock lock = new ReentrantLock();
    //获得condition对象
    static Condition condition = lock.newCondition();

    //定义线程子类
    static class SubThread extends Thread{
        @Override
        public void run() {

            try {
                lock.lock();//在调用wait前必须获得锁
                System.out.println("method lock");
                condition.await();
                System.out.println("method await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("method unlock");
            }

        }
    }

    public static void main(String[] args) {
        SubThread s = new SubThread();
        s.start();//子线程处于等待状态

        try {
            Thread.sleep(3000);

            lock.lock();
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
