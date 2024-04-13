package letCode.Recursion;

/**
 * Created by @gaofenglin
 * on 2024/4/13.
 */
public class Factorial {
    public static void main(String[] args) {
        T t = new T();
        System.out.println(t.factorial(5));
    }
}

class T {
    public int factorial(int a) {
        if (a == 1) {
            return 1;
        } else {
            return factorial(a - 1) * a;
        }
    }
}

