package 数组;

import java.util.Arrays;

/**
 * 数组A中给定可以使用的1 ~ 9 的数，返回由A数组中的元素组成的小于n的最大数， 例如A = {1,2,4,9} x = 2533 ,返回 2499
 *
 */

public class 重构数字 {
    static int ans = Integer.MIN_VALUE;

    public static int ChooseSort(int[] num, int target) {
        int targetTime = 0;
        int temp = target;
        while (temp != 0) {
            temp /= 10;
            targetTime++;
        }
        dfs(num, 0, target, targetTime, 0);

        return ans;
    }

    public static void dfs(int[] num, int res, int target, int targetTime, int curTime) {
        if (curTime >= targetTime) {
            return;
        }
        for (int i = 0; i < num.length; i++) {
            res = res * 10 + num[i];
            curTime++;
            if (res > target)
                return;
            else
                ans = Math.max(ans, res);
            dfs(num, res, target, targetTime, curTime);
            res /= 10;
            curTime--;

        }


    }


    public static void main(String[] args) {
        int[] a = {1,2,4,9};
        Arrays.sort(a);

        System.out.println(ChooseSort(a,2533));
    }


}
