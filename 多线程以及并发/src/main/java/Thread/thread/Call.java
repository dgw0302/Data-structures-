package Thread.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Call implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("dasds");
        return  1;
    }


    public static void main(String[] args) {
        Call call = new Call();
        FutureTask f = new FutureTask(call);
        new Thread(f).start();
        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // new Thread(call).start();
    }
}
