package Thread.有序性;

/**
 * 果然，不是按顺序执行代码，会发生重排序
 */
public class Test01 {
    private static int a = 0;
    private static int b = 0;
    private static int x = 0;
    private static int y = 0;
    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                   b = 1;
                   y = b;
                }
            }).start();

            if((x == 0 && y == 0) || (x == 1 && y == 1)) {
                System.out.println("完毕");
                break;
            }
            }

        }
    }

