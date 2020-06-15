package channel.leetcode.questions.ExistOnce;

/**
 * @Author Caspar
 * @CreateTime 2020/5/5 14:53
 * @Description:
 */
public class Solution_updated {
    public int[] singleNumbers(int[] nums) {
        int i = 0;
        for (int num:nums) {
            i ^= 1<<num;
        }

        return null;
    }
}
