package 线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTrader implements Executor {

    //当前线程池有多少个线程
    public final AtomicInteger ctl = new AtomicInteger(0);

    //核心线程
    private volatile int cornPollSize;

    //最大线程
    private volatile int maximumPollSize;

    //工作队列

    private final BlockingQueue<Runnable> workQueue;

    public ThreadPoolTrader(int cornPollSize, int maximumPollSize, BlockingQueue<Runnable> workQueue) {
        this.cornPollSize = cornPollSize;
        this.maximumPollSize = maximumPollSize;
        this.workQueue = workQueue;
    }










    @Override
    public void execute(Runnable command) {

        int c = ctl.get();
        if(c < cornPollSize) {
            if(!addWorker(command)) {
                reject();
            }
        }
        /**
         * 先望工作队列里面提交
         *
         * 如果工作队列满了，尝试创建新线程（只要不大于maxmumPoolSize）
         */
        if(!workQueue.offer(command)) {
            if(!addWorker(command)) {
                reject();
            }
        }

    }

    private boolean addWorker(Runnable command) {
        if(ctl.get() > maximumPollSize) return  false;

        //创建worker类，并带着任务Runnable
        Worker worker = new Worker(command);
        worker.thread.start();
        ctl.incrementAndGet();
        return true;


    }






    //worker类
    private final class Worker implements Runnable{

        final Thread thread;
        Runnable firstTask;

        private Worker(Runnable firstTask) {
            this.thread = new Thread(this);
            this.firstTask = firstTask;
        }



        @Override
        public void run() {

            Runnable task = firstTask;
            try {
                //提交的任务完成之后开始从队列里面拿任务
                while(task != null || (task = getTask()) != null) {
                        task.run();
                        if(ctl.get() > maximumPollSize) {
                            break;
                        }
                       task = null;
                }

            } finally {
                        ctl.decrementAndGet();
            }

        }

        /**
         * 从工作队列里面拿任务
         * @return
         */
        private Runnable getTask() {
            for(; ;) {
                try {
                    System.out.println("workQueue.size：" + workQueue.size());
                    return workQueue.take();
                } catch (InterruptedException  e) {
                    e.printStackTrace();
                }
            }
        }

    }


    private void reject() {
        throw new RuntimeException("Error！ctl.count：" + ctl.get() + " workQueue.size：" + workQueue.size());
    }

    public static void main(String[] args) {
        ThreadPoolTrader threadPoolTrader = new ThreadPoolTrader(2, 2, new ArrayBlockingQueue<Runnable>(10));

        for(int i = 0; i < 10; i++) {

            int x = i;
            threadPoolTrader.execute(() -> {

                System.out.println("任务编号" + x);
            });
        }

    }


}
