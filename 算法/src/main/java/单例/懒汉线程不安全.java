package main.java.单例;

public class 懒汉线程不安全 {
    private static 懒汉线程不安全 singleton =null;

    public static 懒汉线程不安全 getSingleton() {
        if(singleton == null) singleton = new 懒汉线程不安全();
        return singleton;
    }
}
