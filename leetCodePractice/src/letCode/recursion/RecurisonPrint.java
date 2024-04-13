package letCode.recursion;

/**
 * Created by @gaofenglin
 * on 2024/4/13.
 */
public class RecurisonPrint {
    public static void main(String[] args) {
        T t = new T();
        t.printRecursion(4);
    }
}

class T {
    public void printRecursion(int t) {
        if (t > 2) {
            printRecursion(t - 1);
        }
        System.out.println(t);
    }
}
