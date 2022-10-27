package Thread.LOCK.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个Condition实现通知部分线程
 */
public class Test02 {

static class Service{
    private ReentrantLock lock = new ReentrantLock(); //定义锁对象
    //定义两个 Condtion 对象
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    //定义方法,使用 conditionA 等待
    public void waitMethodA(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " begin wait:" +
                    System.currentTimeMillis());
            conditionA.await(); //等待
            System.out.println(Thread.currentThread().getName() + " end wait:" +
                    System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    //定义方法,使用 conditionB 等待
    public void waitMethodB(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " begin wait:" +
                    System.currentTimeMillis());
            conditionB.await(); //等待
            System.out.println(Thread.currentThread().getName() + " end wait:" +
                    System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //定义方法唤醒 conditionA 对象上的等待
    public void signalA(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " sigal A time = " +
                    System.currentTimeMillis());
            conditionA.signal();
            System.out.println(Thread.currentThread().getName() + " sigal A time = " +
                    System.currentTimeMillis());
        } finally {
            lock.unlock();
        }
    }
    //定义方法唤醒 conditionB 对象上的等待
    public void signalB(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " sigal A time = " +
                    System.currentTimeMillis());

            conditionB.signal();
            System.out.println(Thread.currentThread().getName() + " sigal A time = " +
                    System.currentTimeMillis());
        } finally {
            lock.unlock();
        }
    }

}
    public static void main(String[] args) throws InterruptedException {
        final Service service = new Service();
//开启两个线程,分别调用 waitMethodA(),waitMethodB()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMethodA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMethodB();
            }
        }).start();
        Thread.sleep(3000); //main 线程睡眠 3 秒
// service.signalA(); //唤醒 conditionA 对象上的等待,conditionB 上的等待
        //依然继续等待
        service.signalB();
    }

}

