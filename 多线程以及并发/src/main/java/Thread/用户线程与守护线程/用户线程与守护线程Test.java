package Thread.用户线程与守护线程;

public class 用户线程与守护线程Test {
    public static void main(String[] args) {
        /*
        * 守护线程是为其他线程提供服务的线程，如GC就是一个典型的守护线程
        * 守护线程不能单独进行，当JVM没有其他用户线程的时候，只有守护线程，守护线程会自动销毁
        *
        *
        * */
        Daemon daemon = new Daemon();
        daemon.setDaemon(true);//设置此线程为守护线程
        daemon.start();
        for(int i = 2;i<15;i++){
            System.out.println("主线程"+i);
        }

//        当main线程结束，守护线程也结束，设置守护线程在其启动之前

    }
}
