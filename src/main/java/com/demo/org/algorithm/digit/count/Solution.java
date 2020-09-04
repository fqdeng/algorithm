package com.demo.org.algorithm.digit.count;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int result = 0;
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j >= 10 ){
                int digit = j % 10;
                j = j / 10;
                if (check(k,digit)){
                    result++;
                }
            }
            int digit = j % 10;
            if (check(k,digit)){
                result++;
            }
        }
        return result;
    }

   private boolean check(int k , int digit){
       if ( k == digit){
           return true;
       }
       return false;
   }

    @Test
    public void test(){
        Assert.assertEquals(digitCounts(1,12),5);
    }
}
