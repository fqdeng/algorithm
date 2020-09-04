package com.demo.org.algorithm.subtract.the.product.and.sum.of.digits.of.an.integer;

import org.junit.Test;

public class Solution {
    public int subtractProductAndSum(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        int subtract = 1;
        if (n < 10){
            return 0;
        }
        while (true) {
            int current = n % 10;
            count += current;
            subtract *= current;
            n = n / 10;
            if (n < 10) {
                count += n;
                subtract *= n;
                break;
            }
        }
        int result = count - subtract;
        if (result < 0) result = -result;
        return result;
    }

    @Test
    public void test(){
        System.out.println(subtractProductAndSum(1));
    }
}