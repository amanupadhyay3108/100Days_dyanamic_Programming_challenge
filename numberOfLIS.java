import java.util.*;
public class numberOfLIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = new numberOfLIS().findNumberOfLIS(nums);
        System.out.println(result);
    }
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int count[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[prev]<nums[i]&&dp[prev]+1>dp[i]){
                    dp[i]=1+dp[prev];
                    count[i]=count[prev];
                }else if(nums[prev]<nums[i]&&1+dp[prev]==dp[i]){
                    count[i]+=count[prev];
                }
            }
            max=Math.max(max,dp[i]);
        }
        int nos=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max)nos+=count[i];
        }
       return nos;
    }
}
