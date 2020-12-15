package com.demo.org.algorithm.maximum.number.of.coins.you.can.get;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    /**
     * @param piles
     * @return
     * @link https://leetcode-cn.com/problems/maximum-number-of-coins-you-can-get/
     */
    public int maxCoins(int[] piles) {
        //排序
        Arrays.sort(piles);
        int max = 0;
        int j = 0;
        //双指针法 让i从后面往前走，每次走两步，j从前往后走，每次偶组一步，i-1为最优解
        for (int i = piles.length - 1; i > j; i -= 2) {
            max += piles[i - 1];
            j++;
        }
        return max;
    }

    @Test
    public void test() {
        Assert.assertEquals(18, maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
    }
}
