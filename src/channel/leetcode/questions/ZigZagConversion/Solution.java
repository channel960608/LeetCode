package channel.leetcode.questions.ZigZagConversion;

public class Solution {

    public String convert(String s, int numRows) {
        int length = s.length();
        if (length<=numRows) {
            return  s;
        }
        if (numRows==1) {
            return s;
        }

        int round_num = length / (numRows + numRows - 2);
        int round_count = 2 * numRows - 2;

        char[][] char_arr = new char[numRows][(round_num+1) * (numRows - 1)];

        for (int i = 0; i <= round_num; i++) {
            for (int j = 0; j <= round_count; j++) {
                int index = i * round_count + j;
                if (index < length) {
                    char m_char = s.charAt(index);
                    if (j < numRows) {
                        char_arr[j][i * (numRows - 1)] = m_char;
                    } else {
                        char_arr[2*numRows-j-2][i * (numRows - 1) + j-numRows+1] = m_char;
                    }
                }
            }
        }

        String str = "";

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < (round_num+1) * (numRows - 1); j++) {
                if (char_arr[i][j]!='\u0000')
                    str += String.valueOf(char_arr[i][j]);
            }
        }

        return str;


    }


    public static void main(String args[]) {
        String ans = new Solution().convert("PAYPALISHIRING", 4);
        System.out.println(ans);
    }

}
