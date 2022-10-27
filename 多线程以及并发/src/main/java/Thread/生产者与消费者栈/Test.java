package Thread.生产者与消费者栈;

/**
 * 一生产一消费
 */
public class Test {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        produceStack p = new produceStack(myStack);
        ConsumeStack c = new ConsumeStack(myStack);
        ;p.start();
        c.start();

    }
}
