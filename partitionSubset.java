public class partitionSubset {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        partitionSubset solution = new partitionSubset();
        boolean result = solution.canPartition(nums);
        System.out.println(result); // Output whether the array can be partitioned into two subsets with equal sum
    }       
    public boolean canPartition(int[] nums) {
        
        int tsum=0;
        for(int  i=0;i<nums.length;i++){
            tsum+=nums[i];
        }
        if(tsum%2!=0)return false;
        
        int target=tsum/2;
        int n=nums.length;
        boolean dp[][]=new boolean[nums.length][target+1];
        for(int i=0;i<n;i++)dp[i][0]=true;
        if (nums[0] <= target) dp[0][nums[0]] = true;
        for(int i=1;i<n;i++){
           for(int k=1;k<=target;k++){
            boolean nottake=dp[i-1][k];
            boolean take=false;
            if(nums[i]<=k){
                take=dp[i-1][k-nums[i]];
            }
            dp[i][k]=take||nottake;
           }
        }

        return dp[n-1][target];
        
    }
}
