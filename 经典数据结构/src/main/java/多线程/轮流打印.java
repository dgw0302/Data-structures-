package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 轮流打印 {
        //三个线程轮流打印ABC10次

    public static Lock lock = new ReentrantLock();
    //三个条件队列，用await和signal
    public static Condition conditionA = lock.newCondition();
    public static Condition conditionB = lock.newCondition();
    public static Condition conditionC = lock.newCondition();

    //全局变量，控制当前是哪个线程打印
    public static int count =  0;

    public static void main(String[] args) {


        //A线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    lock.lock();
                    for(int i = 0; i < 10; i++) {
                        //先判断该不该当前线程打印
                        while (count % 3 != 0) {
                            //说明不是轮到自己打印，那么释放锁，await会释放锁（调用await说明当前线程一定持有锁），然后把当前线程加入到条件队列里面，
                            conditionA.await();
                        }

                        //走到这一步说明轮到自己了

                        System.out.print("A");
                        count++;
                        //开始唤醒下一个线程，每个线程按照ABC这样的顺序去唤醒
                        //调用sinal，会把线程从条件队列转向AQS中的同步队列，等待唤醒并加锁
                        conditionB.signal();

                    }



                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }


            }
        }).start();


        //无论是谁先拿到锁都没用，会判断该不该自己拿锁打印







        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    lock.lock();
                    for(int i = 0; i < 10; i++) {
                        //先判断该不该当前线程打印
                        while (count % 3 != 1) {
                            //说明不是轮到自己打印，那么释放锁，await会释放锁（调用await说明当前线程一定持有锁），然后把当前线程加入到条件队列里面，
                            conditionB.await();
                        }

                        //走到这一步说明轮到自己了

                        System.out.print("B");
                        count++;
                        //开始唤醒下一个线程，每个线程按照ABC这样的顺序去唤醒
                        //调用sinal，会把线程从条件队列转向AQS中的同步队列，等待唤醒并加锁
                        conditionC.signal();

                    }



                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }


            }
        }).start();




        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    lock.lock();
                    for(int i = 0; i < 10; i++) {
                        //先判断该不该当前线程打印
                        while (count % 3 != 2) {
                            //说明不是轮到自己打印，那么释放锁，await会释放锁（调用await说明当前线程一定持有锁），然后把当前线程加入到条件队列里面，
                            conditionC.await();
                        }

                        //走到这一步说明轮到自己了

                        System.out.print("C");
                        count++;
                        //开始唤醒下一个线程，每个线程按照ABC这样的顺序去唤醒
                        //调用sinal，会把线程从条件队列转向AQS中的同步队列，等待唤醒并加锁
                        conditionA.signal();

                    }



                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }


            }
        }).start();






    }
}
