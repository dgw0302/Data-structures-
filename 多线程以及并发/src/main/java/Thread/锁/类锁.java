package Thread.锁;

public class 类锁 {



    public static void main(String[] args) {
        final 类锁 test = new 类锁();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.m1();
                try {
                    test.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                类锁.sm2();
            }
        }).start();


//        final CCC x = new CCC();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                CCC.ceshi();
////                CCC.ceshi();
////                System.out.println(Thread.currentThread().getName());
//            }
//        }).start();
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                CCC.ceshi();
////                CCC.ceshi();
////                System.out.println(Thread.currentThread().getName());
//            }
//        }).start();




    }
    public void m1(){
//使用当前类的运行时类对象作为锁对象,可以简单的理解
       // 为把 Test06 类的字节码文件作为锁对象
        synchronized ( 类锁.class ) {
            for (int i = 1; i <= 100; i++) {
          //      蛙课网【动力节点旗下品牌】 http://www.wkcto.com
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }
        }
    }

    public synchronized static void sm2(){
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + " --> " + i);
        }
    }









      static class CCC{
        int x =123;
        Object object = new Object();

        public synchronized  static void ceshi() {
            for(int i = 0; i < 10;i++) {
                System.out.println(Thread.currentThread().getName() +" " + i);
            }
        }
        public void mm() {
            for(int i = 0; i < 10;i++) {
                System.out.println(Thread.currentThread().getName() +" " + i);
            }
        }

    }


}


