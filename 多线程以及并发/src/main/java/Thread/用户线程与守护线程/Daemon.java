package Thread.用户线程与守护线程;

public class Daemon extends Thread{
    @Override
    public void run() {
       for (int i =8;i <123 ;i++){
           System.out.println("守护线程" + i);
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
