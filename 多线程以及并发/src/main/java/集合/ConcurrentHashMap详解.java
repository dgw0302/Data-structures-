package 集合;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap详解 {


    public static void main(String[] args) {
//
//        ConcurrentHashMap<Integer,Integer> cmap = new ConcurrentHashMap<>();
//        cmap.put(1,11);
        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(1,54);
        map.put(1,56);

        System.out.println(map.get(1));

       /// map.get(1);







    }

















}
