package Thread.锁;

public class ceshi {


    public static void main(String[] args) {
        final ceshi ceshi1 = new ceshi();
        ceshi ceshi2 = new ceshi();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ceshi.x();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ceshi.x();
            }
        }).start();

    }

    public synchronized static void x(){
        for(int i=0;i < 10;i++) {
            System.out.println(Thread.currentThread().getName() +"  "+ i);
        }
    }
}
