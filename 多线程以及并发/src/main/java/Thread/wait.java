package Thread;

import java.util.ArrayList;
import java.util.List;

public class wait {
    public static void main(String[] args) {
        ThreadAdd threadAdd = new ThreadAdd();

        ThreadSubtract threadSubtract = new ThreadSubtract();

        threadSubtract.setName("subtract 1");

        ThreadSubtract threadSubtract2 = new ThreadSubtract();

        threadSubtract2.setName("subtract 2");

        threadSubtract.start();
        threadSubtract2.start();
        threadAdd.start();
    }

    static List list = new ArrayList<>();
    //2)定义方法从集合中取数据
    public static void subtract(){
        synchronized (list) {
// if (list.size() == 0) {
            while (list.size() == 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + " begin wait....");

                    list.wait(); //等待
                    System.out.println(Thread.currentThread().getName() + " end wait..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object data = list.remove(0); //从集合中取出一个数据
            System.out.println( Thread.currentThread().getName() + "从集合中取了" + data +
                    "后,集合中数据的数量:" + list.size());
        }
    }
    //3)定义方法向集合中添加数据后,通知等待的线程取数据
    public static void add(){
        synchronized (list){
            list.add("data");
            //蛙课网【动力节点旗下品牌】 http://www.wkcto.com
            System.out.println( Thread.currentThread().getName() + "存储了一个数据");
            list.notifyAll();
        }
    }
    //4)定义线程类调用 add()取数据的方法
    static class ThreadAdd extends Thread{
        @Override
        public void run() {
            add();
        }
    }
    //定义线程类调用 subtract()方法
    static class ThreadSubtract extends Thread{
        @Override
        public void run() {
            subtract();
        }
    }
}
