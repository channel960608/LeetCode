package channel.leetcode.questions.ExistOnce;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Caspar
 * @CreateTime 2020/4/28 17:14
 * @Description:
 */

class Solution {
    public int[] singleNumbers(int[] nums) {
        Boolean[] arr = new Boolean[10001];
        for (int i = 0; i < 10001; i++) {
            arr[i] = false;
        }
        for (int i:nums) {
            arr[i]=(!(arr[i]));
        }

        int[] list_ans = new int[2];
        int index = 0;
        for (int i=0;i<10001;i++) {
            if (arr[i]==Boolean.TRUE) {
                list_ans[index] = i;
                index++;
            }
        }

        return list_ans;
    }
}