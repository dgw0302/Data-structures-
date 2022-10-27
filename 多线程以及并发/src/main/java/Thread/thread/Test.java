package Thread.thread;

public class Test {
    static int count;
    public static void main(String[] args) {


        for(int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    count++;
                    System.out.println("当前线程是 "+Thread.currentThread().getName()+" 当前count数"+count);
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程");
    }
}