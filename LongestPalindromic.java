import java.util.*;
public class LongestPalindromic {
    public static void main(String[] args) {
        String s = "bbbab";
        LongestPalindromic solution = new LongestPalindromic();
        int result = solution.longestPalindromeSubseq(s);
        System.out.println(result); // Output the length of the longest palindromic subsequence
    }       
    public int longestPalindromeSubseq(String s) {
        String s1=s;
        StringBuilder sb=new StringBuilder(s);
        String s2=sb.reverse().toString();

        int n=s.length();
        int dp[][]=new int[n+1][n+1];
    
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }


        return dp[n][n];
    }
}