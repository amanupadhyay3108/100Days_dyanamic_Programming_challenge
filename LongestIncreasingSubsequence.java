import java.util.*;
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }   
    public int longest(int nums[],int i,int prev,int dp[][]){
        if(i>=nums.length)return 0;
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
        int nottake=longest(nums,i+1,prev,dp);
        int take=0;
        if(prev==-1||nums[i]>nums[prev]){
            take=1+longest(nums,i+1,i,dp);
        }
        return dp[i][prev+1]= Math.max(take,nottake);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for(int row[]:dp)Arrays.fill(row,-1);
        return longest(nums,0,-1,dp);
    }
}