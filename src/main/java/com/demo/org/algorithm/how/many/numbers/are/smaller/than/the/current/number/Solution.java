package com.demo.org.algorithm.how.many.numbers.are.smaller.than.the.current.number;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        List<Integer> numberSmallerThanCount = new ArrayList<>(Arrays.asList(new Integer[100]));
        Collections.fill(numberSmallerThanCount,0);
        for (int i = 0; i < nums.length; i++) {
            int pos = nums[i];
            Integer frequency = numberSmallerThanCount.get(pos);
            numberSmallerThanCount.set(pos, frequency + 1);
        }
        for (int i = 1; i < 100 ; i++) {
            Integer count = numberSmallerThanCount.get(i - 1) + numberSmallerThanCount.get(i);
            numberSmallerThanCount.set(i,count);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                result[i] = 0;
                continue;
            }
            result[i] = numberSmallerThanCount.get(nums[i]-1);
        }
        return result;
    }

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{2,1,0,3,4,5},smallerNumbersThanCurrent(new int[]{8,4,2,10,22,55}));
    }
}
