package Thread.生产者与消费者;

/**
 * 一生产一消费
 */
public class Test {
    public static void main(String[] args) {
        ValueOP valueOP = new ValueOP();
        生产者 s = new 生产者(valueOP);
        消费者 x = new 消费者(valueOP);
        s.start();
        x.start();

    }
}
