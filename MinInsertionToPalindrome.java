import java.util.*;
public class MinInsertionToPalindrome {
    public static void main(String[] args) {
        String s = "abc";
        MinInsertionToPalindrome solution = new MinInsertionToPalindrome();
        int result = solution.minInsertions(s);     
    System.out.println(result); // Output the minimum insertions to make the string a palindrome
    }



    public int minInsertions(String s) {
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
        int len=dp[n][n];
        return n-len;
    }
}
