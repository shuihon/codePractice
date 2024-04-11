package paiza.standard_input;

/**
 * Created by @gaofenglin
 * on 2024/3/30.
 * 入力される値
 * 需求：
 * 1 行目で整数 N が与えられます。
 * 2 行目以降で N 行 M_i + 1 列の行列が与えられます。
 * 以下の形式で標準入力によって与えられます。
 * N
 * M_1 a_{1,1} ... a_{1,M_1}
 * ...         ...
 * M_N a_{N,1} ... a_{N,M_N}
 * 入力値最終行の末尾に改行が１つ入ります。
 * 期待する出力
 * <p>
 *     N 行 M_i 列の行列をそのまま出力してください。
 *     また、末尾に改行を入れ、余計な文字、空行を含んではいけません。
 *
 *     a_{1,1} ... a_{1,M_1}
 *     ...          ...
 *     a_{N,1} ... a_{N,M_N}
 *

 入力例1

 3
 1 8
 2 8 1
 3 8 1 3

 出力例1

 8
 8 1
 8 1 3
 */

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 读取第一行的内容
        String line = sc.nextLine();
        // 确认循环的次数
        int rows= Integer.parseInt(line);
        for (int i=0;i<rows ; i++) {
            //循环读取第二行之后的内容
            line=sc.nextLine();
            //对每行内容进行一个分割，形成字符串数组
            String [] nums=line.split(" ");
            //针对每一行提取出的字符串数组进行内部读取
            for(int j =1;j<nums.length;j++){
                //根据输出情况分为数字有空格和数字没有空格的情况
                if(j!=nums.length-1){
                    System.out.print(nums[j]+" ");
                }else{
                    System.out.println(nums[j]);
                }
            }
        }

    }
}
