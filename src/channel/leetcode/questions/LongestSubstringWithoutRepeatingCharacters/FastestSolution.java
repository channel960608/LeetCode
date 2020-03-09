package channel.leetcode.questions.LongestSubstringWithoutRepeatingCharacters;

public class FastestSolution {
    public int lengthOfLongestSubstring(String s) {
        int[] idx = new int[128];
        for(int i = 0; i < idx.length; i++) idx[i] = -1;

        int ans = 0, start = 0;
        for(int i = 0; i < s.length(); i++){
            int cIdx = s.charAt(i);//字符转化成了数字
            if(idx[cIdx]>=start)  start = idx[cIdx]+1;
            idx[cIdx] = i;
            ans = Math.max(ans, i-start+1);
        }
        return ans;
    }
}
