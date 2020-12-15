package com.demo.org.algorithm.candies;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    /**
     * O(N) 时间复杂度
     * 实际计算2N
     * @param candies
     * @param extraCandies
     * @link https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = 0;
        for (int candy : candies) {
           if (candy > max) {
               max = candy;
           }
        }
        List<Boolean> results = new ArrayList<>();
        for (int candy : candies) {
            if ((candy + extraCandies) >= max) {
                results.add(Boolean.TRUE);
                continue;
            }
            results.add(Boolean.FALSE);
        }
        return results;
    }

}
