package Thread.LOCK.Reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lock锁的可重入性 {
    static class sub extends Thread{
        private static Lock lock = new ReentrantLock();
        public static int num = 0;

        @Override
        public void run() {
            for(int i = 0; i < 100; i++) {
                try {
                    lock.lock();
                    lock.lock();//可重入锁是可以反复获得改锁
                    num++;

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        sub s1 = new sub();
        sub s2 = new sub();
        s1.start();
        s2.start();
        try {
            s1.join();
            s2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(sub.num);
    }
}
