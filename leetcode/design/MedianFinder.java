package leetcode.design;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MedianFinder {

    double sum;
    int count;

    public MedianFinder() {
    }

    public void addNum(int num) {
        sum += num;
        count++;
    }

    public double findMedian() {
        return sum / count;
    }

    @Test
    public void test1() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        assertEquals(1.5, mf.findMedian(), 0.0001);
        mf.addNum(3);
        assertEquals(2.0, mf.findMedian(), 0.0001);
    }
}
