package 线程池.测试;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,2000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
         pool.execute(new Runnable() {
             @Override
             public void run() {
                 System.out.println("das");
             }
         });
        Future<?> das = pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("das");
            }
        });
    }

}
