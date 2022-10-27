package Thread.LOCK.Reentrant;

/**
 * 锁的可重入性
 */
public class reentrant {
    public synchronized void s1(){
        System.out.println("同步方法1");
        s2();
    }

    private synchronized void s2() {
        System.out.println("同步方法2");
        s3();
    }

    private synchronized void s3() {
        System.out.println("同步方法3");
    }

    public static void main(String[] args) {
        final reentrant r = new reentrant();
        new Thread(new Runnable() {
            @Override
            public void run() {
                r.s1();
            }
        }).start();
    }
}
