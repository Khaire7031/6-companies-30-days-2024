import java.util.Arrays;

public class POTD_16 {
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int dp[][] = new int[m + 1][n + 1];
        return help(m, n, maxMove, startRow, startColumn, dp);
    }

    public static int help(int m, int n, int maxMove, int startRow, int startColumn, int dp[][]) {
        if (startColumn < 0 || startColumn >= n || startRow < 0 || startRow >= m) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (dp[startRow][startColumn] != 0) {
            return dp[startRow][startColumn];
        }
        dp[startRow][startColumn] = help(m, n, maxMove - 1, startRow + 1, startColumn, dp)
                + help(m, n, maxMove - 1, startRow - 1, startColumn, dp)
                + help(m, n, maxMove - 1, startRow, startColumn + 1, dp)
                + help(m, n, maxMove - 1, startRow, startColumn - 1, dp);
        return dp[startRow][startColumn];
    }

    // public static int help(int m, int n, int N, int i, int j) {
    // if (i == m || j == n || i < 0 || j < 0){
    // return 1;
    // }
    // if (N == 0){
    // return 0;
    // }
    // return findPaths(m, n, N - 1, i - 1, j) + findPaths(m, n, N - 1, i + 1, j) +
    // findPaths(m, n, N - 1, i, j - 1) + findPaths(m, n, N - 1, i, j + 1);
    // }

    class Solution {
        int M = 1000000007;

        public int findPaths(int m, int n, int N, int i, int j) {
            int[][][] memo = new int[m][n][N + 1];
            for (int[][] l : memo)
                for (int[] sl : l)
                    Arrays.fill(sl, -1);
            return findPaths(m, n, N, i, j, memo);
        }

        public int findPaths(int m, int n, int N, int i, int j, int[][][] memo) {
            if (i == m || j == n || i < 0 || j < 0)
                return 1;
            if (N == 0)
                return 0;
            if (memo[i][j][N] >= 0)
                return memo[i][j][N];
            memo[i][j][N] = ((findPaths(m, n, N - 1, i - 1, j, memo) + findPaths(m, n, N - 1, i + 1, j, memo)) % M +
                    (findPaths(m, n, N - 1, i, j - 1, memo) + findPaths(m, n, N - 1, i, j + 1, memo)) % M) % M;
            return memo[i][j][N];
        }
    }

    public static void main(String[] args) {
        System.out.println("    26-Jan-2024");
    }
}
