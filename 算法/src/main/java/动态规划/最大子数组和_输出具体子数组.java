package main.java.动态规划;

public class 最大子数组和_输出具体子数组 {

   static int resLeft = 0;
   static   int resRight = 0;

    public static void main(String[] args) {


        //输出下标
        int[] temp = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(temp));

        System.out.println(resLeft + " ..   " + resRight);


    }


    public static int maxSubArray(int[] nums) {

        int res = nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int left = 0, right = 0;



        for(int i = 1; i < nums.length; i++) {
            if(dp[i - 1] > 0) {
                right = i;
                dp[i] = dp[i - 1] + nums[i];
            } else {
                left = i;
                right = i;
                dp[i] = nums[i];
            }

            if(dp[i] > res) {
                res = dp[i];
                resLeft = left;
                resRight = right;
            }

          //  res = Math.max(res, dp[i]);
        }

        return res;

    }
}
