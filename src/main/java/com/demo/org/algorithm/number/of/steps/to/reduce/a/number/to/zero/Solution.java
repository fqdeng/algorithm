package com.demo.org.algorithm.number.of.steps.to.reduce.a.number.to.zero;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    /**
     * @link https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
     * @param num
     * @return
     */
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0){
                num = num / 2 ;
            }else{
                num--;
            }
            count++;
        }
        return count;
    }

    @Test
    public void test(){
        Assert.assertEquals(6,numberOfSteps(14));
    }
}
