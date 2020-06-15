package channel.leetcode.questions.ExistOnce;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Caspar
 * @CreateTime 2020/5/5 14:53
 * @Description:
 */
public class Solution_modified {
    public int[] singleNumbers(int[] nums) {
        int k = 0;
        for (int num:nums) {
            k^=num;
        }

        int mask = 1;
        while ((k&mask)==0) {
            mask<<=1;
        }

        int a = 0;
        int b = 0;

        for (int num:nums) {
            if ((num&mask)==0) {
                a^=num;
            } else {
                b^=num;
            }
        }
        return new int[]{a, b};
    }
}
