package Thread.threadMethod;

/**
 * 当前线程就是调用这一段代码的线程
 */
public class SubThraed extends Thread{
    public SubThraed(){
        System.out.println("构造方法打印当前线程名称"+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法打印"+Thread.currentThread().getName());
    }
}
