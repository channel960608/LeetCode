package channel.leetcode.questions.LongestPalindromicSubstring;

/**
 * @Author Caspar
 * @CreateTime 2020/6/4 12:54
 * @Description:
 */
class Solution {
    public static String longestPalindrome(String s) {

        int len = s.length();
        if (len<=1) return s;
        int left_index = 0;
        int right_index = 0;
        int size = 0;
        // 处理奇数回文
        for(int i = 1; i < len-1; i++) {
            int padding = 1;
            while(i-padding>=0 && i+padding<=len-1 && s.charAt(i-padding)==s.charAt(i+padding)) padding++;
            padding--;
            if (2*padding+1>size) {
                size = 2*padding+1;
                left_index = i - padding;
                right_index = i + padding;
            }
        }
        // 处理偶数回文
        for(int i = 0; i < len-1; i++) {
            int padding = 1;
            while(i-padding+1>=0 && i+padding<=len-1 && s.charAt(i-padding+1)==s.charAt(i+padding)) padding++;
            padding--;
            if (2*padding>size) {
                size = 2*padding+1;
                left_index = i - padding+1;
                right_index = i + padding;
            }
        }

        return s.substring(left_index, right_index+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
