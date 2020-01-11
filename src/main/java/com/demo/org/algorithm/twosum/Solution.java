package com.demo.org.algorithm.twosum;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueCorrespondPos = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            valueCorrespondPos.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int anotherNum = target - number;
            Integer anotherNumPos = valueCorrespondPos.get(anotherNum);
            if (valueCorrespondPos.containsKey(anotherNum) && i != anotherNumPos) {
                return new int[]{i, anotherNumPos};
            }
        }
        return null;
    }

    @Test
    public void testTwoSum() {
        int[] arrays = new int[]{4, 52, 12, 113, 312, 5};
        Arrays.sort(arrays);
        Assert.assertArrayEquals(new int[]{3, 4}, twoSum(arrays, 165));
        Assert.assertArrayEquals(null, twoSum(arrays, 1));
    }

    @Test
    public void testTwoSumCase2() {
        int[] arrays = new int[]{3, 2, 4};
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum(arrays, 6));
    }
}
