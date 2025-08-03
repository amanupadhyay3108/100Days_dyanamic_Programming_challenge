import java.util.*;
public class shortestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int result = new shortestPath().minPathSum(grid);
        System.out.println(result);
    }   
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j==0)dp[i][j]=grid[i][j];
                else if(i==0)dp[i][j]=dp[i][j-1]+grid[i][j];
                else if(j==0)dp[i][j]=dp[i-1][j]+grid[i][j];
                else dp[i][j]=Math.min(dp[i][j-1]+grid[i][j],dp[i-1][j]+grid[i][j]);
            }
        }
        return dp[n-1][m-1];
    }
}
