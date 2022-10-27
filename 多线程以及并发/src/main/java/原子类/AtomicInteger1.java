package 原子类;

import sun.security.krb5.internal.TGSRep;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInteger1 {

   static AtomicInteger ato = new AtomicInteger(0);

   static CountDownLatch latch = new CountDownLatch(3);

   public static void main(String[] args) throws InterruptedException {

        new A().start();

        new B().start();

        new C().start();

        latch.await();
        System.out.println("老大：开始干活");




        ato.getAndIncrement();

     }

     static class   A extends Thread{
         @Override
         public void run() {
             System.out.println("A部门到齐");
             latch.countDown();
         }
     }

    static class   B extends Thread{
        @Override
        public void run() {
            System.out.println("B部门到齐");
            latch.countDown();
        }
    }



    static class   C extends Thread{
        @Override
        public void run() {
            System.out.println("C部门到齐");
            latch.countDown();
        }
    }

}
