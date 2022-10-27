package Thread.ThreadLocal;

import java.util.Date;

public class Test03 {
    static ThreadLocal threadLocal = new ThreadLocal();

   static class SubThread extends Thread{
       @Override
       public void run() {
            for(int i =0; i < 10; i++) {
                System.out.println("--------" + Thread.currentThread().getName() + "value" + threadLocal.get());
            //如果没有初始值就设置当前日期
                if(threadLocal.get() == null) {
                    threadLocal.set(new Date());

                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
       }
   }

    public static void main(String[] args) {
        SubThread t1 = new SubThread();
        t1.start();
        SubThread t2 = new SubThread();
    }
}
