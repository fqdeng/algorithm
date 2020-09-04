package com.demo.org.algorithm.create.target.array.in.the.given.order;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] result = new int[index.length];
        for (int i = 0; i < nums.length; i++) {
            if(result[index[i]] != 0){
                move(result,index[i]);
            }
            result[index[i]] = nums[i];
        }
        return result;
    }

    private int[] move(int[] target, int start) {
        int temp = target[start];
        for (int i = start; i < target.length; i++) {
            if (i + 1 >= target.length) {
                continue;
            }
            int i1 = target[i + 1];
            target[i + 1] = temp;
            temp = i1;
        }
        return target;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 2, 2, 3, 4}, move(new int[]{1, 2, 3, 4, 5}, 1));
        Assert.assertArrayEquals(new int[]{0, 4, 1, 3, 2}, createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1}));
    }

}
