package letCode;

/**
 * Created by @gaofenglin
 * on 2024/6/2.
 */
public class DungeonGame {
    public static void main(String[] args) {
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        int minHealth = calculateMinimumHP(dungeon);
        System.out.println("骑士所需的最小健康点数: " + minHealth);
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        // 初始化右下角的房间
        dp[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);

        // 初始化最后一列
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
        }

        // 初始化最后一行
        for (int j = n - 2; j >= 0; j--) {
            dp[m-1][j] = Math.max(1, dp[m-1][j+1] - dungeon[m-1][j]);
        }

        // 填充剩余的dp表
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHealthOnExit = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
            }
        }

        return dp[0][0];
    }
}
