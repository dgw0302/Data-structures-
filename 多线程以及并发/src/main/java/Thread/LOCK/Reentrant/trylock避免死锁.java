package Thread.LOCK.Reentrant;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用trylock可以避免死锁
 */
public class trylock避免死锁 {

    static class Intlock implements Runnable{
        private static ReentrantLock lock1 = new ReentrantLock();
        private static ReentrantLock lock2 = new ReentrantLock();
        private int locknum;//用于控制锁的顺序

        public Intlock(int locknum) {
            this.locknum = locknum;
        }

        @Override
        public void run() {
            if(locknum % 2 == 0) {//偶数先锁1再锁2
                try {
                    while (true) {
                        if(lock1.tryLock()) {
                            System.out.println(Thread.currentThread().getName() + "获得锁1，还想获得锁2");
                            Thread.sleep(new Random().nextInt(100));

                            try {
                                if(lock2.tryLock()) {
                                    System.out.println(Thread.currentThread().getName() + "同时获得锁1与锁2");
                                    return;//当前线程结束，run方法结束
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                if(lock2.isHeldByCurrentThread())
                                lock2.unlock();
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if(lock1.isHeldByCurrentThread()) lock1.unlock();
                }

            }else {//奇数先锁2再锁1
                try {
                    while (true) {
                        if(lock2.tryLock()) {
                            System.out.println(Thread.currentThread().getName() + "获得锁2，还想获得锁1");
                            Thread.sleep(new Random().nextInt(100));

                            try {
                                if(lock1.tryLock()) {
                                    System.out.println(Thread.currentThread().getName() + "同时获得锁1与锁2");
                                    return;//当前线程结束，run方法结束
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                if(lock1.isHeldByCurrentThread())
                                    lock1.unlock();
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if(lock2.isHeldByCurrentThread()) lock2.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Intlock l1 = new Intlock(11);
        Intlock l2 = new Intlock(12);
        Thread t1 = new Thread(l1);

        Thread t2 = new Thread(l2);


        t1.start();
        t2.start();
    }
}
