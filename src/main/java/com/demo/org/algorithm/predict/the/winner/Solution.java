package com.demo.org.algorithm.predict.the.winner;

import org.junit.Assert;
import org.junit.Test;

public class Solution {


    private int[] nums = null;

    /**
     * @param nums
     * @return
     * @link https://leetcode-cn.com/problems/predict-the-winner/
     * 依据题意 玩家1要必赢
     */
    public boolean PredictTheWinner(int[] nums) {
        this.nums = nums;
        return dfs(0, nums.length - 1, 0, 0, "firstPlayer");
    }

    /**
     * 当前决策 玩家1能否赢
     * @param low
     * @param high
     * @param firstPlayerScore
     * @param secondPlayerScore
     * @param character
     * @return
     */
    private boolean dfs(int low, int high, int firstPlayerScore, int secondPlayerScore, String character) {
        /*
         递归 只有终止的时候才返回结果
         */
        if (low == high) {
            if (character.equals("firstPlayer")) {
                firstPlayerScore += nums[low];
            } else {
                secondPlayerScore += nums[low];
            }
            return firstPlayerScore >= secondPlayerScore;
        }
        if (character.equals("firstPlayer")) {
            //首先这是一个颗决策树，玩家1是先手
            //所以玩家1只要有一个方向能赢就行
            return dfs(low, high - 1, firstPlayerScore + nums[high], secondPlayerScore, "secondPlayer")
                    || dfs(low + 1, high, firstPlayerScore + nums[low], secondPlayerScore, "secondPlayer");
        } else {
            //轮到玩家2选，要保证玩家1稳赢的话，就需要玩家2两个方向无论怎么选，都需要保证玩家1必赢
            return dfs(low, high - 1, firstPlayerScore, secondPlayerScore + nums[high], "firstPlayer")
                    && dfs(low + 1, high, firstPlayerScore, secondPlayerScore + nums[low], "firstPlayer");
        }
    }

    @Test
    public void test() {
        //Assert.assertFalse(PredictTheWinner(new int[]{1,5,2}));
        //Assert.assertTrue(PredictTheWinner(new int[]{1, 5, 233, 7}));
        //Assert.assertTrue(PredictTheWinner(new int[]{0}));
        Assert.assertTrue(PredictTheWinner(new int[]{1, 5, 2, 4, 6}));
    }


}
