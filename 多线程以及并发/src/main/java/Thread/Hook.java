package Thread;

/**
 *
 * Hook线程
 */
public class Hook {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("JVM退出时会启动当前线程,在hook线程中删除lock文件");
            }
        }));
    }
}
