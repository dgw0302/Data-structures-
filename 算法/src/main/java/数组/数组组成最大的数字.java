package main.java.数组;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组组成最大的数字 {
    public static String largestNumber (int[] nums) {
        // write code here
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int i, j;
                for (i = 0, j = 0; i < s1.length() && j < s2.length() ; i++, j++) {
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(j);
                    if (c1 > c2) {
                        return -1;
                    } else if (c2 > c1){
                        return 1;
                    }
                }
                if (i == s1.length() && j == s2.length()) {
                    return 0;
                }
                if (i == s1.length()) {
                    i--;
                    while (j < s2.length()) {
                        char c1 = s1.charAt(i);
                        char c2 = s2.charAt(j);
                        if (c1 > c2) {
                            return -1;
                        } else if (c2 > c1){
                            return 1;
                        }
                        j++;
                    }

                } else if (j == s2.length()) {
                    j--;
                    while (i < s1.length()) {
                        char c1 = s1.charAt(i);
                        char c2 = s2.charAt(j);
                        if (c1 > c2) {
                            return -1;
                        } else if (c2 > c1){
                            return 1;
                        }
                        i++;
                    }
                }

                return 0;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add("" + nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

}
