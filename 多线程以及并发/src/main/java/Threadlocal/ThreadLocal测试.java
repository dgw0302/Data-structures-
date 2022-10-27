package Threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocal测试 {

 //   public static final AtomicInteger atomic = new AtomicInteger(0);

    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();



    public static void main(String[] args) {


        for( int i = 0; i < 10; i++) {

           new Thread(new Runnable() {
               @Override
               public void run() {
                   threadLocal.set(Thread.currentThread().getName());
                   System.out.println("线程  " + Thread.currentThread().getName() + "   local       " + threadLocal.get());
               }
           }).start();


        }

    }


}
