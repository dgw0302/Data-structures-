package Thread.中断;

public class tset {
    public static void main(String[] args) {


//        interrupt interrupt = new interrupt();
//        interrupt.start();

//        for(int i =0; i < 10; i++) {
//            System.out.println("主线程" +i);
//        }




        for(int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "main");
        }



        sub s = new sub();
        Thread t = new Thread(s);
        t.start();

        for(int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "main");
        }


        t.interrupt();


//        如果想子线程中断,在子线程中设置

        /*
        * 是逻辑上的删除
        * */

    }
    static class sub extends Thread{
        @Override
        public void run() {

            for(int i = 1; i <= 10000; i++){

//判断线程的中断标志,线程有 isInterrupted()方法,该方法返回线程的中断标志
                if ( this.isInterrupted() ){
                    System.out.println("当前线程的中断标志为 true, 我要退出了");
// break; //中断循环, run()方法体执行完毕, 子线程运行完毕
                    return; //直接结束当前 run()方法的执行
                }
                System.out.println("sub thread --> " + i);
            }

        }
    }
}
