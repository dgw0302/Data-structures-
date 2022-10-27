package 数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 数字重排 {
    List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
//
//        int m = 2533;
//        String s = String.valueOf(m);
//
//        数字重排 g = new 数字重排();
//        g.mm();

        int[] nums = new int[] {0,1,0,3,12};
        moveZeroes(nums);
    }
//
//    public void dfs(int m,boolean f,String s) {
//            if(res.size() > s.length()) return;
//            for(int i = 9; i > 0; i--) {
//                if(f && )
//            }
//    }
//
//    public static void  mm() {
//
//    }

    public static void moveZeroes(int[] nums) {

        if(nums.length == 0) return;

        int left = 0, right = nums[nums.length - 1];

        while(left < right) {
            while(left < right && nums[left] != 0) {
                left++;
            }
            while(left < right && nums[right] == 0) {
                right--;
            }
            swap(nums,left,right);
        }


    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
