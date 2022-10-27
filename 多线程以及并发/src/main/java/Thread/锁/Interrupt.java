package Thread.锁;

/**
 * Interrupt会中断线程的wait方法
 */
public class Interrupt {
    public static void main(String[] args) {
        sub s =new sub();
        s.start();

        try {
            Thread.sleep(2000);//主线程等待两秒确保子线程处于等待状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        s.interrupt();
    }
    private static final Object object = new Object();

    static class sub extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                try {
                    System.out.println("等待开始");
                    object.wait();
                    System.out.println("等待结束");
                } catch (InterruptedException e) {
                    System.out.println("wait等待被中断了");
                }
            }
        }
    }
}
