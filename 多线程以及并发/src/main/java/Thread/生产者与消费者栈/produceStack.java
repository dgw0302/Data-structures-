package Thread.生产者与消费者栈;

public class produceStack extends Thread{
    private MyStack myStack;

    public produceStack(MyStack myStack) {
        this.myStack = myStack;
    }

    @Override
    public void run() {
        while (true) {
            myStack.push();
        }
    }
}
