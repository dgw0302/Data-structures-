package 线程池;

import java.util.PriorityQueue;
import java.util.concurrent.*;

public class Threadpool详解 {
    public static void main(String[] args) {


        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10,5000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10));











        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务执行中");
            }
        });

//        Future<Integer> dasd = pool.submit(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                System.out.println("dasd");
//                Thread.sleep(2000);
//                return 21;
//            }
//        });
//
//
//        try {
//            System.out.println(dasd.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }












    }

    public  static int  sol(int[] nums, int k) {


        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }


        return queue.poll();

    }
}
