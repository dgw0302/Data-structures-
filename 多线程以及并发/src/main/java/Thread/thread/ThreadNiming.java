package Thread.thread;

public class ThreadNiming {
    public static void main(String[] args) {
        //      Runnable的 匿名内部类
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    System.out.println("子线程" + i);
                }
            }
        });

        //Thread类的匿名内部类
        Thread t = new Thread() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        t.start();
    }
}
