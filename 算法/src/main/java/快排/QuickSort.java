package main.java.快排;

public class QuickSort {

    public static void main(String[] args) {

        int[] nums = new int[] {5,6,4,3,2,9,45,6,1,5};
        partation(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.println(num);
        }

    }

    public void quick(int[] nums) {

    }


    public static void partation(int[] nums, int left, int right) {
        if(left >= right) return;

        int privot = left;

        int i = left, j = right;
        while(i < j) {
            while( i < j && nums[j] >= nums[privot]) j--;
            while (i < j && nums[i] <= nums[privot]) i++;
            swap(nums, i, j);
        }

        swap(nums, privot, i);

        partation(nums, left, i - 1);
        partation(nums, i + 1, right);

    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
