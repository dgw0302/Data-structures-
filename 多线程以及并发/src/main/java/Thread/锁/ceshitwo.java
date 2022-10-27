package Thread.锁;

public class ceshitwo {


    public static void main(String[] args) {
        ceshitwo s = new ceshitwo();
        ceshitwo d = new ceshitwo();
        s.mm();
        d.mm();


    }
    public  static void mm(){


        for(int i=0;i < 13;i++){
            System.out.println(Thread.currentThread().getName()+" " +i);
        }
    }

    static class d{

    }
}
