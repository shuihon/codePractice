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
    public int uniuePaths(int m, int n) {
        //创建地图
        //0表示可以走的点，2表示走过且通的点，3表示走过但不同但点
        int arr[][] = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                System.out.println(arr[i][j]);
            }
        }
        return 0;
    }
   public boolean findWay(int[][] arr, int m , int n){
        if(arr[3][4]==2){
            return true;
         //找到出路
        } else  {
            //当前坐标可以走
            if(arr[m][n]==0){
                //假设表示可以走通，设为2
                arr[m][n]=2;
                //开始验证是否可以走通？
                //策略先向下走，再向右走
                if (findWay(arr,m+1,n)){
                    return true;
                } else if (findWay(arr,m,n+1)) {
                    return true;
                }else {
                    //走不通，设置为3
                    arr[m][n]=3;
                    return false;
                }
            }else {
                //arr[][] 2 3
                return false;
            }

        }
   }
    public boolean findWay2(int[][] arr, int m , int n){
        if(arr[3][4]==2){
            return true;
            //找到出路
        } else  {
            //当前坐标可以走
            if(arr[m][n]==0){
                //假设表示可以走通，设为2
                arr[m][n]=2;
                //开始验证是否可以走通？
                //策略先向you走，再向xia走
                if (findWay(arr,m,n+1)){
                    return true;
                } else if (findWay2(arr,m+1,n)) {
                    return true;
                }else {
                    //走不通，设置为3
                    arr[m][n]=3;
                    return false;
                }
            }else {
                //arr[][] 2 3
                return false;
            }

        }
    }

    public static void main(String[] args) {
        int m=5;
        int n=6;
        int arr[][] = new int[m][n];
        System.out.println("当前地图情况：");

        for (int i=0;i<n;i++){
            //第一行和最后一行设置壁垒
            arr[0][i]=1;
            arr[m-1][i]=1;
        }
        for (int i=0;i<m;i++){
            //第一列和最后一列设置壁垒
            arr[i][0]=1;
            arr[i][n-1]=1;
        }
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        UniquePath uniquePath = new UniquePath();
//        uniquePath.findWay(arr,1,1);
        uniquePath.findWay2(arr,1,1);
        System.out.println("走过路de地图情况：");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
