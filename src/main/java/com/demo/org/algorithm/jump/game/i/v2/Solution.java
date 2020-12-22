package com.demo.org.algorithm.jump.game.i.v2;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //找到0的位置
            if (nums[i] == 0) {

                //i之前的所有位置都是大于0的 只要找到一个能直接跨过当前0位置的数 就可以跳过当前了
                boolean findOneCanJumpCurrentPosition = false;

                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] > i - j) {
                        findOneCanJumpCurrentPosition = true;
                        break;
                    }
                }

                if (!findOneCanJumpCurrentPosition) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        Assert.assertFalse(
                canJump(new int[]{0, 1}));
        Assert.assertTrue(
                canJump(new int[]{1, 1, 0}));
        Assert.assertTrue(canJump(new int[]{4, 2, 1, 0, 5}));
        Assert.assertFalse(canJump(new int[]{3, 2, 1, 0, 4}));
        Assert.assertTrue(canJump(new int[]{3, 0, 0, 0}));

    }
}
