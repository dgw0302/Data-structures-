package Thread.blog;

import java.util.concurrent.atomic.AtomicInteger;

public class Test01 {

    public boolean canJump(int[] nums) {
        if(nums.length == 0) return false;
        return dfs(nums, 0);
    }

    public boolean dfs(int[] nums, int index) {
        if(index == nums.length - 1) return true;
        int temp = nums[index];
        for(int i = temp; i > 0; i--) {
            dfs(nums,index + i);
        }
        return false;
    }

    public static void main(String[] args) {
        AtomicInteger s = new AtomicInteger(0);
        s.incrementAndGet();
    }




}
