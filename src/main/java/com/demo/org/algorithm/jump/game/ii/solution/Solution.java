package com.demo.org.algorithm.jump.game.ii.solution;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    private int[] nums;

    private int[] jumpToLastMiniSteps;

    public int jump(int[] nums) {
        jumpToLastMiniSteps = new int[nums.length];
        this.nums = nums;
        return dp(0);
    }

    /**
     * 当前这个位置 到末尾的最小值
     * @param position
     * @return
     */
    int dp(int position) {

        //退出的情况

        //跳出数组了 true
        if (position > nums.length - 1) {
            return -3;
        }

        //刚好跳到最后一个
        if (position == nums.length - 1) {
            return 0;
        }

        //节省运算
        if (jumpToLastMiniSteps[position] != 0) {
            return jumpToLastMiniSteps[position];
        }

        int min = Integer.MAX_VALUE;

        if (nums[position] == 0) {
            min = -1;
        }

        //至少跳一步 跳0步没有意义
        //先跳最远看看
        for (int i = 1; i <= nums[position]; i++) {
            int temp;
            int dp = dp(position + i);
            if (dp == -3) {
                temp = 1;
                min = Math.min(temp, min);
                break;
            }
            temp = 1 + dp;
            if (temp > 0) {
                min = Math.min(temp, min);
            }
        }

        jumpToLastMiniSteps[position] = min;
        return min;
    }

    @Test
    public void test() {
//        Assert.assertEquals(0, jump(new int[]{0}));
//        Assert.assertEquals(2, jump(new int[]{2, 3, 1, 1, 4}));
//        Assert.assertEquals(2, jump(new int[]{2, 3, 0, 1, 4}));
//        Assert.assertEquals(3, jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
        Assert.assertEquals(1, jump(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
    }
}
