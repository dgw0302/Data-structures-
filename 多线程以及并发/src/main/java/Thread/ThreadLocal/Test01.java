package Thread.ThreadLocal;

/**
 * ThredLocala的基本使用
 */
public class Test01 {
    //定义ThredLocala对象
    static ThreadLocal threadLocal = new ThreadLocal();

    static class Subthread extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 20; i++){
                // 设置线程关联的值
                threadLocal.set( Thread.currentThread().getName() + "-" + i);
                //调用get()方法读取关联的值
                System.out.println(Thread.currentThread().getName() + " value " + threadLocal.get());
            }
        }
    }
    public static void main(String[] args) {
        Subthread t1 = new Subthread();
        Subthread t2 = new Subthread();
        t1.start();
        t2.start();

    }
}
