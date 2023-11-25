package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HandleQuery {

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        List<Long> result = new ArrayList<>();

        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
        }

        for (int i = 0; i < queries.length; i++) {

            if (queries[i][0] == 1) {
                for (int j = queries[i][1]; j <= queries[i][2]; j++) {
                    if (nums1[j] == 0) {
                        nums1[j] = 1;
                        sum1++;
                    } else {
                        nums1[j] = 0;
                        sum1--;
                    }
                }
            } else if (queries[i][0] == 2) {
                sum2 = sum2 + sum1 * queries[i][1];
            } else if (queries[i][0] == 3) {
                result.add(sum2);
            }

        }

        long[] res = new long[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    @Test
    public void test1() {
        assertArrayEquals(new long[] { 3 }, handleQuery(new int[] { 1, 0, 1 }, new int[] { 0, 0, 0 },
                new int[][] { { 1, 1, 1 }, { 2, 1, 0 }, { 3, 0, 0 } }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new long[] { 5 }, handleQuery(new int[] { 1 }, new int[] { 5 },
                new int[][] { { 2, 0, 0 }, { 3, 0, 0 } }));
    }
}
