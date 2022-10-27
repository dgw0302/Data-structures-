package main.java.蚂蚁笔试;

import java.util.Scanner;

public class 秋招笔试九一五 {

    /**
     *
     * 一个字母可以拆分成两个字母表顺序的前一个字母，例如，b可以拆分成aa，c可以拆分成bb。
     * 打印出最短的可以拆分成 K 个 a 的字符串，字母顺序无所谓。
     * 例如，k = 5, 最短字符串为 ca(或ac) = bba = aaaaa.
     *
     * K = 1, a; K = 2, b; K = 4, c;.....
     * @param args
     */
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(n > 0){
            if((n % 2) == 1){
                sb.append((char)('a'+i));
            }
            i++;
            n = n >> 1;
        }
        System.out.println(sb.toString());
    }
}
