package CAS;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class CAS {

    static AtomicInteger atomicInteger = new AtomicInteger(3);

    static AtomicReferenceFieldUpdater atomic = AtomicReferenceFieldUpdater.newUpdater(dgw.class,String.class,"s");


    public static void main(String[] args) {
        dgw d = new dgw("dgw",1);
        System.out.println(atomic.get(d));
        atomic.getAndSet(d,"dddd");

        System.out.println(atomic.get(d));
        atomicInteger.getAndIncrement();
        atomicInteger.compareAndSet(1,2);
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(6);
    }
    static class dgw {

        String s;
        int age;

        public dgw(String s, int age) {
            this.s = s;
            this.age = age;
        }

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
