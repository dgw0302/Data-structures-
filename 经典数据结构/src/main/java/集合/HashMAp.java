package 集合;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.Executors.*;

public class HashMAp {
    ThreadLocal<String> ts = new ThreadLocal<>();

    public static void main() throws InterruptedException {









        HashMap<Integer, Integer> map = new HashMap<>();

//        ThreadPoolExecutor t = new ThreadPoolExecutor();
//        newSingleThreadExecutor();
//
//        newFixedThreadPool();
        map.put(3,3);


        ReentrantLock lock = new ReentrantLock();

        lock.lock();

        Thread s = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("dfa");
            }
        });
        s.start();

        Condition con = lock.newCondition();

        con.await();

        ThreadLocal<String> t = new ThreadLocal<>();
        t.set("dsa");
        t.get();




    }



//
//    public boolean isStrictlyPalindromic(int n) {
//        for(int i = 2; i <= n - 2; i++) {
//
//            String s = jisuan(n, i);
//            if(!juedge(s)) return false;
//        }
//
//        return true;
//
//    }

//
//    public int jisuan(int n, int x) {
//        String s = "";
//        do {
//            x = x + String.valueOf(n % x);
//            n /= x;
//        } while(n != 0);
//        return s.reverse();
//
//    }


    public boolean juedge(String s) {

        int i = 0 , j = s.length() - 1;

        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
        //Arrays.sort()

    }

}
