package baseProblem.hanoi;

/**
 * Created by @gaofenglin
 * on 2024/4/14.
 */
public class HanoiTower {
    public static void main(String[] args) {
        Tower tower = new Tower();
        tower.move(2,'A','B','C');
    }
}

class Tower {
    private int count;

    public void move(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println(a + ">" + c);
            count += 1;
        } else{
            move(num - 1, a, c, b);
            System.out.println(a + ">" + c);
            count += 1;
            move(num - 1, b, c, a);
            System.out.println(b + ">" + c);
            count += 1;
        }
        System.out.println("移动次数："+count);
    }

}
