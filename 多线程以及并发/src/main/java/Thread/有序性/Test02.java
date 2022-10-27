package Thread.有序性;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 可见性与
 *
 */
public class Test02 {
    //static int m5 = 0;
    static AtomicInteger m = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
       for(int i = 0; i < 10; i++) {
           new Thread(new Runnable() {
               @Override
               public void run() {
                  for(int i = 0; i < 10; i++) {
                      m.incrementAndGet();//这个操作是自带原子性的
                  }
               }
           }).start();
       }

       Thread.sleep(2000);
        System.out.println(m);
    }
}
