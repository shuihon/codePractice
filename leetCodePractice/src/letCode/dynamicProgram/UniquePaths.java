package letCode.dynamicProgram;

/**
 * Created by @gaofenglin
 * on 2024/5/18.
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int m = 3;
        int n = 2;
        int result = solution.uniquePaths(m, n);
        System.out.println("Number of unique paths: " + result);  // Output: 3
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }


}

