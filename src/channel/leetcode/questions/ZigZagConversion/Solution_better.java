package channel.leetcode.questions.ZigZagConversion;

public class Solution_better {

    public String convert(String s, int numRows) {

        if(s.length() <= 1){
            return s;
        }

        char[] result = new char[s.length()];
        char[] chars = s.toCharArray();
        int j = 0;

        int maxGap = 2*(numRows - 1);
        if(maxGap == 0)
            return s;

        int gap,nextGap,tampGap;

        for(int i = 0 ; i < numRows ; i++){
            if(i == 0 || i == numRows - 1){
                gap = maxGap;
                nextGap = maxGap;
            }else{
                gap = maxGap - 2*i;
                nextGap = maxGap - gap;
            }

            int newIndex = i;
            while(newIndex < s.length()){
                result[j] = chars[newIndex];
                newIndex += gap;
                j++;
                tampGap = gap;
                gap = nextGap;
                nextGap = tampGap;
            }
        }

        return new String(result);
    }

    public static void main(String args[]) {
        String ans = new Solution().convert("PAYPALISHIRING", 4);
        System.out.println(ans);
    }

}

