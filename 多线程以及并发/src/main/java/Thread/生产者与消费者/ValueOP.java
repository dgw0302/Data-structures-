package Thread.生产者与消费者;

public class ValueOP {
    String s = "";
//    定义方法修改value字段的值
    public void setValue() {

        synchronized (this) {

            while ( !s.equalsIgnoreCase("")){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String value = System.currentTimeMillis() + " -" + System.nanoTime();
            System.out.println("set的值是" + value);
            this.s = value;

           // this.notify();
//            在多生产者多消费者环境中,notify()不能保证是生产
//            者唤醒消费者,如果生产者唤醒的还是生产者可能会出现假死的情况

            this.notifyAll();

        }
    }

    public void getValue() {
        synchronized (this) {
            //如果 value 是空串就等待
            while (s.equalsIgnoreCase("")) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //不是空串,读取 字段值
            System.out.println("get 的值是: " + this.s);
            this.s = "";
            //this.notify();
            this.notifyAll();

        }

    }



}
