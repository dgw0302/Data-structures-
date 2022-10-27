package Thread.threadYield;

public class yield extends Thread{
    @Override
    public void run() {

        Thread.yield();//放弃当前的CPU资源，转让给线程池里面优先级相同的其他线程
    }
}
