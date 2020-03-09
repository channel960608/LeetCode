package channel.leetcode.questions.MedianOfTwoSortedArrays;

class Solution_better {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if (m < n) {
            int[] C = A;
            A = B;
            B = C;
            m = m + n;
            n = m - n;
            m = m - n;
        }

        if (0 == n) {
            return (m+n)%2 == 0 ? ((float)A[(m+n)/2-1] + (float)A[(m+n)/2]) / 2 : (float)A[(m+n)/2];
        }

        int i = 0, j = 0;
        float mid = 0f;
        while (i + j < (m+n+1)/2) {
            if (j == n) {
                mid = A[i];
                i++;
            } else if (i == m) {
                mid = B[j];
                j++;
            } else if (A[i] < B[j]) {
                mid = A[i];
                i++;
            } else {
                mid = B[j];
                j++;
            }
        }
        if (!((m+n)%2 == 0)) {
            return mid;
        } else {
            if (j == n) {
                mid = ((float)A[i] + mid) / 2;
            } else if (i == m) { ;
                mid = ((float)B[j] + mid) / 2;
            } else if (A[i] < B[j]) {
                mid = ((float)A[i] + mid) / 2;
            } else {
                mid = ((float)B[j] + mid) / 2;
            }
            return mid;
        }


    }

    public static void main(String args[]) {
        int[] array1 = new int[]{1, 5};
        int[] array2 = new int[]{1, 2};


        System.out.print(new Solution_better().findMedianSortedArrays(array1, array2));
    }
}