package Thread.LOCK.Reentrant;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对于synchronized内部锁来说，如果一个线程在等待锁，只有两个结果，要么改线程获得锁继续执行，要么就保存等待
 *
 * 可以通过ReentrantLock的lockInterruptibly（）方法解决死锁问题
 *
 */
public class lockInterruptibly2 {
    static class IntLock implements Runnable{
        //创建两个 ReentrantLock 锁对象
        public static ReentrantLock lock1 = new ReentrantLock();
        public static ReentrantLock lock2 = new ReentrantLock();
        int lockNum; //定义整数变量,决定使用哪个锁
        public IntLock(int lockNum) {
            this.lockNum = lockNum;
        }
        @Override
        public void run() {
            try {
                if ( lockNum % 2 == 1){ //奇数,先锁 1,再锁 2
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "获得锁 1,还需 要获得锁 2");
                            Thread.sleep(new Random().nextInt(500));
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "同时获得了锁 1 与锁 2....");
                }else { //偶数,先锁 2,再锁 1
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "获得锁 2,还需 要获得锁 1");
                            Thread.sleep(new Random().nextInt(500));
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "同时获得了锁 1 与锁 2....");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if ( lock1.isHeldByCurrentThread()) //判断当前线程是否持有该锁
                    lock1.unlock();
                if (lock2.isHeldByCurrentThread())
                    lock2.unlock();
                System.out.println( Thread.currentThread().getName() + "线程退出");
            }
        }
    }

    public static void main(String[] args) {
        IntLock intLock1 = new IntLock(11);
        IntLock intLock2 = new IntLock(22);
        Thread t1 = new Thread(intLock1);
        Thread t2 = new Thread(intLock2);
        t1.start();
        t2.start();
//在 main 线程,等待 3000 秒,如果还有线程没有结束就中断该线程
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//可以中断任何一个线程来解决死锁, t2 线程会放弃对锁 1 的申请,同时释放锁 2, t1 线程会完成它的任务
        if (t2.isAlive()){ t2.interrupt();}
        //中断其中一个，因为lockInterruptibly（）会产生异常,
        // 如果线程被中断了,不会获得锁,会产生异常
    }


}
