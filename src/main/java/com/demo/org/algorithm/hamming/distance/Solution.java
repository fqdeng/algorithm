package com.demo.org.algorithm.hamming.distance;

import org.junit.Test;

public class Solution {


    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int a = x >> i;
            int b = y >> i;
            a = a & 1;
            b = b & 1;
            if (b!=a) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(hammingDistance(1,4));
    }
}
