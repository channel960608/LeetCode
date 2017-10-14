package channel.leetcode.questions.MedianOfTwoSortedArrays;

import javax.sound.midi.SysexMessage;
import java.util.TreeSet;

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i : nums1)
            treeSet.add(i);
        for (int i : nums2)
            treeSet.add(i);


        int size = treeSet.size();

        int[] ans = new int[size];

        int index = 0;
        for (Integer i : treeSet) {
            ans[index++] = i;
        }

        if (size == size / 2 * 2)
            return 0.5 * ans[size/2] + 0.5 * ans[size/2-1];
        else
            return ans[size/2];
    }

    public static void main(String args[]) {
        int[] array1 = new int[]{1, 1};
        int[] array2 = new int[]{1, 2};


        findMedianSortedArrays(array1, array2);
    }
}
