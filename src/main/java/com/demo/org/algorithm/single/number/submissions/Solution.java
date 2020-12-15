package com.demo.org.algorithm.single.number.submissions;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i] ;
        }
        return result;
    }

    @Test
    public void test(){
        Assert.assertEquals(singleNumber(new int[]{1,2,2,3,3,4,4}),1);
    }
}
