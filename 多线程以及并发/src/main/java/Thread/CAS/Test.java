package Thread.CAS;
import java.util.concurrent.atomic.AtomicStampedReference;
/**
 * AtomicStampedReference原子类可以解决CAS中的ABA问题
 */
public class Test {
    //指定初始化版本为0
    private static AtomicStampedReference<String> s = new AtomicStampedReference<>("abc",0);

    public static void main(String[] args) throws InterruptedException {
       Thread  t1= new Thread(new Runnable() {
            @Override
            public void run() {
             s.compareAndSet("abc","def",s.getStamp(),s.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + "--" + s.getReference());
                s.compareAndSet("def","abc",s.getStamp(),s.getStamp() + 1);
            }
        });
       Thread t2 = new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               int banbeb = s.getStamp();
               System.out.println(s.compareAndSet("abc","ggg",banbeb, banbeb + 1));

           }
       });
       t1.start();
       t2.start();
       t1.join();
       t2.join();

        System.out.println(s.getReference());
    }
}




