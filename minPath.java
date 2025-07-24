public class minPath {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        minPath solution = new minPath();
        int result = solution.minPathSum(grid);
        System.out.println(result); // Output the minimum path sum
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
