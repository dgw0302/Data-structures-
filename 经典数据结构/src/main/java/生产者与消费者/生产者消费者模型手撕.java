package 生产者与消费者;


import Redis.跳表Demo;
import sun.invoke.empty.Empty;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 产者消费者问题
 *
 *         该问题是一个著名的同步问题。它描述的是：一群生产者进程正在生产产品，并将这些产品提供给消费者进程去消费。为使生产者和消费者能够并发执行。在两者之间设置了一个公共区域，生产者进入公共区域生产产品并放入其中。消费者进入公共区域并取走产品进行消费。
 *
 *         当一个生产者进入公共区域生产产品时，其他生产者和消费者不能同时进入公共区域生产产品或消费产品。当一个消费者进入公共区域消费产品的时候，其它消费者和生产者不能同时进入该区域消费产品或生产产品。也就是说，任意时刻，最多只允许一个生产者或一个消费者进入公共区域。即生产者和消费者必须互斥的访问公共区域。
 *
 *         当产品放满公共区域时，生产者必须等待，使消费者先消费。当公共区域为空时，消费者必须等待，使生产者先生产。即在公共区域为空或为满时，生产者或消费者在执行时要满足一定的先后顺序。即生产者与消费者对公共区域的访问必须同步。
 *
 *
 *      （1）生产者与生产者之间存在竞争即互斥关系
 *
 *      （2）消费者与消费者之间存在竞争即互斥关系
 *
 *      （3）生产者与消费者之间存在互斥与同步关系
 *
 *         以上三个结论可以概括为：三种关系，两种角色，一个临界区。即“三二一”规则。
 */
public class 生产者消费者模型手撕 {


    public final static int QueueSize = 10;

    public static Lock lock = new ReentrantLock();

    public static  int count = 0;

   static Condition pro = lock.newCondition();
   static    Condition con = lock.newCondition();

    static class Producer implements Runnable{


        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();
                try {

                    while (count == QueueSize) {
                        try {
                            pro.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    count++;
                    System.out.println("生产者生成，目前有" + count);
                    con.signal();
                } finally {
                    lock.unlock();
                }
            }

        }

    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {

                    while (count == 0) {
                        try {
                            con.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    count--;
                    System.out.println("消费者" + count);
                    pro.signal();
                } finally {
                    lock.unlock();
                }
            }

        }

    }


    public static void main(String[] args) {
        Consumer con = new Consumer();
        Producer pro = new Producer();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);

        new Thread(con).start();
        new Thread(pro).start();
        new Thread(con).start();
        new Thread(pro).start();
        new Thread(con).start();
        new Thread(pro).start();
    }





}
