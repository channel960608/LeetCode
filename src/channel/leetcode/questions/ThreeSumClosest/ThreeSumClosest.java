package channel.leetcode.questions.ThreeSumClosest;

//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics Array Two Pointers


import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        solution.threeSumClosest(new int[]{-1,2,1,-4}, 1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int res = 0;
        int dif = 1000000;
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (i==0||nums[i]!=nums[i-1]) {
                int j = i + 1, k = nums.length-1;
                while (j<k) {
                    int close = c-nums[j]-nums[k];
                    dif = Math.min(dif, Math.abs(close));
                    if (dif==Math.abs(close)) res = nums[i] + nums[j] + nums[k];
                    if (close>0) {
                        while (j<k&&nums[j]==nums[j+1]) j++;
                        j++;
                    } else if (close<0) {
                        while (j<k&&nums[k]==nums[k-1]) k--;
                        k--;
                    } else {
                        return target;
                    }
                }
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}