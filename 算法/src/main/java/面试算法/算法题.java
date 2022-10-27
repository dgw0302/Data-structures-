package main.java.面试算法;

import java.util.ArrayDeque;
import java.util.Deque;

public class 算法题 {
    public static void main(String[] args) {

        
        String s = "1fgh22fdsfdswfds33fswdfsdfvsdfsdfsdgsdf545dasdsqaddsad212315";

        System.out.println(hua(s).toString());

    }


    public static StringBuilder hua (String s) {
        int right = 0, left = 0;
        StringBuilder res = null;
        int resLength = 0;

        Character righttemp ;
        Character leftTemp;

        while(right < s.length() && left <= right) {


            if(!isChar(s.charAt(right)) ) {
                 righttemp = s.charAt(right);

                 leftTemp = s.charAt(left);
                while(left <= right && !isChar(s.charAt(left))) {
                    left++;
                }

                if(right  - left  > resLength) res = new StringBuilder(s.substring(left, right));
                resLength = right - left;

                left = right;

            }

            right++;

        }

        return res;
    }

    public static boolean isChar (Character c) {
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ') return true;
        return false;
    }
}
