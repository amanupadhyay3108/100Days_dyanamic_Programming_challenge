import java.util.*;
public class decodeWays {
    public static void main(String[] args) {
        String s = "226";
        decodeWays solution = new decodeWays();
        int result = solution.numDecodings(s);
        System.out.println(result); // Output the number of ways to decode the string
    }           
    public int numDecodings(String s) {
        int n=s.length();
      if (s == null || s.length() == 0) {
            return 0;
        }

        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        for(int i=2;i<=n;i++){
            int first=Integer.valueOf(s.substring(i-1,i));
            int second=Integer.valueOf(s.substring(i-2,i));
            if(first>0&&first<10){
                dp[i]+=dp[i-1];
            }
            if(second>=10&&second<=26){

                dp[i]+=dp[i-2];
            }
        } 
        return dp[n];
    }
}
