package Thread.优先级;

public class TEsty {
    public static void main(String[] args) {


        System.out.println("主线程的优先级" + Thread.currentThread().getPriority());

        priority priority = new priority();
//        priority.setPriority(10);
        priority.start();
    }
}
