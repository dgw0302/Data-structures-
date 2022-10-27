package main.java.字节;

import java.util.HashMap;

public class 第一次出现次数最多的数 {

    public static void main(String[] args) {
        int[] s = new int[] {3,4,3,4,2,3,2,7,2};

        System.out.println(search3(s));
    }


    public static int search2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //二维数组
//        int[][]
        int res = 0;
        int ans = 0;


        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            int count = map.get(nums[i]);
            if(count > res) {
                res = count;
                ans = nums[i];
            }
        }

        return ans;


    }

    public static int search3(int[] nums) {

        int[][] map = new int[100][100];

        int res = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            int temp = map[nums[i]][nums[i]];

            map[nums[i]][nums[i]] = temp + 1;
            if(map[nums[i]][nums[i]] > res) {
                res = map[nums[i]][nums[i]];
                ans = nums[i];
            }

        }
        return ans;

    }
}
