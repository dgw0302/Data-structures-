package Thread.中断;

public class interrupt extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
//            判断线程的中断标志，线程有isInterrupted方法 ，改方法返回线程的中断标志
            if(this.isInterrupted()) {
                System.out.println("当前线程的中断标志为true，我要退出了");
                return;
                }

            System.out.println("子线程"+i);
        }
    }


}
