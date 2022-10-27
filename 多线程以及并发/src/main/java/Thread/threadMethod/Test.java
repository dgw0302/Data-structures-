package Thread.threadMethod;

/**
 * 测试当前线程
 *
 */
public class Test {
    public static void main(String[] args) throws Exception {
       // System.out.println("main方法中打印当前线程"+Thread.currentThread().getName());

//        SubThraed subThraed = new SubThraed();
//        subThraed.start();//Thread 0 - 1
//        subThraed.run();//main，在main方法中直接调用run方法，没有开启新线程，所以在run方法中的当前线程就是main线程

//
//        SubThread2 subThread2 = new SubThread2();
//        subThread2.setName("dgw");//设置线程的名称
//        subThread2.start();
//
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Das");
//            }
//        });



//        isAlive
//        Thread_isAlive thread_isAlive = new Thread_isAlive();
//        System.out.println(thread_isAlive.isAlive());
//        thread_isAlive.start();

//        test();


//        System.out.println("main_begin" + System.currentTimeMillis());

        System.out.println(args.length);
        s(2);

    }
    public static void test() throws Exception {

       try {
           throw new Exception("dsa");
       }catch (Exception e){
           System.out.println("测试");
       }
        System.out.println("das");
    }
    public static void s(int i) {
        System.out.println(i);
    }


}
