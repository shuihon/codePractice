package letCode.dynamicProgram;

/**
 * Created by @gaofenglin
 * on 2024/5/18.
 */
public class UniquePathsWithObstacles {
    int[][] dp;
    int[][] obstacleGrid;
    public static void main(String[] args) {
        UniquePathsWithObstacles solution = new UniquePathsWithObstacles();

        int[][] obstacleGrid1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("Number of unique paths: " + solution.uniquePathsWithObstacles(obstacleGrid1)); // 输出: 2

        int[][] obstacleGrid2 = {
                {0, 1},
                {0, 0}
        };
        System.out.println("Number of unique paths: " + solution.uniquePathsWithObstacles(obstacleGrid2)); // 输出: 1
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;

        // 初始化 dp 数组
        dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }
        // 如果起点或终点是障碍物，返回0，终点坐标就是m-1，n-1；这是原图的坐标，区分dp里面的坐标
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        return helper(m, n);
    }

    int helper(int m, int n) {
        // 边界条件
        if (m == 1 && n == 1) {
            return 1;
        }
        if (m < 1 || n < 1) {
            return 0;
        }

        // 如果在原图中当前位置是障碍物，返回0，无路可走，因为当前坐标就是m-1，n-1；对于m行n列：0，0是第一个坐标
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // 检查是否已经计算过
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        // 递归计算
        dp[m][n] = helper(m - 1, n) + helper(m, n - 1);
        return dp[m][n];
    }


}


