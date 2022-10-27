package Thread.生产者与消费者栈;

public class ConsumeStack extends Thread{
    private MyStack myStack;

    public ConsumeStack(MyStack myStack) {
        this.myStack = myStack;
    }

    @Override
    public void run() {
        while (true) {
            myStack.pop();
        }
    }
}
