package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SingleNonDuplicate{

    // https://leetcode.com/problems/single-element-in-a-sorted-array/

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length/2;

        int l = 0;
        int r = n;
        while(l<r){
           int m = l+(r-l)/2;
            if(nums[2*m]==nums[2*m+1]){
                l=m+1;
            }else{
                r=m-1;
            }

        }


        return nums[l];
    }

    @Test
    public void test1(){
        assertEquals(2, singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }
}