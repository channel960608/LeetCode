package channel.TargetToOffer.question1;

/**
 * @Author Caspar
 * @CreateTime 2020/3/9 19:59
 * @Description:
 */
public class Solution {

    public boolean Find(int target, int [][] array) {
        int len_x = array.length;
        if (len_x==0) return false;
        int len_y = array[0].length;
        if (len_y==0) return false;

        int x = len_x-1;
        int y = 0;

        while (x>=0 && y<=len_y-1) {
            if (array[x][y] == target) {
                return true;
            } else if (array[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }

        return false;
    }



    public static void main(String... args) {
        int [][] array = {{1,2,3},{4,5,6}};
        int a = 0;
    }

}
