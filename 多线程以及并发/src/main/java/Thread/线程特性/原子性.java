package Thread.线程特性;

import java.util.concurrent.atomic.AtomicInteger;

public class 原子性 {
    public static void main(String[] args) {
        final myInt myInt = new myInt();
        for(int i =0;i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println(Thread.currentThread().getName()+" "+myInt.getNum2());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

    }

    static class myInt{

        int num;
        public synchronized int getNum1(){
            return num++;
            /**
             * 先读取
             * 再自增
             * 最后赋值
             */
        }
//    在java中提供了一个线程安全的AtomicInteger类,保证线程操作的原子性
       AtomicInteger s = new AtomicInteger();
        public  int getNum2(){
            return s.getAndIncrement();
            /**
             * 先读取
             * 再自增
             * 最后赋值
             */
        }


    }
}
