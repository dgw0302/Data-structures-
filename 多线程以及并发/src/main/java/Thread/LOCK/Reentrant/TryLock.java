package Thread.LOCK.Reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    static class TimeLock implements Runnable{
        private static ReentrantLock lock = new ReentrantLock();//定义锁对象
        @Override
        public void run() {
            try {
                if(lock.tryLock(3, TimeUnit.SECONDS)) {//获得锁，返回true
                    System.out.println(Thread.currentThread().getName() + "获得锁，执行耗时任务");
                    Thread.sleep(2000);
                }else{//没用获得锁
                    System.out.println(Thread.currentThread().getName() + "没有获得锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(lock.isHeldByCurrentThread()) lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock time = new TimeLock();
        Thread t1 = new Thread(time);
        Thread t2 = new Thread(time);
        t1.start();
        t2.start();


    }
}
