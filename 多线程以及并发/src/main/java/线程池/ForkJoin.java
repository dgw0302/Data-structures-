package 线程池;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class ForkJoin {

    public static void main(String[] args) {
//
//        ExecutorService pool = Executors.newFixedThreadPool(5);
//
//
//
//
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
//            System.out.println(dasd.get(5,TimeUnit.SECONDS));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }

        Deque<Integer> queue = new ArrayDeque<>();



        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.pop());
        System.out.println(queue.poll());









    }
}
