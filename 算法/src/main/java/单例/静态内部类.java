package main.java.单例;

public class 静态内部类 {

    public static class 静态 {
        public static final  静态内部类 静态类 = new 静态内部类();
    }

    public static 静态内部类 getSingleton() {
        return 静态.静态类;//调用这个的时候，静态内部类才加载，才开始实例化对象。
    }


}
