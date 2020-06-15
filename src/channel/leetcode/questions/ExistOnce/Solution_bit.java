package channel.leetcode.questions.ExistOnce;

/**
 * @Author Caspar
 * @CreateTime 2020/5/4 00:14
 * @Description:
 */
public class Solution_bit {
    public static int[] singleNumbers(int[] nums) {
        //用于将所有的数异或起来
        int k = 0;

        for(int num: nums) {
            k ^= num;
        }

        //获得k中最低位的1
        int mask = 1;

        //mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
        while((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for(int num: nums) {
            if((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    public static  void main(String[] args) {
        int[] input_arr = {1,2,3,1};
        int[] ans_arr = singleNumbers(input_arr);
        return;
    }

}
