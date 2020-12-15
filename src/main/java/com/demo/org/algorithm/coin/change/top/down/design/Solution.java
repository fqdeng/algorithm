package com.demo.org.algorithm.coin.change.top.down.design;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * top down design
 */
public class Solution {

    /**
     * store the optimal value , position is the amount
     */
    private int[] dpTable = null;

    /**
     * coins
     */
    private int[] coins = null;

    public int coinChange(int[] coins, int amount) {
        dpTable = new int[amount + 1];

        //initial dpTable -2
        Arrays.fill(dpTable, -2);
        this.coins = coins;
        return dp(amount);
    }

    /**
     * return the optimal value of current amount
     * @param amount
     * @return
     */
    private int dp(int amount) {
        //exit condition for dp
        if (amount == 0) {
            //if amount == 0, the optimal value is 0
            return 0;
        }
        if (amount < 0) {
            //if amount < 0, it means this path is a invalid path
            return -1;
        }

        //initialed value then return
        if (dpTable[amount] > -2){
            return dpTable[amount];
        }

        //initial result to max value, so you can pick the minimal result from dp
        int result = Integer.MAX_VALUE;

        boolean existValidPathFlag = false;

        for (int coin : coins) {
            int sub = 1 + dp(amount - coin);
            if (sub > 0) {
                existValidPathFlag = true;
            }
            if (sub == 0) {
                continue;
            }
            result = Math.min(result, sub);
        }

        if (existValidPathFlag) {
            //before return , you should store the optimal value to avoid repeat dp call
            dpTable[amount] = result;
            return result;
        }

        //if all sub path are invalid , it means current path is a invalid path
        dpTable[amount] = -1;
        return -1;
    }

    @Test
    public void test() {
        Assert.assertTrue(coinChange(new int[]{2}, 3) == -1);
        Assert.assertTrue(coinChange(new int[]{1}, 1) == 1);
        Assert.assertTrue(coinChange(new int[]{1}, 2) == 2);
        Assert.assertTrue(coinChange(new int[]{186,419,83,408}, 6249) == 20);
    }
}
