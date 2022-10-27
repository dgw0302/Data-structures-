package Threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo {

    public static void main(String[] args) {
        final int m = 10;

        final ThreadLocal<Integer> local = new ThreadLocal<>();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    local.set(m);

                    System.out.println(Thread.currentThread().getName() + local.get());
                }
            }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
               // m++;
                local.set(m);

                System.out.println(Thread.currentThread().getName() + local.get());
            }
        }).start();


        AtomicInteger atomicInteger = new AtomicInteger(10);
        atomicInteger.incrementAndGet();

    }


}
