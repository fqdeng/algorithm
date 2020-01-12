package com.demo.org.algorithm.integer.reverse;

import org.junit.Test;

import java.util.Stack;

//reverse the integer
public class Solution {

    //wrong 错误 TODO
    public int reverse(int x) {
        int anwser = 0;
        while (x != 0) {
            anwser = anwser * 10 + (x % 10);
            if (anwser > Integer.MAX_VALUE || anwser < Integer.MIN_VALUE){
                return 0;
            }
            x /= 10;
        }
        return anwser;
    }


    @Test
    public void testReverse() {
        System.out.println(reverse(1534236469));
    }
}
