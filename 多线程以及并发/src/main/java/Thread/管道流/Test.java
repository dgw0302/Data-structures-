package Thread.管道流;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 使用PipedInputStream和PipedOutputStream管道字节流在线程之间传递数据
 */
public class Test {
    public static void main(String[] args) {
        final PipedInputStream in = new PipedInputStream();
       final   PipedOutputStream out = new PipedOutputStream();

//        在输入与输出建立连接
        try {
            in.connect(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        创建线程向管道流中写数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                writeData(out);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                readData(in);
            }
        }).start();


    }

//    定义方法向管道流写入数据
    public static void writeData(PipedOutputStream out) {
//        分别别0导100写入管道
        try {
            for(int i =0;i < 100; i++) {
                String data = "" + i;
                out.write(data.getBytes());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    定义方法向管道流读取数据
    public static void readData(PipedInputStream in) {
        byte[] bytes = new byte[1024];
        //从输入字节流管道读取保存到字节数组中
        try {
            int len = in.read(bytes);

            while (len != -1) {
                System.out.println(new String(bytes,0,len));
                len = in.read(bytes);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
