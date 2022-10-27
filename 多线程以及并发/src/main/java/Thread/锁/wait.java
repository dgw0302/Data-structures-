package Thread.锁;

/**
 * wait()/notify() 必须放在同步代码块中，否则会产生异常
 * 任何对象都可以调用这两个方法，因为这是Object类的方法，
 *
 * wait()需要放在同步代码块，通过锁对象调用，否则产生异常
 */
public class wait {
    public static void main(String[] args) {


        try {
            String s = "dasaws";
            synchronized (s) {
                System.out.println("同步代码块开始");
                s.wait();
                System.out.println("wait后面的代码");
            }
            System.out.println("同步代码块后面的代码");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main后面的代码");


    }
}
