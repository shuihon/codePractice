package letCode;

/**
 * Created by @gaofenglin
 * on 2024/6/2.
 */
public class CoinChange {
    // 定义硬币的面额
    static int[] coins = {1, 2, 5};

    public static void main(String[] args) {
        int amount = 11;
        int result = minCoins(amount);
        if (result == Integer.MAX_VALUE) {
            System.out.println("无法凑出该金额");
        } else {
            System.out.println("最少硬币数量: " + result);
        }
    }

    public static int minCoins(int amount) {
        // 基准情况
        if (amount == 0) return 0; // 最小子问题：amount为0时，不需要硬币
        if (amount < 0) return Integer.MAX_VALUE; // 无效情况：amount为负时，返回最大值表示不可能

        // 递归情况
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = minCoins(amount - coin);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }
        return min;
    }
}

