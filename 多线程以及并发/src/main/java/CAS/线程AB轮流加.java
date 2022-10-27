package CAS;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class 线程AB轮流加 {


    static volatile  int count = 0;
    static volatile int temp = 5;
    public static void main(String[] args) {

        AtomicInteger t = new AtomicInteger(5);

        t.compareAndSet(temp, 6);
        t.getAndIncrement();

        System.out.println(temp);





//        new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(10);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    //每个线程让count自增1000次
//                    for (int i = 0; i < 1000; i++) {
//                        increase();
//                    }
//                }
//            }).start();
//
//
//        try{
//            Thread.sleep(200);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println(count);


    }
//
    public static void increase() {
        int expect;
        while(!compareAndSwap(expect = getCount(),expect + 1)) {

        }
    }



//
//    static  void increase(){
//        int expect;
//        while (!compareAndSwap(expect = getCount(),expect+1)){
//        }
//    }



    public static synchronized boolean compareAndSwap(int expect, int newCount) {
        if(getCount() == expect) {
            count = newCount;
            return true;
        }
        return false;

    }

    public static int getCount(){
        return count;
    }



}
