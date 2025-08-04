import java.util.*;
public class minFallingPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int result = new minFallingPath().minFallingPathSum(matrix);
        System.out.println(result);
    }   
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
       dp[n-1]=matrix[n-1];
       for(int i=n-2;i>=0;i--){
         for(int j=0;j<m;j++){
            int ld=Integer.MAX_VALUE;
            int rd=Integer.MAX_VALUE;
            if(j-1>=0){
                ld=dp[i+1][j-1];
            }
            if(j+1<m){
                rd=dp[i+1][j+1];
            }
            dp[i][j]=matrix[i][j]+Math.min(dp[i+1][j],Math.min(ld,rd));
         }
       }
       int min=Integer.MAX_VALUE;
      for(int num:dp[0]){
        min=Math.min(num,min);
      }
      return min;
    }
}
