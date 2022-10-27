package main.java.位运算;

public class 多进制转十进制 {
    public static void main(String[] args) {
        System.out.println("dgw");
    }

    public String jisuan(int n, int x) {
        StringBuilder s = new StringBuilder();

        do {

            s.append(String.valueOf(n % x));
            n /= x;


        } while(n != 0);

        return s.reverse().toString();

    }
}
