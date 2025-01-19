package dynamicProgramming;

// 출처: leetcode
// 문제 제목: House Robber
public class HouseRobber {
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1];

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + nums[i - 2]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int result = rob(nums);
        System.out.println(result);
    }
}
