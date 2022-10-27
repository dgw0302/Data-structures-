package Thread;

public class leisuo {
     int c;

     public leisuo(int i) {
         c =i;
     }

    public static void main(String[] args) {

        for(int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (leisuo.class) {
                      while (true) {
                      }
                    }
                }
            }).start();
        }

        leisuo m = new leisuo(3);
        System.out.println(m.c);
    }
    

}
