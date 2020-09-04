package com.demo.org.algorithm.qiu.number.lcof;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }

    @Test
    public void test() {
        Assert.assertEquals(6, sumNums(3));
    }
}
