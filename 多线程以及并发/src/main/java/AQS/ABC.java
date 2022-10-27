package AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition(), c2 = lock.newCondition(), c3 = lock.newCondition();
        CountDownLatch latch = new CountDownLatch(3);
        new PrintThread(lock, c3, c1, "茴", latch, 10).start();
        new PrintThread(lock, c1, c2, "香", latch, 10).start();
        new PrintThread(lock, c2, c3, "豆", latch, 10).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        c3.signalAll();    // 这行代码有抛出IllegalMonitorStateException的风险吗？
        lock.unlock();
    }

  static class PrintThread extends Thread{
      private Lock lock;
      // 这个的用处等下再说
      private CountDownLatch latch;
      private String s;
      private Condition pre, post;
      private int loop;

      PrintThread(Lock lock, Condition pre, Condition post, String s, CountDownLatch latch, int loop) {
          this.lock = lock;
          this.pre = pre;
          this.post = post;
          this.latch = latch;
          this.s = s;
          this.loop = loop;
      }
        public PrintThread() {
        }

      @Override
      public void run() {
          while (loop > 0) {
              lock.lock();
              // 线程每次先进入等待状态
              try {
                  latch.countDown();   // latch的作用是为了保证能成功唤醒第一个线程
                  pre.await();
              } catch (InterruptedException e) {
                  System.out.println("Interrupted");
              }
              // 进行打印并唤醒下一个线程
              System.out.println(s);
              post.signalAll();
              loop--;
              lock.unlock();
          }
      }

    }

}


