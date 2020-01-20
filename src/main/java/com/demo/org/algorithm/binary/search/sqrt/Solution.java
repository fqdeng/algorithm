package com.demo.org.algorithm.binary.search.sqrt;

import org.junit.Assert;
import org.junit.Test;

public class Solution {


    /**
     * 二分查找 求平方根
     * @param num
     * @return
     */
    public double sqrt(int num) {
        //这个题应该要看精度 如果没有特殊的精度要求
        double low = 0;
        double high = num;
        while (low < high) {
            double mid = (low + high) / 2;
            if ((mid * mid) > num) {
                high = mid;
            } else if ((mid * mid) < num) {
                low = mid;
            } else {
                // mid * mid == num 因为我做这个题目时候会觉得这个条件可能永远不会成立
                // 但是 double 类型存在一个精度问题
                // 当 mid的精度到达一定位置时候 mid * mid 会得到一个整数 其刚好是num的近似平方根
                return mid;
            }
        }
        return -1;
    }


    @Test
    public void testSqrt() {
        System.out.println(sqrt(9));
        Assert.assertTrue(sqrt(110) == sqrt(110));
    }
}
