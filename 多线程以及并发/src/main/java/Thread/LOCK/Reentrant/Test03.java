package Thread.LOCK.Reentrant;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock锁同步不同方法
 */
public class Test03 {
    static Lock lock = new ReentrantLock();
    public static void sm1() {
        //经常在try代码块中获得lock锁，在finally子句中释放锁
        try {
            lock.lock();//获得锁
            System.out.println(Thread.currentThread().getName() + "method1" +System.currentTimeMillis());
            Thread.sleep(new Random().nextInt(1000));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//释放锁
        }
    }
}
