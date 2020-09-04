package com.demo.org.algorithm.easy.record.numbers;

public class Solution {


    /**
     * 双重循环找出 重复的相同排列
     * N2
     * @link https://leetcode-cn.com/problems/number-of-good-pairs/
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
