import java.util.*;
public class deleteOperations {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        deleteOperations solution = new deleteOperations();
        int result = solution.minDistance(word1, word2);
        System.out.println(result); // Output the minimum number of deletions required
    }   
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
                else 
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int len=dp[n][m];
        int deletionRequired=n-len+m-len;
        return deletionRequired;
    }
}
