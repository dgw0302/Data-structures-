package Thread.threadMethod;

public class SubThread2 extends Thread{
    @Override
    public void run() {
        System.out.println("当前线程的名称"+Thread.currentThread().getName());
        System.out.println(this.getName());
    }
}
