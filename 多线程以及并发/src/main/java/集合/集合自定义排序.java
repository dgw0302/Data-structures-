package 集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 集合自定义排序 {

    public static void main(String[] args) {
        List<Node> res = new ArrayList<>();

        Collections.sort(res, (a, b) -> a.val - b.val);
    }

    class Node {
        int val;
        public  Node(int val) {
            this.val = val;
        }
    }
}
