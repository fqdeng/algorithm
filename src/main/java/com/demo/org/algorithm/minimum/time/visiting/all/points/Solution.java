package com.demo.org.algorithm.minimum.time.visiting.all.points;

import org.junit.Assert;
import org.junit.Test;


public class Solution {

    /**
     * @param points
     * @return
     * @link https://leetcode-cn.com/problems/minimum-time-visiting-all-points/submissions/
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            result += getMinTime(points[i], points[i + 1]);
        }
        return result;
    }

    int getMinTime(int[] start, int[] end) {
        //这个题目在于观察
        //如果两点x或者y轴是相同的，那么直线距离最短
        if (start[0] == end[0]) {
            //x轴相等 直线最短
            return Math.abs(end[1] - start[1]);
        }
        if (start[1] == end[1]) {
            //y轴相等 直线最短
            return Math.abs(end[0] - start[0]);
        }

        int yDiff = Math.abs(start[1] - end[1]);
        int xDiff = Math.abs(start[0] - end[0]);

        if (xDiff > yDiff) {
            //如果x方向上的绝对差值 > y方向上的绝对差值
            //那么先倾斜yDiff个单位 然后再直线运动 xDiff-yDiff个单位 即可
            return yDiff + (xDiff - yDiff);
        } else {
            //如果x方向上的绝对差值 > y方向上的绝对差值
            return xDiff + (yDiff - xDiff);
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(5, minTimeToVisitAllPoints(new int[][]{{3, 2}, {-2, 2}}));
    }
}
