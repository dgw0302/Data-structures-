package 集合;

import java.util.ArrayList;

public class Arraylist集合删除抛异常 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer index : list) {
            if (index == 1) {
                list.remove(index);
            }
        }

        //System.out.println(list.size());



    }
}
