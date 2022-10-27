package Thread.设置异常回调接口;

/**
 * 演示设置线程的UnCaughtExceptionHandler回调接口
 */
public class xexception {

    public static void main(String[] args) {
        //设置线程的全局回调接口
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //t接收发送异常的线程，e就是改线程中的异常
                System.out.println(t.getName() + "线程发生了异常"+"---"+e.getMessage());
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(12 / 0);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        /* 在实际开发中,这种设计异常处理的方式还是比较常用的,尤其是异常执行的方
    法
    如果线程产生了异常, JVM 会调用 dispatchUncaughtException()方法,在该方法
    中调用了 getUncaughtExceptionHandler().uncaughtException(this, e); 如果当前线程设置了
     UncaughtExceptionHandler 回调接口就直接调用它自己的 uncaughtException 方法, 如果没有
    设置则调用当前线程所在线程组UncaughtExceptionHandler 回调接口的 uncaughtException 方
    法,如果线程组也没有设置回调接口,则直接把异常的栈信息定向到 System.err 中
    */


    }

}
