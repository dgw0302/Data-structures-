package main.java.单例;

public class 懒汉线程安全 {
     private static volatile 懒汉线程安全 singeleton = null;


     private static synchronized 懒汉线程安全 getSingeleton() {
          if(singeleton == null) singeleton = new 懒汉线程安全();
          return singeleton;
     }


}
