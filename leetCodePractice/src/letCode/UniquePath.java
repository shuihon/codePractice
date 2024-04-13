package letCode;

/**
 * Created by @gaofenglin
 * on 2024/4/11.
 * problem 63
 * There is a robot on an m x n grid.
 * The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that
 * the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePath {

    private void printPath(int[][] arr) {
        for (int[] row : arr) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int findAllPaths(int[][] arr, int m, int n, int pathCount) {
        // 检查是否达到终点
        if (m == 3 && n == 4) {
            arr[m][n] = 2;  // 标记路径
            printPath(arr); // 打印当前路径的地图状态
            arr[m][n] = 0;  // 回溯，恢复未访问状态
            return pathCount + 1;  // 增加路径计数
        }

        // 越界或已访问
        if (m < 0 || m >= arr.length || n < 0 || n >= arr[0].length || arr[m][n] != 0) {
            return pathCount;
        }

        // 标记当前位置在路径中
        arr[m][n] = 2;

        // 四个方向递归搜索
        pathCount = findAllPaths(arr, m + 1, n, pathCount); // 向下
        pathCount = findAllPaths(arr, m - 1, n, pathCount); // 向上
        pathCount = findAllPaths(arr, m, n + 1, pathCount); // 向右
        pathCount = findAllPaths(arr, m, n - 1, pathCount); // 向左

        // 回溯，恢复未访问状态
        arr[m][n] = 0;

        return pathCount;
    }

    public static void main(String[] args) {
        int m = 5, n = 6;
        int[][] arr = new int[m][n];
        // 设置边界为不可访问
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
            arr[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
            arr[m - 1][i] = 1;
        }

        UniquePath uniquePath = new UniquePath();
        int totalPaths = uniquePath.findAllPaths(arr, 1, 1, 0);
        System.out.println("Total paths found: " + totalPaths);
    }
}

