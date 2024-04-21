package baseProblem.recursion;

/**
 * Created by @gaofenglin
 * on 2024/4/21.
 */
//0 1 1 2 3 5 8 13
public class Fibo {
    public int findFibo(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return findFibo(num - 1) + findFibo(num - 2);
        }
    }

    public static void main(String[] args) {
        int fibo = new Fibo().findFibo(2);
        System.out.println(fibo);
    }

}
