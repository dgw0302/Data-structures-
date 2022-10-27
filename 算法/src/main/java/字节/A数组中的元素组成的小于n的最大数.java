package main.java.字节;

import java.util.Arrays;

public class A数组中的元素组成的小于n的最大数 {


    /**
     *
     * 最近看大家面经总有一道常见的题目：
     * 数组A中给定可以使用的1~9的数，返回由A数组中的元素组成的小于n的最大数。例如A={1, 2, 4, 9}，n=2533，返回2499
     * 有两个常见思路：
     * 1.暴力递归回溯，最后判断；
     * 2.贪心思想。
     *
     */



    public static void main(String[] args) {
        int[] nums = {2,4,5,9};
        A数组中的元素组成的小于n的最大数 demo = new A数组中的元素组成的小于n的最大数();
        System.out.println(demo.largestLessThanK(nums, 2451));
    }

    int k, num = 0, len, max = 0; // 假定给定的k为正数，无法组成比k小的数时返回0

    int[] nums;
    public  int largestLessThanK(int[] nums, int k) {
        this.nums = nums;
        this.k = k;

        //k是几位
        this.len = Integer.toString(k).length(); // 取得k的位数
        Arrays.sort(nums);
        backtrack(0);
        return max;
    }
    private void backtrack(int depth) {
        if(depth == len) return; // 剪枝：最大层深
        for(int i = 0; i < nums.length; i++) {

            //先加
            num = num * 10 + nums[i];

            if(num > k) { // 剪枝：返回上层
                num = (num - nums[i]) / 10;
                return;
            }

            if(num > max) max = num;

            backtrack(depth + 1);
            //再减，补偿，回溯
            num = (num - nums[i]) / 10; // 撤销
        }
    }




}
