package Thread.LOCK.读写锁;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写锁是互斥的，只允许一个线程持有
 * 读读共享
 * 写写互斥
 * 读写互斥
 *
 *
 */
public class 写写互斥 {
    static class Service{
        //先定义读写锁
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        //定义方法修改数据
        public void write() {
            try {
                readWriteLock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + "--开始修改数据" + System.currentTimeMillis());
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + "读取数据完毕的时间"+System.currentTimeMillis());
                readWriteLock.writeLock().unlock();//释放写锁
            }


        }

    }


    public static void main(String[] args) {
    final Service service = new Service();
    for(int i = 0; i < 5; i++) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.write();
            }
        }).start();
    }
    }
}
