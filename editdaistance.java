import java.util.*;
public class editdaistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        System.out.println(minDistance(word1, word2));
    }   
    public static int findminimum(String word1, String word2, int i, int j, int dp[][]) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (dp[i][j] != -1) return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j))
            return dp[i][j] = findminimum(word1, word2, i - 1, j - 1, dp);

        return dp[i][j] = 1 + Math.min(
            findminimum(word1, word2, i - 1, j - 1, dp),
            Math.min(
                findminimum(word1, word2, i - 1, j, dp),
                findminimum(word1, word2, i, j - 1, dp)
            )
        );
    }
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n][m]; // Fix: should be n x m, not (n+1)x(m+1)
        for (int[] row : dp) Arrays.fill(row, -1);
        return findminimum(word1, word2, n - 1, m - 1, dp);
    }
}