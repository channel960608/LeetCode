package channel.leetcode.questions.MedianOfTwoSortedArrays;

public class QuickSort {
    public static void sort(int[] array, int lo, int hi) {
        if(lo >= hi) {
            return;
        }

        int index = partition(array, lo, hi);
        sort(array, lo, index-1);
        sort(array, index + 1, hi);
    }

    public static int partition(int[] array, int lo, int hi) {
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo)
                hi--;
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo)
                lo++;
            array[hi] = array[lo];

        }

        array[hi] = key;
        return hi;

    }

    public static void main(String args[]) {
        sort(new int[]{5,6,3,7,4}, 0, 4);
    }
}
