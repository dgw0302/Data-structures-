package Thread.LOCK.Reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * trylock()避免死锁
 * 当锁对象没有被其他线程持有的情况下才会获得改锁定
 * 也成为真男人锁
 * 另一个重载方法我愿称为tiangou锁
 */
public class Trylock2 {
    static class sub{
        private ReentrantLock lock = new ReentrantLock();
        public void method(){
            try {
                if(lock.tryLock()){
                    System.out.println(Thread.currentThread().getName()+" 获得锁定");
                    Thread.sleep(2000);
                }else{
                    System.out.println(Thread.currentThread().getName() + " 没有获得锁定");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(lock.isHeldByCurrentThread()) lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final sub s = new sub();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                s.method();
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 =new Thread(r);
        t2.start();
    }
}
