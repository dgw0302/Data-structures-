package Thread.生产者与消费者栈;

/**
 * 一生产多消费
 */
public class Test2 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        produceStack p = new produceStack(myStack);
        ConsumeStack c1 = new ConsumeStack(myStack);
        ConsumeStack c2 = new ConsumeStack(myStack);
        ConsumeStack c3 = new ConsumeStack(myStack);
        c1.setName("消费者1号");
        c2.setName("消费者2号");
        c3.setName("消费者3号");
        p.start();
        c1.start();
        c2.start();
        c3.start();

    }


}
