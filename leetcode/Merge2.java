package leetcode;

public class Merge2 {

    // https://leetcode.com/problems/merge-sorted-array/

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n;
        m--;
        n--;

        while (--index >= 0) {

            if (m >= 0 && n >= 0) {
                if (nums1[m] < nums2[n]) {
                    nums1[index] = nums2[n--];
                } else {
                    nums1[index] = nums1[m--];
                }
            } else if (m >= 0) {
                nums1[index] = nums1[m--];
            } else {
                nums1[index] = nums2[n--];
            }

        }

    }

}
