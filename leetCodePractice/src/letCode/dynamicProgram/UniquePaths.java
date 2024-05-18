package letCode.dynamicProgram;

/**
 * Created by @gaofenglin
 * on 2024/5/18.
 */
public class UniquePaths {
    int dp[][];

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int m = 3;
        int n = 2;
        int result = solution.uniquePaths(m, n);
        System.out.println("Number of unique paths: " + result);  // Output: 3
    }

    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(m, n);
    }

    int helper(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        dp[m][n] = helper(m - 1, n) + helper(m, n - 1);
        return dp[m][n];

    }


}

