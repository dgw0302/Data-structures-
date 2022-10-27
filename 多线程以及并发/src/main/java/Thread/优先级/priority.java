package Thread.优先级;

public class priority extends Thread{
    /**
     * java优先级 1 ~ 10，超出这个范围会抛出异常IllegalArgumentException
     *
     */

//    线程优先级越高的获得执行权的几率越大

//    “高优先级线程”被分配CPU的概率高于“低优先级线程


    /**
     * 线程的优先级具有继承性，即A线程中创建了B线程则，A和B线程的优先级是一样的
     */
    @Override
    public void run() {
        System.out.println("当前线程的优先级" + Thread.currentThread().getPriority());
    }
}
