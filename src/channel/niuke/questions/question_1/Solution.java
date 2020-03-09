package channel.niuke.questions.question_1;

public class Solution {

    public int getPosition_x(int target, int [][] array, int left, int right) {

        if (left+1==right) {
            return right;
        }

        int mid = (left + right)/2;
        if (array[0][mid]>target) {
            return getPosition_x(target, array, left, mid);
        } else {
            return getPosition_x(target, array, mid, right);
        }
    }

    public int getPosition_y(int target, int [][] array, int left, int right) {

        if (left+1==right) {
            return right;
        }

        int mid = (left + right)/2;
        if (array[mid][0]>target) {
            return getPosition_y(target, array, left, mid);
        } else {
            return getPosition_y(target, array, mid, right);
        }
    }

    public boolean Find(int target, int [][] array) {
        int width = 0;
        width = array.length;
        if (width == 0) {
            return false;
        }
        int height;
        height = array[0].length;

        if (height==0) {
            return false;
        }

        if (array[0][0] > target) {
            return false;
        }

        if (array[width-1][height-1] < target) {
            return false;
        }
        int array_1, array_2;
        array_1 = getPosition_x(target, array, 0, height);
        array_2 = getPosition_y(target, array, 0, width);
        int x,y;
        x = array_1;
        y = array_2;

        if (target == array[y][x]) {
            return true;
        }

        for (int i = x; i < height && array[y][i] < target; i++) {
            if (target == array[y][i]) {
                return true;
            }
        }

        for (int i = x; i < width && array[i][x] < target; i++) {
            if (target == array[i][x]) {
                return true;
            }
        }

        return false;


    }


    public static void main(String args[]) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};



    }


}