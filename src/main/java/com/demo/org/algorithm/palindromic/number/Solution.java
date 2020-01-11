package com.demo.org.algorithm.palindromic.number;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Solution {

    /**
     * 回文字符串
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String target = String.valueOf(x);
        Stack<Character> stack = new Stack<Character>();
        char[] chars = target.toCharArray();
        int middle = target.length() / 2;
        for (int i = 0; i < middle ; i++) {
            stack.push(chars[i]);
        }
        int start = middle;
        if (target.length() % 2 == 1){
            start++;
        }
        while(!stack.isEmpty()) {
            Character pop = stack.pop();
            if (!pop.equals(chars[start])){
                return false;
            }
            start++;
        }
        return true;
    }

    @Test
    public void testPalindrome(){
        Assert.assertTrue(isPalindrome(121));
        Assert.assertTrue(isPalindrome(121121));
        Assert.assertFalse(isPalindrome(1213));
        Assert.assertFalse(isPalindrome(1213208903));
        Assert.assertFalse(isPalindrome(1213208903));
    }


}
