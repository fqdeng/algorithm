package com.demo.org.algorithm.jump.game.i.v1;


import org.junit.Assert;
import org.junit.Test;

/**
 * 自顶向下
 */
public class Solution {

    private int[] nums;

    private boolean[] canNotJumpToLast;


    public boolean canJump(int[] nums) {
        canNotJumpToLast = new boolean[nums.length] ;
        this.nums = nums;
        return dp(0);
    }

    /**
     * 当前这个节点是否能跳到最后
     * @param position
     * @return
     */
    boolean dp(int position) {

        //退出的情况

        //跳出数组了 true
        if (position > nums.length - 1) {
            return true;
        }

        //刚好跳到最后一个
        if (position == nums.length - 1) {
            return true;
        }

        //节省运算
        if (canNotJumpToLast[position]) {
            return false;
        }

        //至少跳一步 跳0步没有意义
        //先跳最远看看
        for (int i = nums[position]; i > 0; i--) {
            //有一条路径能跳到最后 就表示当前节点能跳到最后 返回
            if (dp(position + i)) {
                return true;
            }
        }

        //一条都没有 记录下来 免得下次跳
        canNotJumpToLast[position] = true;
        return false;
    }

    @Test
    public void test() {
        Assert.assertTrue(canJump(new int[]{1, 1, 1, 1, 1}));
        Assert.assertFalse(canJump(new int[]{3, 2, 1, 0, 4}));
        Assert.assertTrue(canJump(new int[]{2,0,0}));
        Assert.assertTrue(canJump(new int[]{3, 0, 0, 0}));
    }

}
