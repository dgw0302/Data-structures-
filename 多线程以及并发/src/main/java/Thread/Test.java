package Thread;

public class Test {
    public static void main(String[] args) {
        System.out.println(strToInt("2147483646"));
    }
    public static int strToInt(String str) {
        int number = Integer.MAX_VALUE / 10;

        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;

        int i = 1, sigh = 1;

        if(c[0] == '-')
            sigh = -1;
        else if(c[0] != '+'){
            i = 0;
        }

        int res = 0;

        for(int j = i;j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > number || (c[j] > 7 && res == number))  return sigh == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + ( c[j] - '0' );
        }

        return res * sigh;
    }
}
