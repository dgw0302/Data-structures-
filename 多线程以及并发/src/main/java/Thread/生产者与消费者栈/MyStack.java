package Thread.生产者与消费者栈;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private List list = new ArrayList();//定义集合模拟栈
    private static final int MAX = 1;//集合的最大容量

    //定义方法模拟栈
    public synchronized void push() {
//        当栈中数据已经满了，就等待
        while (list.size() >= MAX) {
            System.out.println(Thread.currentThread().getName() + "begin wait");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String data = "data----" + Math.random();
        System.out.println(Thread.currentThread().getName() + "添加了数据" +data);
        list.add(data);

        //this.notify();
        notifyAll();//多个生产者和消费者
     }

//     定义一个方法模拟出栈
    public synchronized void pop() {
        while (list.size() == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "begin ---");
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "出栈数据" + list.remove(0));
        //this.notify();
        notifyAll();//多个生产者和消费者
    }









}
