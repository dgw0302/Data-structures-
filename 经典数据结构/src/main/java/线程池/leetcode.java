package 线程池;

import java.util.concurrent.ThreadPoolExecutor;

public class leetcode {
    public static void main(String[] args) {
        int[] arr = new int[] {2,1,0,3,0,5};
        moveZeroes(arr);

    }


    public static void moveZeroes(int[] nums) {



        int n = nums.length, left = 0, right = 0;

        while(right < n) {
            if(nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }

    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }













}
