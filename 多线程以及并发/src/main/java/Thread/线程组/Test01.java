package Thread.线程组;

/**
 * 演示创建线程组
 */
public class Test01 {
    public static void main(String[] args) {
// 1) 返回当前 main 线程的线程组
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mainGroup);
//2) 定义线程组,如果不指定所属线程组,则自动归属当前线程所属的线程组中
        ThreadGroup group1 = new ThreadGroup("group1");
        System.out.println(group1);
//3)定义线程组, 同时指定父线程组
        ThreadGroup group2 = new ThreadGroup(mainGroup, "group2");
//现在 group1 与 group2 都是 maingroup 线程组中的子线程组, 调用线程组的 getParent()方法返回父线程组
        System.out.println( group1.getParent() == mainGroup);

//true
        System.out.println( group2.getParent() == mainGroup);
//4) 在创建线程时指定所属线程组
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        };
//在创建线程时,如果没有指定线程组,则默认线程归属到父线程的线程组中
//在 main 线程中创建了 t1 线程,称 main 线程为父线程,t1 线程为子线程, t1 没有指定线程组则 t1 线程就归属到父线程 main 线程的线程组中
        Thread t1 = new Thread(r, "t1");
        System.out.println( t1 ); //Thread[t1,5,main], t1 的线程组是 main 线程组
//创建线程时,可以指定线程所属线程组
        Thread t2 = new Thread(group1, r, "t2");
        Thread t3 = new Thread(group2, r, "t3");

        System.out.println(t2);
        System.out.println(t3);
    }
}
