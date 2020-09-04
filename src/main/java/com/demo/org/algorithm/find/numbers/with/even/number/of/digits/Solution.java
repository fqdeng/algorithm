package com.demo.org.algorithm.find.numbers.with.even.number.of.digits;

public class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            String numStr = String.valueOf(num);
            if (numStr.length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
