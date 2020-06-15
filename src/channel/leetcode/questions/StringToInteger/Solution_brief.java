package channel.leetcode.questions.StringToInteger;

/**
 * @Author Caspar
 * @CreateTime 2020/5/5 15:32
 * @Description:
 */
class Solution_brief {
    public static int myAtoi(String str) {
        int sign = 1, i = 0, r = 0;
        str = str.trim();
        if (str.isEmpty()) return 0;
        else if (str.charAt(i) == '-') { i++; sign = -1; }
        else if (str.charAt(i) == '+') { i++; }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int d = str.charAt(i) - '0';
            if (r > (Integer.MAX_VALUE - d) / 10) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            r = r * 10 + d;
            i++;
        }
        return r * sign;
    }

    public static void main(String[] args) {
        int ans = myAtoi("42");
        System.out.println(ans);
    }
}
