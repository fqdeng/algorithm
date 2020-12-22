package com.demo.org.algorithm.find.the.duplicate.number;

import org.junit.Assert;
import org.junit.Test;

public class Solution {


    public int findDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int lessThanMid = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    lessThanMid++;
                }
            }
            if (lessThanMid > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    @Test
    public void test() {
//        Assert.assertEquals(1, findDuplicate(new int[]{1, 1}));
        Assert.assertEquals(3, findDuplicate(new int[]{3, 1, 3, 4, 2}));
        Assert.assertEquals(2, findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
