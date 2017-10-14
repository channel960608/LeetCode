package channel.leetcode.questions.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Example {
    public int slideWindowOptimized(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j)))
                i = Math.max(map.get(s.charAt(j)), i);
            ans = Math.max(ans, j - 1 + 1);
            map.put(s.charAt(j), j + 1);
        }

        return ans;
    }

    public int assumingASCII(String s) {
        int n = s.length(), ans = 0;
        //利用ASCII的特点，使用长度为128的数组来代替Map进行查重，可将index数组中的下标视为Map中的key，index的值视为Map的value
        int[] index = new int[128];
        for(int j = 0, i = 0; j < n; j++) {
            // i标记活动窗口左下标，j标记活动窗口右下标
            //如果已经存在index[s.charAt(j)]这个字符，则将滑动窗口左下标移动至重复元素中第一个元素的下标后一位，如果没有重复则i不移动
            i = Math.max(index[s.charAt(j)], i);
            //计算窗口长度并比较是否比之前大
            ans = Math.max(ans, j - i + 1);
            //在index数组中更新元素的下标，设置为下标+1
            index[s.charAt(j)] = j + 1;
        }

        return ans;
    }



    public static void main(String args[]) {
        Example e = new Example();
       // e.slideWindowOptimized("abcabcbcsersfsa");
        e.assumingASCII("abcabcbcsersfsa");
    }

}
