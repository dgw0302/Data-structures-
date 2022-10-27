package Thread.LOCK.Reentrant;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * lockInterruptibly()方法+的作用：如果当前线程未被中断则获得锁，如果当前线程中断则出现异常
 * 如果线程被中断了,不会获得锁,会产生异常
 *
 */
public class lockInterruptibly {

    static class Servier{
        private Lock lock = new ReentrantLock();//定义锁对象
        public void serviceMethod() {
            try {
                try {
                    lock.lockInterruptibly();//如果线程中断不会获得锁
                    for(int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() +"--"+i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {

            }
        }
    }
    public static void main(String[] args) {
        final Servier s = new Servier();
      Thread t1  = new Thread(new Runnable() {
          @Override
          public void run() {
              s.serviceMethod();
          }
      });
      t1.start();
      t1.interrupt();

    }
}
