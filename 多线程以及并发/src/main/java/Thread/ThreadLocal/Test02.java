package Thread.ThreadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 在多线程环境中，把字符串转换为日期对象
 *
 * 为每个线程指定自己的SimpleDateFormat对象,用ThreadLocal
 */
public class Test02 {
//改对象可以把字符串转换日期
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

    static ThreadLocal threadLocal = new ThreadLocal();
    static class ParseDate implements Runnable{
        private int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }
        @Override
        public void run() {
            try {
                String text = "2038年11月20日 08:23:" + i%60;//构建日期字符串
                if(threadLocal.get() == null){
                    threadLocal.set(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"));
                }

                Date date = sdf.parse(text);//把字符串转换为日期
                System.out.println(i + "----" +date);



            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


    }



    public static void main(String[] args) {
        //创建100个线程
        for(int i = 0; i < 0; i++){
            new Thread(new ParseDate((i))).start();
        }
     //   System.out.println("das");
    }


}
