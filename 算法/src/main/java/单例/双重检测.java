package main.java.单例;

public class 双重检测 {

    private static volatile 双重检测 singleton = null;

    public static 双重检测 getSingleton() {
        if(singleton == null) {
            synchronized (双重检测.class) {
                if(singleton == null) {
                    singleton = new 双重检测();
                }
            }
        }
        return singleton;
    }



}
