import java.util.*;
public class subsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        subsequence solution = new subsequence();
        int result = solution.longestCommonSubsequence(text1, text2);
        System.out.println(result); // Output the length of the longest common subsequence
    }       
    public int recurse(int ind1,int ind2,String s1,String s2,int dp[][]){
        if(ind1<0||ind2<0)return 0;
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2))return dp[ind1][ind2]= 1+recurse(ind1-1,ind2-1,s1,s2,dp);
        
        return dp[ind1][ind2]= Math.max(recurse(ind1-1, ind2,s1,s2,dp),recurse(ind1,ind2-1,s1,s2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()][text2.length()];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return recurse(text1.length()-1,text2.length()-1,text1,text2,dp);
        
    }
}
