package channel.leetcode.questions.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map map = new HashMap<Character, Integer>();
        char[] array = s.toCharArray();
        int num = 0;
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null || (int)map.get(array[i]) < left) {
                map.put(array[i], i);
                if(i == array.length - 1)
                    num = num > (i - left + 1) ? num : (i - left + 1);
            }
            else {
                int len = i - left;
                num = num > len ? num : len;
                left = (int)map.get(array[i]) + 1;
                map.put(array[i], i);
            }
        }
        return num;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring("tmmzuxt");
    }
}
