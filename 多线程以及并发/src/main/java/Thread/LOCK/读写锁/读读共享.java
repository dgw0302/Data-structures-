package Thread.LOCK.读写锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
ReadWriteLock读写锁可以实现读读共享，允许多个线程同时获得读锁

读锁是共享锁
 */
public class 读读共享 {

        static class Service{
            //定义读写锁
            ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
            public void read(){
                try {
                    //获得读锁
                    readWriteLock.readLock().lock();
                    System.out.println(Thread.currentThread().getName()+ "--获得读锁,开始读取数据的时间 " + System.currentTimeMillis());
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readWriteLock.readLock().unlock();
                }


            }
        }


    public static void main(String[] args) {
            final Service service = new Service();
            for(int i = 0; i < 5; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        service.read();
                    }
                }).start();
            }

    }
}
