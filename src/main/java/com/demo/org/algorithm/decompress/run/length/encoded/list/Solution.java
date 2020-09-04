package com.demo.org.algorithm.decompress.run.length.encoded.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param nums
     * @return
     * @link https://leetcode-cn.com/problems/decompress-run-length-encoded-list/
     */
    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
               length += nums[i];
            }
        }
        int[] results = new int[length];
        int position = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < nums[i]; j++) {
                    results[position] = nums[i + 1];
                    position++;
                }
            }
        }
        return results;
    }

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{1,3,3},decompressRLElist(new int[]{1,1,2,3}));
    }
}
