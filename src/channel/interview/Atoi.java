package channel.interview;
import java.util.HashMap;
/**
 * @Author Caspar
 * @CreateTime 2020/5/11 16:34
 * @Description:
 */


public class Atoi {

    public static int convert(String input) {

        HashMap map = initMap();
        String input_clean = input.trim();
        int flag = 0;
        if (input_clean.isEmpty()) return 0;
        int index = 0;
        if (input_clean.charAt(0)=='+') {
            flag = 1;
            index++;
        } else if (input_clean.charAt(0)=='-') {
            flag = -1;
            index++;
        } else {
            if (map.get(input_clean.charAt(0))==null) {
                return 0;
            }
            flag = 1;
        }
        int sum = 0;
        while (index<input_clean.length()) {
            if (map.get(input_clean.charAt(index))!=null) {

                int t = (int)map.get(input_clean.charAt(index));

                if (flag==1 && (Integer.MAX_VALUE/16-sum)>=0) {
                    sum = sum*16 + t;
                    index++;
                } else if (flag==-1 && (Integer.MAX_VALUE/16-sum)>=0){
                    sum = sum*16 + t;
                    index++;
                }  else return 0;
            } else return 0;

        }

        return sum*flag;

    }

    public static HashMap initMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);
        return map;
    }

    public static void main(String[] args) {
        int ans;
//        ans = convert("-80000000");

        ans = convert("7fffffff");

        System.out.println(ans);
//        System.out.println(Integer.MAX_VALUE);
//        Integer.
    }


}
