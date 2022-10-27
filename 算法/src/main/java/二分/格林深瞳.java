package main.java.二分;

public class 格林深瞳 {
    public static void main(String[] args) {


        int[] nums = new int[]{1,2,3,5,2,1};

        System.out.println(find(nums));

    }
    public static int find(int[] nums) {
        int left = 0, right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;

            if(nums[mid + 1] >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return right;

    }
}
