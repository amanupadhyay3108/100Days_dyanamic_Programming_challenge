import java.util.*;
public class LargestSquareArea {

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };
        LargestSquareArea obj = new LargestSquareArea();
        int result = obj.countSquares(matrix);
        System.out.println(result); // Output the total number of square submatrices
    }       

 public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; // first row/col just copy the value
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1],
                                        Math.min(dp[i-1][j], dp[i][j-1]));
                    }
                    total += dp[i][j]; // accumulate directly
                }
            }
        }
        return total;
    }
}
