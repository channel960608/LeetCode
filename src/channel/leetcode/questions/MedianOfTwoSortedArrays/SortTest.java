package channel.leetcode.questions.MedianOfTwoSortedArrays;

public class SortTest {
    static void quicksort(int[] array, int lo, int hi) {
        if (lo >= hi)
            return;
        int splitpoint = split(array, lo, hi);
        quicksort(array, lo, splitpoint - 1);
        quicksort(array, splitpoint + 1, hi);



    }

    static int split(int[] array, int lo, int hi) {
        int key = array[lo];
        while (lo < hi) {

            while (array[hi] >= key && lo < hi)
                hi--;
            array[lo] = array[hi];
            while (array[lo] <= key && lo < hi)
                lo++;
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;

    }

    public static void main(String args[]) {
        int[] array = new int[]{5,6,3,4,2,5,1,1,7,4};
        quicksort(array, 0, 9);
        for(int i : array)
            System.out.println(i);
    }
}
