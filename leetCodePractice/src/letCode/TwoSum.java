package letCode;


//import org.junit.Test;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by @gaofenglin
 * on 2024/4/7.
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints= {1,2,3,4};
        twoSum.twoSum(ints,5);

    }
    @Test
    public int[] twoSum(int[] nums, int target) {
        int temp;
        int i;
        int j;
        ArrayList outPut = new ArrayList();
        for (i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            for (j = 1; j < nums.length; j++) {
                if (temp == nums[j]&&!outPut.contains(i)) {
                    outPut.add(i);
                    outPut.add(j);
                }
            }
        }
        int[] ints = new int[outPut.size()];
        for (int x = 0; x < outPut.size(); x++) {
            ints[x] = (int) outPut.get(x);
        }
        return ints;
    }
}
