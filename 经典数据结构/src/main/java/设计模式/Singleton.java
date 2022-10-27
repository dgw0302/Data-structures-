package 设计模式;

import java.util.ArrayList;

public class Singleton {
    private static volatile Singleton singleton = null;

    ArrayList<Integer> list = new ArrayList<>();

    private Singleton(){}

    public static Singleton getSingleton() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
