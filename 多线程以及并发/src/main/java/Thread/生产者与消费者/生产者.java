package Thread.生产者与消费者;

/**
 * 定义线程类模拟生产者
 */
public class 生产者 extends Thread{
    private ValueOP obj;

    public 生产者(ValueOP obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.setValue();
    }
}
