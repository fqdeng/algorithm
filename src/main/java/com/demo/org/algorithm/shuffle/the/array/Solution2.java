package com.demo.org.algorithm.shuffle.the.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    /**
     * @link https://leetcode-cn.com/problems/shuffle-the-array/
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] results = new int[2 * n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            results[count] = nums[i];
            count ++;
            results[count] = nums[n + i];
            count ++;
        }
        return results;
    }

}
