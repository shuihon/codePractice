package letCode;

/**
 * Created by @gaofenglin
 * on 2024/4/7.
 */
public class SingleNum {
    //    public int singleNumber(int[] nums) {
//        int output = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        if (nums.length == 1) {
//            return output = nums[0];
//
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                map.put(i, nums[i]);
//            }
//            for (int j = 0; j < nums.length; j++) {
//                for (int i = 1; i < nums.length; i++) {
//                    if (!(map.get(j) == nums[i]) && i != j) {
//                        output = map.get(j);
//                    }
//
//                }
//            }
//            return output;
//        }
//    }
//    public int singleNumber(int[] nums) {
//        int output = 0;
//        int temp = 0;
//
//        if (nums.length == 1) {
//            return output = nums[0];
//
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = 1; j < nums.length; j++) {
//                    if ((nums[i] == nums[j])) {
//                        temp = nums[i];
//                    }
//                }
//            }
//
//            return output;
//        }
//    }
    /*
    这段Java代码定义了一个名为`Solution`的类，其中包含一个名为`singleNumber`的方法。这个方法的目的是找出并返回在一个整数数组`nums`中唯一出现一次的数字。对于这个问题的一个关键条件是每个元素都出现两次，除了一个元素之外，这就是我们要找的。

    方法`singleNumber`使用了一种叫做位运算中的异或（XOR）操作来达到目的。下面是这段代码的详细解释：

            1. **方法签名**：`public int singleNumber(int[] nums)`。这意味着`singleNumber`是一个公开的方法，它接受一个整数类型数组`nums`作为参数，并返回一个整数。

            2. **初始化结果变量**：`int result=0;`。在开始遍历数组之前，首先初始化一个名为`result`的变量，其值为0。

            3. **遍历数组**：`for(int i=0; i<nums.length; i++)`。这个循环会遍历`nums`数组中的每一个元素。

            4. **异或操作**：`result = result ^ nums[i];`。在循环的每一步中，都对`result`变量和当前遍历到的元素`nums[i]`进行异或操作。异或操作的特点是：
            - 任何数和0进行异或运算结果仍然是原数，即`a ^ 0 = a`。
            - 任何数和其自身进行异或运算结果是0，即`a ^ a = 0`。
            - 异或运算满足交换律和结合律，即`a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b`。

    因此，由于数组中除了一个数字之外，其他的数字都是成对出现的，成对出现的数字在进行异或操作时会互相抵消变成0，只留下那个唯一出现一次的数字。例如，假设数组是`[2,1,4,5,2,4,1]`，那么执行异或操作的过程是`(2^2)^(1^1)^(4^4)^5=0^0^0^5=5`，最后留下的就是那个只出现一次的数字5。

            5. **返回结果**：`return result;`。最后，`result`变量中的值就是数组中唯一出现一次的数字，方法返回这个结果。

    这个解决方案的美妙之处在于它的高效性：时间复杂度为O(n)，因为需要遍历一遍数组；空间复杂度为O(1)，因为没有使用额外的存储空间。
*/
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
/*
*           - 任何数和0进行异或运算结果仍然是原数，即`a ^ 0 = a`。
            - 任何数和其自身进行异或运算结果是0，即`a ^ a = 0`。
            - 异或运算满足交换律和结合律，即`a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b`。
            * */
            result = result ^ nums[i];
        }
        return result;
    }
}
