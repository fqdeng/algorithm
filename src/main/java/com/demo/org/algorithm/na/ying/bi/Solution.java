package com.demo.org.algorithm.na.ying.bi;

import org.junit.Test;

public class Solution {
    public int minCount(int[] coins) {
        int res = 0;
        for (int coin: coins) {
            res += (coin + 1) / 2;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(minCount(new int[]{2, 3, 10}));
        System.out.println(minCount(new int[]{3, 4}));
    }
}
