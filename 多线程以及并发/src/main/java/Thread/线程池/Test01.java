package Thread.线程池;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池的基本使用
 */
public class Test01 {
    public static void main(String[] args) {
        //创建5个线程大小的线程池
    //    ExecutorService fixedThreadpool = new Executors.newFixedThreadPool(5);


        //像线程池中提交18个任务，这18个任务存储到线程池的阻塞队列中，线程池中的5个线程从阻塞队列中取任务执行

//        ExecutorService executorService1 = Executors.newCachedThreadPool();
//
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//
        ExecutorService executorService3 = Executors.newFixedThreadPool(11);

       // ExecutorService executorService4 = Executors.newScheduledThreadPool();

//        for(int i = 0; i < 100; i++) {
//            executorService1.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName()+" 在执行线程");
//                }
//            });
//        }






        //自定义线程池
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 660L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10), new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                Thread t = new Thread();
//                return t;
//            }
//        }, new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                r.run();
//                System.out.println("线程池坚持不住了，别往里面放任务了");
//            }
//        });
//        for(int i = 0; i < 21; i++) {
//            threadPoolExecutor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }

        //ExecutorService executorService3 = Executors.newFixedThreadPool(11);
        executorService3.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("helo world");
            }
        });
        executorService3.shutdown();
        try {
            executorService3.awaitTermination(1,TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Lock s = new ReentrantLock();
        s.lock();
    }
}
