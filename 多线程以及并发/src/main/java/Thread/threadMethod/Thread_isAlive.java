package Thread.threadMethod;

public class Thread_isAlive extends Thread{
    private int x = 12;
    @Override
    public void run() {
        System.out.println("run方法，isAlive"+this.isAlive());
        System.out.println(this.getId());
        System.out.println(this.x);
    }
}
