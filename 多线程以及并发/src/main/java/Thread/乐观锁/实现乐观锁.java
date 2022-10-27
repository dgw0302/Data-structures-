package Thread.乐观锁;
public class 实现乐观锁 {
    static class OptimThread extends Thread {
        public int version;
        public String data;
        public OptimThread(String s, int version, String data) {
            this.data = data;
            this.version = version;
        }

        public int getVersion() {
            return version;
        }

        @Override
        public void run() {
            while (true) {
                //1.读数据
                String text = Data.data;
                System.out.println(getName()+" 获得的版本号是 " + Data.version);
                System.out.println(getName() + " 预取的版本号是" + getVersion() );
                // 2.写数据：预期的版本号和数据版本号一致，那就更新
                if(Data.getVersion() == getVersion()){
                    System.out.println("线程" + getName() + "，版本号为：" + version + "，正在操作数据");
                    synchronized(OptimThread.class){
                        if(Data.getVersion() == this.version){
                            Data.data = this.data;
                            Data.updateVersion();
                            System.out.println("线程" + getName() + "写数据完成=========data = " + this.data);
                            return ;
                        }
                    }
                }else{
                    // 3. 版本号不正确的线程，需要重新读取，重新执行

                    System.out.println("线程"+ getName() + "，获得的数据版本号为：" + Data.getVersion());

                    System.out.println("线程"+ getName() + "，预期的版本号为：" + getVersion());
                    System.err.println("线程"+ getName() + "，需要重新执行。==============");
                }
            }
        }


    }


    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            new OptimThread(String.valueOf(i), 1, "fdd").start();
        }
    }


}



class Data{
    static  int version = 1;
    static String data = "数据本身";
    public static int getVersion() {
        return version;
    }
    public static void updateVersion() {
        version = version + 1;
    }
}
