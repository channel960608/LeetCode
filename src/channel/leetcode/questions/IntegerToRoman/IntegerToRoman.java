package channel.leetcode.questions.IntegerToRoman;
//Roman numerals are represented by seven different symbols: I, V, X, L, C, D an
//d M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, two is written as II in Roman numeral, just two one's added toge
//ther. Twelve is written as, XII, which is simply X + II. The number twenty seven
// is written as XXVII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. Ho
//wever, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same prin
//ciple applies to the number nine, which is written as IX. There are six instance
//s where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given an integer, convert it to a roman numeral. Input is guaranteed to be wi
//thin the range from 1 to 3999. 
//
// Example 1: 
//
// 
//Input: 3
//Output: "III" 
//
// Example 2: 
//
// 
//Input: 4
//Output: "IV" 
//
// Example 3: 
//
// 
//Input: 9
//Output: "IX" 
//
// Example 4: 
//
// 
//Input: 58
//Output: "LVIII"
//Explanation: L = 50, V = 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: 1994
//Output: "MCMXCIV"
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. 
// Related Topics Math String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static String intToRoman(int num) {
//        int[] value_list = new int[]{1000, 500, 100, 50, 10, 5, 1};
//        char[] symbol_list = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
//        int[] count_list = new int[7];
//        for (int i = 0; i < value_list.length; i++) {
//            count_list[i] = num / value_list[i];
//            num = num % value_list[i];
//        }

        StringBuffer sb = new StringBuffer();
        int M = num/1000;
        for (int i = 0; i < M; i++) sb.append('M');
        int C = (num%1000)/100;
        if (C>=5) {
            if (C==9) sb.append("CM");
            else {
                sb.append('D');
                for (int i = 0; i < C-5; i++) sb.append('M');
            }
        } else {
            if (C==4) sb.append("CD");
            else {
                for (int i = 0; i < C; i++) sb.append('M');
            }
        }
        int X = (num%100)/10;
        if (X>=5) {
            if (X==9) sb.append("XC");
            else {
                sb.append('L');
                for (int i = 0; i < X-5; i++) sb.append('X');
            }
        } else {
            if (X==4) sb.append("XL");
            else {
                for (int i = 0; i < X; i++) sb.append('X');
            }
        }

        int I = num%10;
        if (I>=5) {
            if (I==9) sb.append("IX");
            else {
                sb.append('V');
                for (int i = 0; i < X-5; i++) sb.append('I');
            }
        } else {
            if (I==4) sb.append("IV");
            else {
                for (int i = 0; i < I; i++) sb.append('I');
            }
        }

        return sb.toString();


    }
    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
