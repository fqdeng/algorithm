package com.demo.org.algorithm.counting.bits;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[] countBits(int num) {
        int[] results = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (i < 2) {
                results[i] = i;
                continue;
            }
            if (i % 2 == 0) {
                results[i] = results[i/2];
            } else {
                results[i] = results[i - 1] + 1;
            }
        }
        return results;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(countBits(8)));
    }
}
