package channel.leetcode.questions.StringToInteger;

/**
 * @Author Caspar
 * @CreateTime 2020/5/5 15:32
 * @Description:
 */
class Solution {
    public static int myAtoi(String str) {
        /**
         * 1. 跳过空格 找到+/-或数字
         * 2. 判断数字开头与结尾，截取出数字
         * 3. 判断数字是否越界，返回正确的结果
         */

        int ans = 0;
        int left = -1;
        int right = -1;
        int flag = 0;
        char[] arr_char = str.toCharArray();
        int i = 0;
        while (i<arr_char.length) {
            if (arr_char[i]==' ') {
                if (left>-1||flag!=0) {
                    break;
                } else i++;
            } else {
                if (arr_char[i]=='-') {
                    if (left>-1) break;
                    if (flag!=0) {
                        return 0;
                    }
                    flag=-1;
                    i++;

                } else if (arr_char[i]=='+') {
                    if (left>-1) break;
                    if (flag!=0) {
                        return 0;
                    }
                    flag=1;
                    i++;

                } else {

                    int isDigit = isDigit(arr_char[i]);
                    if (isDigit==0) {
                        if (left==-1) left=i;
                        right=i;
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        if (flag==0) flag=1;
        if (left==-1) return 0;

        while (arr_char[left]=='0' && left<right) {
            left++;
        }
        char[] arr_digit;
        if (flag==1) {
            arr_digit = new char[(right-left+1)];
            for (int j = left; j < right+1; j++) {
                arr_digit[j-left]=arr_char[j];
            }
        } else {
            arr_digit = new char[(right-left+2)];
            arr_digit[0] = '-';
            for (int j = left; j < right+1; j++) {
                arr_digit[j-left+1]=arr_char[j];
            }
        }



        return isOutOfRange(flag,arr_digit);

    }

    static int isDigit(char ch) {
        char[] arr_char = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
             for (char m_char : arr_char) {
            if (m_char==ch) {
                return 0;
            }
        }
        return 1;
    }

    static int isOutOfRange(int flag, char[] arr_ch) {
        int INTEGER_MAX = Integer.MAX_VALUE;
        int INTEGER_MIN = Integer.MIN_VALUE;
        char[] arr_max = String.valueOf(INTEGER_MAX).toCharArray();
        char[] arr_min = String.valueOf(INTEGER_MIN).toCharArray();
        boolean isOut = false;
        if (flag==1) {
            if (arr_max.length<arr_ch.length) {
                isOut=true;
            } else if (arr_max.length==arr_ch.length) {
                for (int i=0;i<arr_max.length;i++) {
                    if (arr_max[i]>arr_ch[i]) break;
                    else if (arr_max[i]<arr_ch[i]) isOut=true;
                }
            }
        } else {
            if (arr_min.length<arr_ch.length) {
                isOut=true;
            } else if (arr_min.length==arr_ch.length) {
                for (int i=1;i<arr_min.length;i++) {
                    if (arr_min[i]>arr_ch[i]) break;
                    else if (arr_min[i]<arr_ch[i]) isOut=true;
                }
            }
        }

        if (isOut) {
            if (flag==1) return INTEGER_MAX;
            else return INTEGER_MIN;
        } else {
//            System.out.println(arr_ch.toString());

            return Integer.valueOf(new String(arr_ch));
        }

    }

    public static void main(String[] args) {
        int ans = myAtoi("42");
        System.out.println(ans);
    }
}
