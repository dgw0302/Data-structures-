package Thread.生产者与消费者;

public class 消费者 extends Thread{
    private ValueOP obj;

    public 消费者(ValueOP obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.getValue();
    }
}
