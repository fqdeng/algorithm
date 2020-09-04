package com.demo.org.algorithm.running.sum.of.one.day.array;

public class Solution {

    /**
     * @link https://leetcode-cn.com/problems/running-sum-of-1d-array/
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
           nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
