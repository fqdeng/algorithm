package com.demo.org.algorithm.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution {

    /**
     * return the position of target number or the position of the fist number than target number
     * @param nums
     * @param high the high position of nums
     * @param low the low position of nums
     * @return
     */
    int binaryPositionSearch(int[] nums, int low, int high, int target) {
        //low = 0;
        //high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void testBinarySearch() {
        int[] arrays = new int[]{4, 52, 12, 113, 312, 5};
        Arrays.sort(arrays);
        System.out.println(Arrays.toString(arrays));
        Assert.assertTrue(binaryPositionSearch(arrays, 0, arrays.length - 1, 12) == 2);
        Assert.assertTrue(binaryPositionSearch(arrays, 0, arrays.length - 1, 13) == -1);
    }
}
