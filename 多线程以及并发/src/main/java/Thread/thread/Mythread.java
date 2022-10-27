package Thread.thread;

public class Mythread extends Thread{


    /*
     * run()方法体中的代码就是子线程要执行的任务
     * */
    @Override
    public void run() {
        System.out.println("这是子线程打印的内容");
    }

}
