package com.demo.org.algorithm.max.increase.to.keep.city.skyline;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * @link https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/solution/bao-chi-cheng-shi-tian-ji-xian-by-siegfried-2/
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        List<Integer> xMax = new ArrayList<>();
        List<Integer> yMax = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[i].length; j++) {
                int current = grid[i][j];
                if (current > max) {
                    max = current;
                }
            }
            xMax.add(max);
        }


        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                int current = grid[j][i];
                if (current > max) {
                    max = current;
                }
            }
            yMax.add(max);
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int min = Math.min(xMax.get(i), yMax.get(j));
                if (min > grid[i][j]) {
                    int increase = min - grid[i][j];
                    result += increase;
                }
            }
        }


        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(35,
                maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
    }


}
