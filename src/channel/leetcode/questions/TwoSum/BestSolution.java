package channel.leetcode.questions.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class BestSolution {
    public int[] twoSum(int[] nums, int target) {

        Map map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; map.put(nums[i], ++i)) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{(int)map.get(target - nums[i]), i+1};
            }
        }
        return new int[]{0, 0};
    }
}
