package Thread.生产者与消费者;

/**
 * 多生产多消费
 */
public class Test02 {
    public static void main(String[] args) {

        ValueOP valueOP = new ValueOP();
        生产者 s1 = new 生产者(valueOP);
        生产者 s2 = new 生产者(valueOP);
        生产者 s3 = new 生产者(valueOP);
        消费者 x1 = new 消费者(valueOP);
        消费者 x2 = new 消费者(valueOP);
        消费者 x3 = new 消费者(valueOP);


        s1.start();
        s2.start();
        s3.start();
        x1.start();
        x2.start();
        x3.start();

    }
}
