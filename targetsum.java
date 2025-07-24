import java.util.*;
public class targetsum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int result = findTargetSumWays(nums, target);
        System.out.println(result); // Output the number of ways to achieve the target sum
    }           

    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        if ((sum + target) % 2 != 0 || sum < Math.abs(target)) return 0;

        int subsetSum = (sum + target) / 2;

        int[][] dp = new int[n + 1][subsetSum + 1];

        // Base case: one way to make sum = 0 (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // DP transition
        for (int i = 1; i <= n; i++) {
            for (int tar = 0; tar <= subsetSum; tar++) {
                if (nums[i - 1] <= tar) {
                    dp[i][tar] = dp[i - 1][tar] + dp[i - 1][tar - nums[i - 1]];
                } else {
                    dp[i][tar] = dp[i - 1][tar];
                }
            }
        }

        return dp[n][subsetSum];
    }
}

