import java.util.*;
public class longestChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        int result = new longestChain().longestStrChain(words);
        System.out.println(result);
    }
    public boolean checkStrings(String s1,String s2){
        if(s1.length()!=s2.length()+1)return false;
        int first=0;
        int second=0;
        while(first<s1.length()){
            if(second<s2.length()&&s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        if(first==s1.length()&&second==s2.length())return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        int n=words.length;
        int dp[]=new int[n];
        int max=0;
        Arrays.sort(words,(a,b)->a.length()-b.length());

        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(checkStrings(words[i],words[prev])&&dp[prev]+1>dp[i]){
                    dp[i]=dp[prev]+1;

                }
            }
            if(dp[i]>max)max=dp[i];
        }
        return max;
    }
}
