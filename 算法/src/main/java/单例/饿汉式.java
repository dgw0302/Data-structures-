package main.java.单例;

public class 饿汉式 {
    private static 饿汉式 singleton = new 饿汉式();

    public static 饿汉式 getSingleton() {
        return singleton;
    }
}
