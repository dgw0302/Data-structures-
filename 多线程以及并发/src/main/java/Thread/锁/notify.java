package Thread.锁;

/**
 * 通过notify唤醒等待的线程
 * notify不会立即释放锁对象
 *
 */
public class notify {
    public static void main(String[] args) {
        final String sxk = "dghwjkda";

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (sxk) {
                    System.out.println("线程一开始等待");
                    try {
                        sxk.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程一等待结束");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sxk) {
                    System.out.println("线程2开始唤醒线程一");
                    sxk.notify();//唤醒在锁对象sxk上等待的某一个线程
                    System.out.println("线程2结束唤醒");
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();//

    }
}
