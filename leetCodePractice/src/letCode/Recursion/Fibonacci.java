package letCode.Recursion;

/**
 * Created by @gaofenglin
 * on 2024/4/13.
 */
public class Fibonacci {
    public static void main(String[] args) {
        T t = new T();
        System.out.println(t.fibonacci(7));
    }
}

class T {
    public int fibonacci(int a) {
        if (a > 0) {
            if (a == 1 || a == 2) {
                return 1;
            } else {
                return fibonacci(a - 1) + fibonacci(a - 2);
            }
        } else {
            System.out.println("要求输入大于0的整数");
        }
        return 0;
    }
}
