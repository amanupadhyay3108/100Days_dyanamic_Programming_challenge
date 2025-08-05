import java.util.*;
public class squareSubMatrices {
public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0},
            {1, 1, 1, 1, 0}
        };
        squareSubMatrices obj = new squareSubMatrices();
        int result = obj.countSquares(matrix);
        System.out.println(result); // Output the total number of square submatrices
    }       
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<m;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=0;i<n;i++){
            dp[i][0]=matrix[i][0];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0)continue;
                if(matrix[i][j]==1)
                dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }
        int total=0;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               
                total+=dp[i][j];
            }
        }
        return total;
    }
}